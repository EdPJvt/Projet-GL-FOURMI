package entity;

import engine.map.Block;
import engine.actions.Attack;

public abstract class AbstractAnt extends AbstractEntity{

	public AbstractAnt() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub

	}

	@Override
	public void attack(AbstractEntity entity) {
		// TODO Auto-generated method stub
		Attack.doAttack(this.getDamage(), entity);
	}
	
	public void takeDamage(int damage) {
		this.setLives(this.getLives()-damage);
		
	}

	@Override
	public void move(Block position) {
		// TODO Auto-generated method stub

	}

}
