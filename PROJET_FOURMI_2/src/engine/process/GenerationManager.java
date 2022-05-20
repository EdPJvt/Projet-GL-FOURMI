package engine.process;

import java.util.ArrayList;

import character.*;
import config.GameConfiguration;
import engine.map.Block;

public class GenerationManager {
	
	public GenerationManager() {}

		
	
	public  ArrayList<Block> generateFoodSources() {
		int blocksize = GameConfiguration.BLOCK_SIZE;
		int y = getRandomNumber(0,GameConfiguration.WINDOW_HEIGHT);
		int x = getRandomNumber(0,GameConfiguration.WINDOW_WIDTH);
		ArrayList<Block> foodsources = new ArrayList<Block>(GameConfiguration.FOOD_MAX_NUMBER) ;
		
		Block position = new Block(x/blocksize,y/blocksize) ;
		while(position.getOccupied()) {
			y = getRandomNumber(0,GameConfiguration.WINDOW_HEIGHT);
			x = getRandomNumber(0,GameConfiguration.WINDOW_WIDTH);
			position = new Block(x/blocksize,y/blocksize) ;
		}
		int i;
		for(i=0 ; i<GameConfiguration.FOOD_MAX_NUMBER ; i++){
			foodsources.add(new Block(x/blocksize,y/blocksize));
			position.setOccupied(true, "food");
			while(position.getOccupied()) {
				y = getRandomNumber(0,GameConfiguration.WINDOW_HEIGHT);
				x = getRandomNumber(0,GameConfiguration.WINDOW_WIDTH);
				position = new Block(x/blocksize,y/blocksize) ;
			}
		}
		return foodsources;
	}
	
	public void generateFoodSource(Block position) {
		position.setOccupied(true, "food");
	}
	
	
	
	
	
	public  ArrayList<Ant> generateAnts(ArrayList<Block> fourmilieres) {
		int random = getRandomNumber(0, fourmilieres.size()-1);
		 ArrayList<Ant> ants= new ArrayList<Ant>();
		
		Block position = fourmilieres.get(random);
		ants.add(generateRandomAnt(position));
		return ants;
	}
	
	public Ant generateAnt(Block tmp) {
		Ant ant = generateRandomAnt(tmp);
		return ant;
	}
	
	
	
	public  Ant generateRandomAnt(Block position) {
		int random = getRandomNumber(0,20);
		Ant ant = new Ant(position, 0, 0, 0, 0);
		if(random <=10) {
			ant = new Ant(position, 1, 1, 1, 3);
			
		}else if(random <= 15){
			ant = new Ant(position, 4, 2, 0, 2);
		}else if(random <= 20) {
			ant = new Ant(position, 2, 0, 2, 7);
		}
		return ant;
	}
	
	
	
	
	
	public  ArrayList<Block> generatePredators() {
		int blocksize = GameConfiguration.BLOCK_SIZE;
		int y = getRandomNumber(0,GameConfiguration.WINDOW_HEIGHT);
		int x = getRandomNumber(0,GameConfiguration.WINDOW_WIDTH);
		ArrayList<Block> predators = new ArrayList<Block>();
		Block position = new Block(x/blocksize,y/blocksize) ;
		while(position.getOccupied()) {
			y = getRandomNumber(0,GameConfiguration.WINDOW_HEIGHT);
			x = getRandomNumber(0,GameConfiguration.WINDOW_WIDTH);
			position = new Block(x/blocksize,y/blocksize) ;
		}
		int i;
		for(i=0 ; i<GameConfiguration.PREDATOR_MAX_NUMBER ; i++){
			
			predators.add(new Block(x/blocksize,y/blocksize));
			position.setOccupied(true, "predator");
			
			
			while(position.getOccupied()) {
				y = getRandomNumber(0,GameConfiguration.WINDOW_HEIGHT);
				x = getRandomNumber(0,GameConfiguration.WINDOW_WIDTH);
				position = new Block(x/blocksize,y/blocksize) ;
			}
		}
		return predators;
	}
	
	public void generatePredator(Block position) {
		Block pos = new Block(position.getLine(), position.getColumn());
		position.setOccupied(true, "predator");
	}
	
	
	
	
	
	public  ArrayList<Block> generateStoneObstacles() {
		int blocksize = GameConfiguration.BLOCK_SIZE;
		int y = getRandomNumber(0,GameConfiguration.WINDOW_HEIGHT);
		int x = getRandomNumber(0,GameConfiguration.WINDOW_WIDTH);
		ArrayList<Block> stoneObstacles = new ArrayList<Block>();
		
		Block position = new Block((int)x/blocksize,(int)y/blocksize) ;
		while(position.getOccupied()) {
			y = getRandomNumber(0,GameConfiguration.WINDOW_HEIGHT);
			x = getRandomNumber(0,GameConfiguration.WINDOW_WIDTH);
			position = new Block((int)x/blocksize,(int)y/blocksize) ;
			
		}
		int i;
		for(i=0 ; i<GameConfiguration.STONE_OBSTACLES_MAX_NUMBER ; i++){
			stoneObstacles.add(new Block(x/blocksize,y/blocksize));
			position.setOccupied(true, "stone");
			
			while(position.getOccupied()) {
				y = getRandomNumber(0,GameConfiguration.WINDOW_HEIGHT);
				x = getRandomNumber(0,GameConfiguration.WINDOW_WIDTH);
				position = new Block((int)x/GameConfiguration.BLOCK_SIZE,(int)y/GameConfiguration.BLOCK_SIZE) ;
				
			}
		}
		return stoneObstacles ;
	}
	
	public void generateStoneObstacle(Block position) {
		position.setOccupied(true, "stone");
	}
	
	
	public void generateAnthill(Block position) {
		position.setOccupied(true, "anthill");
	}
	
	private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	
	}
}
