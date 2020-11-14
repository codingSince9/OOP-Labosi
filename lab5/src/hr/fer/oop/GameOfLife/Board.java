package hr.fer.oop.GameOfLife;

import java.util.LinkedList;

public class Board {
	private int height;
	private int width;
	private boolean[][] matrix;
	private LinkedList<BoardListener> listeners;
	
	public Board(int height,int weight) {
		this.height=height;
		this.width=weight;
		matrix =new boolean[height][weight];
		listeners=new LinkedList<>();
	}	
	public Board() {
		this(30,30);
	}
	
	public boolean isCellAlive(int x,int y) {
		int i=Math.floorMod(x, height);
		int j=Math.floorMod(y, width);
		return matrix[i][j];
	}
	
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	
	public void setCell(int x,int y, boolean alive) {
		matrix[x][y]=alive;
	}
	public int countAliveNeighbours(int x,int y) {
		int counter=0;
		if (isCellAlive(x-1, y-1)) ++counter;
		if (isCellAlive(x-1, y)) ++counter;
		if (isCellAlive(x-1, y+1)) ++counter;
		if (isCellAlive(x, y-1)) ++counter;
		if (isCellAlive(x, y+1)) ++counter;
		if (isCellAlive(x+1, y-1)) ++counter;
		if (isCellAlive(x+1, y)) ++counter;
		if (isCellAlive(x+1, y+1)) ++counter;
		return counter;
	}
	public void playOneIteration() {
		boolean tmpmatrix[][]=new boolean[height][width];
		for (int i=0;i<height;++i) {
			for (int j=0;j<width;++j) {
				int aliveNeighbours=countAliveNeighbours(i, j);
				if (isCellAlive(i, j)) {
					if (aliveNeighbours<2 || aliveNeighbours>3) {
						tmpmatrix[i][j]=false;
					}else tmpmatrix[i][j]=true;
				}else {
					if (aliveNeighbours==3) {
						tmpmatrix[i][j]=true;
					} else tmpmatrix[i][j]=false;
				}
			}
		}
		matrix=tmpmatrix;
		listeners.forEach(l->l.boardChanged(this));
	}
	
	public void addListener(BoardListener listener) {
		listeners.add(listener);
	}
	public void  removeListener(BoardListener listener) {
		listeners.remove(listener);
	}
}
