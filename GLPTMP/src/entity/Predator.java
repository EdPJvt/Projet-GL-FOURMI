package entity;

import engine.map.Block;

public class Predator extends AbstractEntity{

    private Block position2;
    
    public Predator(Block position){
    	this.position = position;
    	this.position2 = new Block(position.getLine()+1, position.getColumn()+1);
    	
    }

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(AbstractEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(Block newposition) {
		// TODO Auto-generated method stub
		this.position = newposition ;
        this.position2 = new Block(this.position.getLine()+1, this.position.getColumn()+1);
	}

}
