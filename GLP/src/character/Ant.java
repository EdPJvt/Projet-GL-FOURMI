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
	public void search() {
		ArrayList<Block> vision = new Arraylist<Block>() ;
		switch(visionlevel){
		case 0:
			//5 cases
			break;
		case 1:
			//9 cases
			break;
		case 2:
			//21 cases
			break;
		case 2:
			//25 cases		
			break;
		}
	}

}
