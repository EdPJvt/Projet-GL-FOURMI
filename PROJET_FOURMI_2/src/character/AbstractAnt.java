package character;


public abstract class AbstractAnt extends AbstractEntity{

	public AbstractAnt() {
		// TODO Auto-generated constructor stub
		
	}

	
	public void takeDamage(int damage) {
		this.setLives(this.getLives()-damage);
		
	}


}
