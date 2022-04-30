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
	private String occupant; 
	private int pheromones;
	
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
	
	public int getPheromones() {
		return pheromones;
	}
	
	public void addPheromones(int ajout) {
		if((this.getPheromones() + ajout) > 100) {
			this.pheromones += ajout;
		}
		//refresh pheromones timer;
		
	}
	
	public boolean getOccupied() {
		return occupied;
	}
	
	public void setOccupied(boolean bool, String occupant ) {
		this.occupied=bool;
		this.occupant = occupant;
	}
	
	public String getOccupant() {
		return this.occupant;
	}


	public boolean equals(Block position) {
		if(this.getLine()==position.getLine()) {
			if(this.getColumn()==position.getColumn()) {
				return true;
			}
		}
		return false;
		
	}
	
	@Override
	public String toString() {
		return "Block [line=" + line + ", column=" + column + "]";
	}

}
