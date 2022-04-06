package character;

import java.util.ArrayList;

import engine.map.Block;

public class Ant extends AbstractEntity{

	public Ant(Block pos) {
		this.setPosition(pos);
	}
	public void search() {
		ArrayList<Block> vision = new ArrayList<Block>() ;
		switch(this.getVisionlevel()){
		case 0:
			//5 cases
			break;
		case 1:
			//9 cases
			break;
		case 2:
			//21 cases
			break;
		case 3:
			//25 cases		
			break;
		}
	}

}
