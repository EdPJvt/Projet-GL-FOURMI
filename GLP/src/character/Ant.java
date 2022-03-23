package character;

import engine.actions.Attack;
import engine.map.Block;

public class Ant extends AbstractEntity{

	public Ant(Block pos) {
		this.setPosition(pos);
	}


	@Override
	public void attack(AbstractEntity entity) {
		Attack.doAttack(this.getDamage(), entity);

	}

	@Override
	public void move(Block newposition) {
		this.setPosition(newposition);

	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}

}
