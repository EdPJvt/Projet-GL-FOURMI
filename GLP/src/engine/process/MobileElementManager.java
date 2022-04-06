package engine.process;


/*import java.util.HashMap;
import java.util.Iterator;*/
//import java.util.List;

import character.*;
import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;

import java.util.ArrayList;


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
	private AbstractEntity controledant= new Ant(new Block(1,1));
	private ArrayList<Block> predators = new ArrayList<Block>();
	private ArrayList<Block> stoneObstacles = new ArrayList<Block>(); 
	private ArrayList<Block> fourmilieres= new ArrayList<Block>();
	private ArrayList<Block> foodsources= new ArrayList<Block>(GameConfiguration.FOOD_MAX_NUMBER);

	public MobileElementManager(Map map) {
		this.map = map;
		initFourmiliere();
		initAnts();
	}
	
	public void initFourmiliere() {
		fourmilieres.add(GameConfiguration.DEFAULT_SPAWN);
	}
	public void initAnts() {
		ants.add(new Ant(fourmilieres.get(0)));
	}
	
	
	public void gamePreparation(){
		generatePredator();
		generateFoodSource();
		generateAnt();
		generateStoneObstacles();

		
	}
	public void nextRound() {
		generateAnt();
		moveAnt();
	}
	

	public void set(AbstractEntity controledant) {
		this.controledant = controledant;
	}

	//Generate methods
	
	public void generateFoodSource() {
		int x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
		int y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
		Block position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE) ;
		while(position.getOccupied()) {
			x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
			y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
			position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE) ;
		}
		int i;
		for(i=0 ; i<GameConfiguration.FOOD_MAX_NUMBER ; i++){
			foodsources.add(new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE));
			position.setOccupied(true);
			while(position.getOccupied()) {
				x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
				y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
				position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE) ;
			}
		}
	}
	
	public void generateAnt() {
		int random = getRandomNumber(0, fourmilieres.size()-1);
		Block position = fourmilieres.get(random);
		this.ants.add(new Ant(position));
	}
	
	
	private void generatePredator() {
		int x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
		int y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
		Block position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE) ;
		while(position.getOccupied()) {
			x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
			y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
			position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE) ;
		}
		int i;
		for(i=0 ; i<GameConfiguration.PREDATOR_MAX_NUMBER ; i++){
			predators.add(new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE));
			position.setOccupied(true);
			while(position.getOccupied()) {
				x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
				y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
				position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE) ;
			}
		}
	}
	
	private void generateStoneObstacles() {
		int x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
		int y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
		Block position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE) ;
		while(position.getOccupied()) {
			x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
			y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
			position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE) ;
		}
		int i;
		for(i=0 ; i<GameConfiguration.STONE_OBSTACLES_MAX_NUMBER ; i++){
			stoneObstacles.add(new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE));
			position.setOccupied(true);
			while(position.getOccupied()) {
				x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
				y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
				position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE) ;
			}
		}
	}
	


	

	//Get Methods



	public AbstractEntity getAnt() {
		return this.controledant;
	}
	
	public ArrayList<Ant> getAnts() {
		return ants;
	}

	public ArrayList<Block> getPredator() {
		return predators;
	}

	public ArrayList<Block> getFourmilieres(){
		return fourmilieres;
	}
	
	public ArrayList<Block> getFoodSources(){
		return foodsources;
	}

	private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}
	
	public ArrayList<Block> getStoneObstacles() {
		return stoneObstacles;
	}
	
	
	
	//Movement methods
	
	
	
	
	public void moveLeftEntity() {
		Block position = controledant.getPosition();

		if (position.getColumn() > 0) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
			controledant.setPosition(newPosition);
			position.addPheromones(controledant.getTauxPheromones());
		}

	}

	public void moveRightEntity() {
		Block position = controledant.getPosition();

		if (position.getColumn() < GameConfiguration.COLUMN_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);
			controledant.setPosition(newPosition);
			position.addPheromones(controledant.getTauxPheromones());
		}
	}
	public void moveUpEntity() {
		Block position = controledant.getPosition();

		if (position.getColumn() < GameConfiguration.LINE_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine()-1, position.getColumn());
			controledant.setPosition(newPosition);
			position.addPheromones(controledant.getTauxPheromones());
		}
	}
	public void moveDownEntity() {
		Block position = controledant.getPosition();

		if (position.getColumn() < GameConfiguration.LINE_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine()+1, position.getColumn());
			controledant.setPosition(newPosition);
			position.addPheromones(controledant.getTauxPheromones());
		}
	}
	private void moveAnt() {
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
					position.addPheromones(tmpant.getTauxPheromones());
					
					break;
				case 1:
					newPosition = map.getBlock(position.getLine() - 1, position.getColumn());
					tmpant.setPosition(newPosition);
					position.addPheromones(tmpant.getTauxPheromones());

					break;
				case 2:
					newPosition = map.getBlock(position.getLine() , position.getColumn() + 1);
					tmpant.setPosition(newPosition);
					position.addPheromones(tmpant.getTauxPheromones());

					break;
				default:
					newPosition = map.getBlock(position.getLine() + 1, position.getColumn());
					tmpant.setPosition(newPosition);
					position.addPheromones(tmpant.getTauxPheromones());

					break;
				}
				
			}
			else {
				switch(random){
				case 0:
					if(!map.isOnLeftBorder(position)) {
						newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
						tmpant.setPosition(newPosition);
						position.addPheromones(tmpant.getTauxPheromones());

						break;
					}
					outOfBoundAnts.add(tmpant);
				case 1:
					if(!map.isOnTop(position)) {
						newPosition = map.getBlock(position.getLine()-1, position.getColumn() );
						tmpant.setPosition(newPosition);
						position.addPheromones(tmpant.getTauxPheromones());

						break;
					}
					outOfBoundAnts.add(tmpant);
				case 2:
					if(!map.isOnRightBorder(position)) {
						newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);
						tmpant.setPosition(newPosition);
						position.addPheromones(tmpant.getTauxPheromones());

						break;
					}
					outOfBoundAnts.add(tmpant);
				default:
					if(!map.isOnBottom(position)) {
						newPosition = map.getBlock(position.getLine() + 1, position.getColumn());
						tmpant.setPosition(newPosition);
						position.addPheromones(tmpant.getTauxPheromones());

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

	

}
