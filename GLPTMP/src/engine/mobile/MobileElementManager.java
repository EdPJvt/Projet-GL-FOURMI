package engine.mobile;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import entity.AbstractAnt;
import entity.AbstractEntity;
import entity.Predator;
import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author edgar.juvernat@cyu.etu.fr
 * 
 *
 */
public class MobileElementManager {
	private Map map;
	private List<Predator> enemies;
    private List<AbstractAnt> ants;
	private AbstractEntity controledant;

	public MobileElementManager(Map map) {
		this.map = map;
	}

	public void setControledAnt(AbstractEntity controledant) {
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

		if (position.getLine() > 0) {
			Block newPosition = map.getBlock(position.getLine() - 1, position.getColumn());
			controledant.setPosition(newPosition);
		}

	}

    public void moveDownEntity() {
		Block position = controledant.getPosition();

		if (position.getLine() < GameConfiguration.LINE_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine() + 1, position.getColumn());
			controledant.setPosition(newPosition);
        }
	}


	public void nextRound() {
	//	generatePredator();
		generateAnt();
	//	generateFoodSource();
	//	movePredator();
	}

 /*   private void generatePredator() {
		int randomColumn = getRandomNumber(0, GameConfiguration.COLUMN_COUNT - 1);
        int randomLine = getRandomNumber(0, GameConfiguration.LINE_COUNT - 1); 
		Block position = new Block(randomLine, randomColumn);
        while (EstOqp(Block)){
            randomColumn = getRandomNumber(0, GameConfiguration.COLUMN_COUNT - 1);
            randomLine = getRandomNumber(0, GameConfiguration.LINE_COUNT - 1); 
            position = new Block(randomLine, randomColumn);
        }     
		Predator predator = new Predator(position);
		enemies.add(enemy);
	}

*/
    private void generateAnt() {
        
    }

/*	private void movePredator() {

		List<Predator> outOfBoundEntity;

		for (Iterator<Predator> it= enemies.iterator(); it.hasNext();) {
			Block position = it.next().getPosition();
			Predator enemy=it.next();
			

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
*/


	public AbstractEntity getAnt() {
		return controledant;
	}
/*
	public List<AbstractEntities> getPredator() {
		return enemies;
	}

*/
	private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}


}
