package engine.process;

import java.util.ArrayList;

import character.*;
import config.GameConfiguration;
import engine.map.Block;

public class GenerationManager {
	
	public GenerationManager() {}

		
	
	public  ArrayList<Block> generateFoodSource() {
		int x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
		int y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
		ArrayList<Block> foodsources = new ArrayList<Block>(GameConfiguration.FOOD_MAX_NUMBER) ;
		
		Block position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE) ;
		while(position.getOccupied()) {
			x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
			y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
			position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE) ;
		}
		int i;
		for(i=0 ; i<GameConfiguration.FOOD_MAX_NUMBER ; i++){
			foodsources.add(new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE));
			position.setOccupied(true, "food");
			while(position.getOccupied()) {
				x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
				y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
				position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE) ;
			}
		}
		return foodsources;
	}
	
	
	
	
	public  ArrayList<Ant> generateAnt(ArrayList<Block> fourmilieres) {
		int random = getRandomNumber(0, fourmilieres.size()-1);
		 ArrayList<Ant> ants= new ArrayList<Ant>();
		
		Block position = fourmilieres.get(random);
		ants.add(generateRandomAnt(position));
		return ants;
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
	
	
	
	
	
	public  ArrayList<Block> generatePredator() {
		int x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
		int y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
		ArrayList<Block> predators = new ArrayList<Block>();
		Block position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE) ;
		while(position.getOccupied()) {
			x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
			y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
			position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE) ;
		}
		int i;
		for(i=0 ; i<GameConfiguration.PREDATOR_MAX_NUMBER ; i++){
			predators.add(new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE));
			position.setOccupied(true, "predator");
			while(position.getOccupied()) {
				x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
				y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
				position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE) ;
			}
		}
		return predators;
	}
	
	public  ArrayList<Block> generateStoneObstacles() {
		int x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
		int y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
		ArrayList<Block> stoneObstacles = new ArrayList<Block>();
		
		Block position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE) ;
		while(position.getOccupied()) {
			x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
			y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
			position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE) ;
		}
		int i;
		for(i=0 ; i<GameConfiguration.STONE_OBSTACLES_MAX_NUMBER ; i++){
			stoneObstacles.add(new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE));
			position.setOccupied(true, "stone");
			while(position.getOccupied()) {
				x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
				y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
				position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE) ;
			}
		}
		return stoneObstacles ;
	}
	
	
	private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	
	}
}
