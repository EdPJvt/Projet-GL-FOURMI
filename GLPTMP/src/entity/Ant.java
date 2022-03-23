package entity;

import engine.actions.Attack;
import engine.map.Block;

public class Ant extends AbstractEntity {
	
	private Block position;
	public Ant(Block position) {
		// TODO Auto-generated constructor stub
		this.position=position;
	}

	@Override
	public void search() {
		

	}

	@Override
	public void attack(AbstractEntity entity) {
		Attack.doAttack(this.getDamage(), entity);

	}

	@Override
	public void move(Block newposition) {
		this.setPosition(newposition);

	}

}
