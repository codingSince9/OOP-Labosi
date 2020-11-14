package hr.fer.oop.GameOfLife;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class BoardFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Board board;
	private int height;
	private int width;
	private SimulationThread sThread;
	private Thread thread;
	
	public BoardFrame() {
		setLocation(20,20);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		initGui();
	}

	
	
	
	private void initGui() {
		Container cp=getContentPane();
		cp.setLayout(new BorderLayout());
		
		JPanel buttonPanel= new JPanel();
		JButton play=new JButton("Pokreni");
		JButton stop=new JButton("Zaustavi");
		JButton oneMore=new JButton("Jedna iteracija");
		
		buttonPanel.add(play);
		buttonPanel.add(stop);
		stop.setEnabled(false);
		buttonPanel.add(oneMore);
		cp.add(buttonPanel,BorderLayout.NORTH);
		
		play.addActionListener((l)->{
			sThread= new SimulationThread(board);
			thread=new Thread(sThread);
			
			play.setEnabled(false);
			stop.setEnabled(true);
			oneMore.setEnabled(false);
			thread.start();
		});
		
		stop.addActionListener((l)->{
			sThread.setStop();
			play.setEnabled(true);
			stop.setEnabled(false);
			oneMore.setEnabled(true);
			sThread.start();
		});
		
		stop.addActionListener((l)->{
			board.playOneIteration();
		});
		
		board=new Board();
		height=board.getHeight();
		width=board.getWidth();
		
		JToggleButton[][] buttons= new JToggleButton[height][width];
		JPanel boardPanel =new JPanel();
		add(boardPanel,BorderLayout.CENTER);
		boardPanel.setLayout(new GridLayout(height,width,1,1));
		
		for(int i=0;i<height;++i) {
			for(int j=0;j<width;++j) {
				JToggleButton button= new JToggleButton();
				buttons[i][j]=button;
				button.setPreferredSize(new Dimension(20, 20));
				button.setActionCommand(String.format("%d %d", i,j));
				button.addActionListener((l)->{
					boolean alive=((JToggleButton)l.getSource()).isSelected();
					String[] coordinates= l.getActionCommand().split(" ");
					int x=Integer.parseInt(coordinates[0]);
					int y=Integer.parseInt(coordinates[1]);
					board.setCell(x, y, alive);
					System.out.println(x+","+y+"\nZivi susjedi: "+board.countAliveNeighbours(x, y)+"\nZiv ili mrtav: "+ alive);
				});
				boardPanel.add(button);
			}
		}
		
		board.addListener((l)->{
			boolean matrix[][] = new boolean[height][width];
			for (int i = 0; i<height; i++) {
				for (int j = 0; j<width;j++) {
					matrix[i][j] = l.isCellAlive(i, j);
				}
			}
		
		
		SwingUtilities.invokeLater(()->{
			for(int i=0;i<height;++i) {
				for(int j=0;j<width;++j) {
					buttons[i][j].setSelected(matrix[i][j]);
				}
			}
		});
		
	});
	}




	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			BoardFrame boardF =new BoardFrame();
			boardF.setVisible(true);
			boardF.pack();
		});
	}
}
