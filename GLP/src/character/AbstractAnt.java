package character;


public abstract class AbstractAnt extends AbstractEntity{

	public AbstractAnt() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub

	}
	
	public void takeDamage(int damage) {
		this.setLives(this.getLives()-damage);
		
	}


}
