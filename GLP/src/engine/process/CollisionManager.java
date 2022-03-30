package engine.process;

import engine.map.Block;

public class CollisionManager {
	
	public boolean isStuck(Block position,Block newposition){
		return newposition.getOccupied();
	}
}
