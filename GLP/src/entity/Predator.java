package entity;

public class Predator extends AbstractEntity{

    private Block position2;

    setPostion(Block newposition){
        this.position = newposition ;
        this.position2 = new Block(this.position.getLine()+1, this.position.getColumn()+1);  
    }

}
