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
	private ArrayList<Ant> ants;
	private AbstractEntity controledant= new Ant(new Block(1,1));
	private ArrayList<Block> predators = new ArrayList<Block>() ;
	private ArrayList<Block> stoneObstacles = new ArrayList<Block>() ; 
	private ArrayList<Block> fourmilieres = new ArrayList<Block>();
	private ArrayList<Block> foodsources = new ArrayList<Block>() ;
	private GenerationManager generationManager = new GenerationManager() ;
	private ArrayList<Block> movingFood = new ArrayList<Block>();

	public MobileElementManager(Map map) {
		this.map = map;
		initFourmiliere();
		gamePreparation();
		initAnts();
	}
	
	public void initFourmiliere() {
		fourmilieres.add(GameConfiguration.DEFAULT_SPAWN);
	}
	
	public void initAnts() {
		ants.add(new Ant(fourmilieres.get(0)));
	}
	
	
	public void gamePreparation(){
		ants = generationManager.generateAnt(fourmilieres);
		foodsources = generationManager.generateFoodSource();
		predators = generationManager.generatePredator();
		
		stoneObstacles = generationManager.generateStoneObstacles();

		
	}
	public void nextRound() {
		ants.addAll(generationManager.generateAnt(fourmilieres));
		moveAnt();
	}
	

	public void set(AbstractEntity controledant) {
		this.controledant = controledant;
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
			Block newPosition = position;
			if(!tmpant.getWaiting()) {
				
			
				int random=getRandomNumber(0,3);
			
				if (!map.isOnBorder(position)) {
				
					switch(random){
					case 0:
						newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
						break;
					case 1:
						newPosition = map.getBlock(position.getLine() - 1, position.getColumn());
						break;
					case 2:
						newPosition = map.getBlock(position.getLine() , position.getColumn() + 1);

						break;
					default:
						newPosition = map.getBlock(position.getLine() + 1, position.getColumn());
						break;
					}
				
				}
				else {
					switch(random){
					case 0:
						if(!map.isOnLeftBorder(position)) {
							newPosition = map.getBlock(position.getLine(), position.getColumn() - 1);
							break;
						}
						outOfBoundAnts.add(tmpant);
						break;
					case 1:
						if(!map.isOnTop(position)) {
							newPosition = map.getBlock(position.getLine()-1, position.getColumn() );

							break;
						}
						outOfBoundAnts.add(tmpant);
						break;
					case 2:
						if(!map.isOnRightBorder(position)) {
							newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);

							break;
						}
						outOfBoundAnts.add(tmpant);
						break;
					default:
						if(!map.isOnBottom(position)) {
							newPosition = map.getBlock(position.getLine() + 1, position.getColumn());

							break;
						}
						outOfBoundAnts.add(tmpant);
						break;
					}
				
				}
			
				if (newPosition.getOccupied()) {
					String occupant = newPosition.getOccupant() ;
					Block position2;
					ArrayList<Block> aroundOccupant = new ArrayList<Block>();
					int line = newPosition.getLine();
					int column = newPosition.getColumn();
					aroundOccupant.add(new Block(line, column));
					aroundOccupant.add(new Block(line+1, column));
					aroundOccupant.add(new Block(line, column+1));
					aroundOccupant.add(new Block(line-1, column));
					aroundOccupant.add(new Block(line, column-1));

					switch(occupant) {
						case("food"):
						
							position2 = tmpant.search("ant");
							if(aroundOccupant.contains(position2) ) {
								outOfBoundAnts.add(tmpant);
								foodsources.remove(newPosition);
								outOfBoundAnts.add(new Ant(position2));	
								movingFood.add(newPosition);
							}
							tmpant.setWaiting(true);
							break;
						case("predator"):
							outOfBoundAnts.add(tmpant);
							break;
						
						default: 
							newPosition = tmpant.getPosition(); 
							break;
					}
				
				}
				tmpant.setPosition(newPosition);
				position.addPheromones(tmpant.getTauxPheromones());

			
			} 
			
		
		}
		for (Ant ant : outOfBoundAnts) {
			ants.remove(ant);
		}
	}

	

}
