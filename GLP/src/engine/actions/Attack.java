package engine.actions;

import character.AbstractEntity;

public class Attack {

	public static void doAttack(int damage, AbstractEntity target) {
		target.setLives(target.getLives()-damage);
		
	}
	
}
