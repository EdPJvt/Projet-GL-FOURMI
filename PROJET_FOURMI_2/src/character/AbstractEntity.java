package character;

import engine.map.Block;

public abstract class AbstractEntity {
	private int lives;
	private int damage;
	private int visionlevel;
	private int tauxPheromones;
	private Block position;
	private boolean waiting;

	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
	public int getDamage() {
		return this.damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getVisionlevel() {
		return visionlevel;
	}
	public void setVisionlevel(int visionlevel) {
		this.visionlevel = visionlevel;
	}
	public Block getPosition(){
		return position;
	}
	public void setPosition(Block newPosition) {
		this.position=newPosition; 
	}
	public int getTauxPheromones(){
		return tauxPheromones;
	}
	public void setTauxPheromones(int newTauxPheromones) {
		this.tauxPheromones = newTauxPheromones; 
	}
	
	abstract public Block search(String object);
	
	public boolean getWaiting() {
		return waiting;
	}
	
	public void setWaiting(boolean waiting) {
		this.waiting = waiting;
	}
	
	
	
	@Override
	public String toString() {
		return "AbstractEntities [lives=" + lives + ", damage=" + damage + ", visionlevel=" + visionlevel + ", [position = "+this.position.toString()+" ]";
	}
	
	
}
