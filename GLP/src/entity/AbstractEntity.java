package entity;

import engine.map.Block;

public abstract class AbstractEntity {
	private int lives;
	private int damage;
	private int visionlevel;
	private Block position;
	

    public boolean hasNoLife(){
        return lives=0;
    }
	
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
	public Block getPosition() {
		return position;
	}
	public void setPosition(Block newPosition) {
		this.position=newPosition; 
	}
	
	abstract public void search();
	abstract public void attack(AbstractEntity entity);
	abstract public void move(Block newposition);
	
	
	@Override
	public String toString() {
		return "AbstractEntities [lives=" + lives + ", damage=" + damage + ", visionlevel=" + visionlevel + ", [position = "+this.position.toString()+" ]";
	}
	
	
}
