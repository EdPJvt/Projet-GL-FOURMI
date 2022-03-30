package engine.process;

import java.util.ArrayList;

import character.Ant;
import config.GameConfiguration;
import engine.map.Block;

public class GenerationManager {
	
	public void generateFoodSource(ArrayList<Block> foodsources) {
		int x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
		int y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
		Block position = new Block(x*GameConfiguration.BLOCK_SIZE,y*GameConfiguration.BLOCK_SIZE);
		
		int i;
		for(i=0 ; i<GameConfiguration.FOOD_MAX_NUMBER ; i++){
			while(position.getOccupied()) {
				x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
				y = getRandomNumber(0,GameConfiguration.LINE_COUNT);
			}
			position.setOccupied(true);
			foodsources.add(position);
			x = getRandomNumber(0,GameConfiguration.LINE_COUNT);
			y = getRandomNumber(0,GameConfiguration.COLUMN_COUNT);
			
		}
	}
	
	public void generateAnt(ArrayList<Ant> ants, ArrayList<Block> fourmilieres) {
		int random = getRandomNumber(0, fourmilieres.size()-1);
		Block position =fourmilieres.get(random);
		position.setOccupied(true);
		ants.add(new Ant(position));
	}
	
/*	private void generatePredator(ArrayList<AbstractEntity> predators) {
		int randomColumn = getRandomNumber(0, GameConfiguration.COLUMN_COUNT - 1);
		Block position = new Block(0, randomColumn);
		AbstractEntity predators= new AbstractEntity(position);
		add(enemy);
	}
*/	
	public void generateObstacles() {}
	
	public void generateRiver() {}
	
	private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	
	}
}
