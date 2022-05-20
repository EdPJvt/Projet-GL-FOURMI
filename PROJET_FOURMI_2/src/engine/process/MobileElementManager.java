package engine.process;


/*import java.util.HashMap;
import java.util.Iterator;*/
//import java.util.List;

import character.*;
import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import gui.PaintStrategy;

import java.lang.System.Logger.Level;
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
	
	private String selected = "" ;
	private boolean paused= false;

	public MobileElementManager(Map map) {
		this.map = map;
		initFourmiliere();
		gamePreparation();
		initAnts();
	}
	
	public void initFourmiliere() {
		fourmilieres.add(GameConfiguration.DEFAULT_SPAWN);
		GameConfiguration.DEFAULT_SPAWN.setOccupied(true, "anthill");
	}
	
	public void initAnts() {
		ants.add(new Ant(fourmilieres.get(0)));
	}
	
	
	public void gamePreparation(){
		ants = generationManager.generateAnts(fourmilieres);
		
		stoneObstacles = generationManager.generateStoneObstacles();
		foodsources = generationManager.generateFoodSources();
		predators = generationManager.generatePredators();

		
	}
	public void nextRound() {
		if(!paused) {
			ants.addAll(generationManager.generateAnts(fourmilieres));
			moveAnt();
			moveFood();
			
		}
		
		
	}
	

	public void set(AbstractEntity controledant) {
		this.controledant = controledant;
	}

	
	//set methods
	public void setSelected(String tmp) {
		selected = tmp;
	}
	
	public void setPaused(boolean bool) {
		paused = bool;
	}
	
	
	
	
	//others methods
	public void generateItem(Block position) {
		
		switch(selected){
		case "Ant":
			Ant tmp = generationManager.generateAnt(position);
			this.ants.add(tmp);
			break;
		case "Predator":
			generationManager.generatePredator(position);
			this.predators.add(position);
			break;
		case "Food":
			generationManager.generateFoodSource(position);
			this.foodsources.add(position);

			break;
		case "Stone":
			generationManager.generateStoneObstacle(position);
			this.stoneObstacles.add(position);
			break;
		case "Anthill":
			generationManager.generateAnthill(position);
			this.fourmilieres.add(position);

		default:
			break;
		}
	}
	
	
	
	public Block getDirection(Ant ant) {
		ArrayList<Block> vision = ant.getVision();
		Block position = vision.get(0);
		for (Block visiblePos : vision) {
			position = visiblePos;
			int pheromax = position.getPheromones();
			int phero1 = visiblePos.getPheromones();
			if(pheromax< phero1) {
				position = visiblePos;
			}
		}
		return position;
	}

	//Get Methods
	
	public String getSelected() {
		return selected;
	}


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
			if(!newPosition.getOccupied()) {
				controledant.setPosition(newPosition);
				position.addPheromones(controledant.getTauxPheromones());
			}
		}

	}

	public void moveRightEntity() {
		Block position = controledant.getPosition();

		if (position.getColumn() < GameConfiguration.COLUMN_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine(), position.getColumn() + 1);
			if(!newPosition.getOccupied()) {
				controledant.setPosition(newPosition);
				position.addPheromones(controledant.getTauxPheromones());
			}
		}
	}
	public void moveUpEntity() {
		Block position = controledant.getPosition();

		if (position.getColumn() < GameConfiguration.LINE_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine()-1, position.getColumn());
			if(!newPosition.getOccupied()) {
				controledant.setPosition(newPosition);
				position.addPheromones(controledant.getTauxPheromones());
			}
		}
	}
	public void moveDownEntity() {
		Block position = controledant.getPosition();

		if (position.getColumn() < GameConfiguration.LINE_COUNT - 1) {
			Block newPosition = map.getBlock(position.getLine()+1, position.getColumn());
			if(!newPosition.getOccupied()) {
				controledant.setPosition(newPosition);
				position.addPheromones(controledant.getTauxPheromones());
			}
		}
	}
	private void moveAnt() {
		ArrayList<Ant> outOfBoundAnts = new ArrayList<Ant>();
		for (Ant tmpant : ants) {
			Block position= tmpant.getPosition();
			Block newPosition = position;
			if(!tmpant.getWaiting()) {
				
				
			
					
					int random=getRandomNumber(0, 3);
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
						if(!newPosition.getOccupied()) {
							tmpant.setPosition(newPosition);
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
				else {
					tmpant.setPosition(newPosition);
				}
				tmpant.setPosition(newPosition);
				position.addPheromones(tmpant.getTauxPheromones());

			
			} 
			
		
		
		for (Ant ant : outOfBoundAnts) {
			ants.remove(ant);
		}
	}
	
	private void moveFood() {
		int i = 0;
		Block position, pos2, pos3,pos4, pos5, toGo;
		int toGoPhero;
		ArrayList<Block> toDelete = new ArrayList<Block>();
		for(i=0; i<movingFood.size() ; i++) {
			position = movingFood.get(i);
			pos2 = new Block(position.getLine(), position.getColumn());
			pos3 = new Block(position.getLine(), position.getColumn());
			pos4 = new Block(position.getLine(), position.getColumn());
			pos5 = new Block(position.getLine(), position.getColumn());
			toGo = pos2;
			toGoPhero = toGo.getPheromones();
			if(pos3.getPheromones() > toGoPhero) {
				pos3=toGo;
			}
			if(pos4.getPheromones() > toGoPhero) {
				pos4=toGo;
			}
			if(pos5.getPheromones() > toGoPhero) {
				pos5=toGo;
			}
			
			movingFood.add(toGo);
			toDelete.add(position);
			
		}
		
		deleteFood(toDelete);
	}
	
	private void deleteFood(ArrayList<Block> toDelete) {
		int i;
		for(i=0; i< toDelete.size(); i++) {
			toDelete.remove(i);
		}
		
	}
	

	

}
