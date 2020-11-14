package hr.fer.oop.GameOfLife;

public class SimulationThread extends Thread {
	private  boolean stop=false;
	private Board board;
	
	public SimulationThread(Board board) {
		this.board=board;
	}
	@Override
	public void run() {
		while(!stop) {
			board.playOneIteration();
			try {
				Thread.sleep(500);
			}catch(InterruptedException ex) {
				System.out.println("probudio se");
				ex.printStackTrace();	
			}
		}
	}
	public synchronized void setStop() {
		stop=true;
	}

}
