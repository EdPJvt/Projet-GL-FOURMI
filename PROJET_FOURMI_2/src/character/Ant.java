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
		ArrayList<Block> vision= this.getVision();
		Block position = this.getPosition();
		int line = position.getLine();
		int column = position.getColumn();
		

		int i=0;
		Block position2 = position;
		for(i=0; i<vision.size(); i++){
				
			position2 = vision.get(i);
			if(position2.getOccupied() ) {
				if( position2.getOccupant() == object ) {
					return position2;
				}
					
			}
		}			
		
		
		return position;
	}
	
	
	

	public ArrayList<Block> getVision(){
		ArrayList<Block> vision = new ArrayList<Block>() ;
		ArrayList<Block> vision2 = new ArrayList<Block>() ;
		int line = this.getPosition().getLine();
		int column = this.getPosition().getColumn();
		int i;

		
		vision.add(this.getPosition());
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
	
	switch(this.getVisionlevel()) {
	case 0:
		for(i=0; i<5; i++){
			vision2.add(vision.get(i));
		}
		break;
	case 1:
		for(i=0; i<9; i++){
			vision2.add(vision.get(i));
		}
		break;
	case 2:
		for(i=0; i<21; i++){
			vision2.add(vision.get(i));
		}
		break;
		
		
	}
	return vision2;
	}
}
