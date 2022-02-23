package entity;

import engine.actions.Attack;
import engine.map.Block;

public class Ant extends AbstractEntity {

	public Ant() {
		// TODO Auto-generated constructor stub
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
