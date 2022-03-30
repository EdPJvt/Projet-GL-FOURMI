package engine.map;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author tianxiao.liu@cyu.fr
 *
 */
public class Block {
	private int line;
	private int column;
	private boolean occupied;

	public Block(int line, int column) {
		this.line = line;
		this.column = column;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	public boolean equals(Block position) {
		if(this.getLine()==position.getLine()) {
			if(this.getColumn()==position.getColumn()) {
				return true;
			}
		}
		return false;
		
	}
	
	public boolean getOccupied() {
		return occupied;
	}
	
	public void setOccupied(boolean bool) {
		this.occupied=bool;
	}
	@Override
	public String toString() {
		return "Block [line=" + line + ", column=" + column + "]";
	}

}
