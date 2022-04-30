package character;

import java.util.ArrayList;

import engine.map.Block;

public class Ant extends AbstractEntity{

	public Ant(Block pos, int lives, int damage, int visionlevel, int tauxPheromones) {
		this.setLives(lives);
		this.setDamage(damage);
		this.setVisionlevel(visionlevel);
		this.setTauxPheromones(tauxPheromones);
		this.setPosition(pos);
		
	}
	
	public Ant(Block position) {
		this.setPosition(position);
	}
	
	public Block search(String object) {
		
		ArrayList<Block> vision = new ArrayList<Block>() ;
		Block position = this.getPosition();
		int line = position.getLine();
		int column = position.getColumn();
		
		vision.add(position);
		vision.add(new Block(line+1, column ));
		vision.add(new Block(line, column+1 ));
		vision.add(new Block(line-1, column ));
		vision.add(new Block(line, column-1));
		
		vision.add(new Block(line+1, column+1  ));
		vision.add(new Block(line+1, column-1  ));
		vision.add(new Block(line-1, column+1  ));
		vision.add(new Block(line-1, column-1  ));
		
		vision.add(new Block(line+2, column  ));
		vision.add(new Block(line+2, column+1  ));
		vision.add(new Block(line+2, column-1  ));
		vision.add(new Block(line-2, column  ));
		vision.add(new Block(line-2, column+1  ));
		vision.add(new Block(line-2, column-1  ));
		vision.add(new Block(line, column+2  ));
		vision.add(new Block(line+1, column+2  ));
		vision.add(new Block(line-1, column+2  ));
		vision.add(new Block(line, column-2  ));
		vision.add(new Block(line+1, column-2  ));
		vision.add(new Block(line-1, column-2  ));

		int i=0;
		Block position2 = position;
		switch(this.getVisionlevel()){
		
		case 0:
			for(i=0; i<5; i++){
				position2 = vision.get(i);
				if(position2.getOccupied() ) {
					if( position2.getOccupant() == object ) {
						return position2;
					}
					
				}
			}
			break;
			
		case 1:
			for(i=0; i<9; i++){
				position2 = vision.get(i);
				if(position2.getOccupied() ) {
					if( position2.getOccupant() == object ) {
						return position2;
					}
					
				}
			}
			break;
			
		case 2:
			for(i=0; i<21; i++){
				position2 = vision.get(i);
				if(position2.getOccupied() ) {
					if( position2.getOccupant() == object ) {
						return position2;
					}
					
				}
			}			
			break;
			
		}
		
		return position;
	}

}
