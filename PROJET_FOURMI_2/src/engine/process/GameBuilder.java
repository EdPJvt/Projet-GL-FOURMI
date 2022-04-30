package engine.process;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import character.AbstractEntity;
import character.Ant;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author tianxiao.liu@cyu.fr
 *
 */
public class GameBuilder {

	public static Map buildMap() {
		return new Map(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}

	public static MobileElementManager buildInitMobile(Map map) {
		MobileElementManager manager = new MobileElementManager(map);
		
		intializeAbstractEntity(map, manager);
		
		return manager;
	}

	private static void intializeAbstractEntity(Map map, MobileElementManager manager) {
		Block block = map.getBlock(GameConfiguration.LINE_COUNT - 1, (GameConfiguration.COLUMN_COUNT - 1) / 2);
		AbstractEntity entity = new Ant(block);
		manager.set(entity);
	}

}
