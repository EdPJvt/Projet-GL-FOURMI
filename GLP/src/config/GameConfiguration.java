package config;

import engine.map.Block;
/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author tianxiao.liu@cyu.fr
 *
 */
public class GameConfiguration {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	
	public static final int BLOCK_SIZE = 40;
	
	public static final int LINE_COUNT = WINDOW_HEIGHT / BLOCK_SIZE;
	public static final int COLUMN_COUNT = WINDOW_WIDTH / BLOCK_SIZE;
	
	public static final int GAME_SPEED = 1000;
	
	public static final Block DEFAULT_SPAWN = new Block(0,0);
	public static final Block DEFAULT_FOOD_SPAWN = new Block((LINE_COUNT/2)*BLOCK_SIZE, (COLUMN_COUNT/2)*BLOCK_SIZE);
	
	public static final int FOOD_MAX_NUMBER = 4;
	public static final int PREDATOR_MAX_NUMBER = 2;
	public static final int STONE_OBSTACLES_MAX_NUMBER = 7;
	public static final int DEFAULT_TAUX_PHEROMONES = 4;
	
	//faire des méthodes permettant de modifier les constante, mais de façon privée (pour implémenter la liberté de modification par l'utilisateurs)
	

	

}
