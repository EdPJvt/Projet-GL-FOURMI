package character;

import engine.map.Block;

public abstract class AbstractAnt extends AbstractEntity{

	public AbstractAnt() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub

	}
	
	public void takeDamage(int damage) {
		this.setLives(this.getLives()-damage);
		
	}

	@Override
	public void move(Block position) {
		// TODO Auto-generated method stub

	}

}
