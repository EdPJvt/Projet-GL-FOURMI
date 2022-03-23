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
import java.util.List;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author edgar.juvernat@etu.cyu.fr
 * 
 *
 */
public class MobileElementManager {
	private Map map;
	private ArrayList<Ant> ants= new ArrayList<Ant>();
//	private ArrayList<AbstractEntity> enemies;
	private AbstractEntity controledant= new Ant(new Block(1,1));
	private ArrayList<Block> fourmilieres= new ArrayList<Block>();

	public MobileElementManager(Map map) {
		this.map = map;
		initFourmiliere();
		initAnts();
	}
	
	
	
	
	public void initFourmiliere() {
		fourmilieres.add(GameConfiguration.DEFAULTSPAWN);
	}
	public void initAnts() {
		ants.add(new Ant(fourmilieres.get(0)));
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
	

	public void generateAnt() {
		int random = getRandomNumber(0, fourmilieres.size()-1);
		this.ants.add(new Ant(fourmilieres.get(random)));
	}

	public void nextRound() {
		//generatePredator();
		generateAnt();
		//generateFoodSource();
		moveAnt();
	}
/*
private void generatePredator() {
		int randomColumn = getRandomNumber(0, GameConfiguration.COLUMN_COUNT - 1);
		Block position = new Block(0, randomColumn);
		Enemy enemy = new Enemy(position);
		add(enemy);
	}


*/	private void moveAnt() {
		ArrayList<Ant> outOfBoundAnts = new ArrayList<Ant>();
		for (Ant tmpant : ants) {
			Block position= tmpant.getPosition();
			Block newPosition;
			
			int random=getRandomNumber(0,3);
			
			if (!map.isOnBorder(position)) {
				
				switch(random){
				case 0:
					newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
					tmpant.setPosition(newPosition);
					break;
				case 1:
					newPosition = map.getBlock(position.getLine() - 1, position.getColumn());
					tmpant.setPosition(newPosition);
					break;
				case 2:
					newPosition = map.getBlock(position.getLine() , position.getColumn() + 1);
					tmpant.setPosition(newPosition);
					break;
				default:
					newPosition = map.getBlock(position.getLine() + 1, position.getColumn());
					tmpant.setPosition(newPosition);
					break;
				}
				
				}
			else {
				switch(random){
				case 0:
					if(!map.isOnLeftBorder(position)) {
						newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
						tmpant.setPosition(newPosition);
						break;
					}
					outOfBoundAnts.add(tmpant);
				case 1:
					if(!map.isOnTop(position)) {
						newPosition = map.getBlock(position.getLine()-1, position.getColumn() );
						tmpant.setPosition(newPosition);
						break;
					}
					outOfBoundAnts.add(tmpant);
				case 2:
					if(!map.isOnRightBorder(position)) {
						newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);
						tmpant.setPosition(newPosition);
						break;
					}
					outOfBoundAnts.add(tmpant);
				default:
					if(!map.isOnBottom(position)) {
						newPosition = map.getBlock(position.getLine() + 1, position.getColumn());
						tmpant.setPosition(newPosition);
						break;
					}
					outOfBoundAnts.add(tmpant);
				}
				
			}
			
		} 
		for (Ant ant : outOfBoundAnts) {
			ants.remove(ant);
		}
		
	}

		
		
		

		
////////
	



	public AbstractEntity getAnt() {
		return this.controledant;
	}
	
	public ArrayList<Ant> getAnts() {
		return ants;
	}

/*	public List<AbstractEntity> getPredator() {
		return enemies;
	}
*/
	public ArrayList<Block> getFourmilieres(){
		return fourmilieres;
	}

	private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}


}