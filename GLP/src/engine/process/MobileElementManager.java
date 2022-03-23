package engine.process;


/*import java.util.HashMap;
import java.util.Iterator;*/
//import java.util.List;

import character.*;
import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author edgar.juvernat@etu.cyu.fr
 * 
 *
 */
public class MobileElementManager {
	private Map map;
	private ArrayList<AbstractEntity> ants;
//	private ArrayList<AbstractEntity> enemies;
	private AbstractEntity controledant= new Ant(new Block(1,1));

	public MobileElementManager(Map map) {
		this.map = map;
	}

	public void set(AbstractEntity controledant) {
		this.controledant = controledant;
	}

	public void moveLeftEntity() {
		Block position = controledant.getPosition();

		if (position.getColumn() > 0) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
			controledant.setPosition(newPosition);
		}

	}

	public void moveRightEntity() {
		Block position = controledant.getPosition();

		if (position.getColumn() < GameConfiguration.COLUMN_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);
			controledant.setPosition(newPosition);
		}
	}
	public void moveUpEntity() {
		Block position = controledant.getPosition();

		if (position.getColumn() < GameConfiguration.LINE_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine()-1, position.getColumn());
			controledant.setPosition(newPosition);
		}
	}
	public void moveDownEntity() {
		Block position = controledant.getPosition();

		if (position.getColumn() < GameConfiguration.LINE_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine()+1, position.getColumn());
			controledant.setPosition(newPosition);
		}
	}
	
	public AbstractEntity getEntity() {
		for(Iterator it=ants.iterator(); it.hasNext();) {
			//if( it.next().getPosition().equals(position) ) {
			//	
			//}
		}
		return this.controledant;
	}

/*	public void generateAnt() {
		int randColumn = getRandomNumber(0, GameConfiguration.COLUMN_COUNT - 1);
		int randLine = getRandomNumber(0, GameConfiguration.LINE_COUNT - 1);
		this.controledant = new Ant(new Block(randColumn, randLine));
	}

	public void nextRound() {
		generatePredator();
		generateAnt();
		generateFoodSource();
		moveEntity();
	}

private void generatePredator() {
		int randomColumn = getRandomNumber(0, GameConfiguration.COLUMN_COUNT - 1);
		Block position = new Block(0, randomColumn);
		Enemy enemy = new Enemy(position);
		add(enemy);
	}


	private void moveEntity() {

		List<AbstractEntity> outOfBoundEntity;

		for (Iterator<AbstractEntity> it= enemies.iterator(); it.hasNext();) {
			Block position = it.next().getPosition();
			AbstractEntity enemy=it.next();
			

			if (!map.isOnBottom(position)) {
				Block newPosition = map.getBlock(position.getLine() + 1, position.getColumn());
				enemy.setPosition(newPosition);
			} else {
				outOfBoundEntity.add(enemy);
			}

		}

		for (AbstractEntity enemy : outOfBoundEntity) {
			enemies.remove(enemy);
		}

	}



	public AbstractEntities getAnt() {
		return entity;
	}

	public List<AbstractEntities> getPredator() {
		return enemies;
	}
*/

	private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}


}