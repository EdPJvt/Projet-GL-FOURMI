package engine.actions;

import entity.AbstractEntity;

public class Attack {

	public static void doAttack(int damage, AbstractEntity target) {
		target.setLives(target.getLives()-damage);
        if ( target.hasNoLife() ){
           // delete(target);
        }
		
	}
	
}
