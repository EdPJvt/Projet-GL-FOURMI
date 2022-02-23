package engine.mobile;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.MobileElementManager;
import entity.AbstractEntity;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author ismael.cherchar@etu.cyu.fr
 *
 */
public class GameBuilder {

	public static Map buildMap() {
		return new Map(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}

	public static MobileElementManager buildInitMobile(Map map) {
		MobileElementManager manager = new MobileElementManager(map);
		
		initializeAbstractEntity(map, manager);
		
		return manager;
	}

	private static void initializeAbstractEntity(Map map, MobileElementManager manager) {
		Block block = map.getBlock(GameConfiguration.LINE_COUNT - 1, (GameConfiguration.COLUMN_COUNT - 1) / 2);
		AbstractEntity AbstractEntity = new AbstractEntity(block);
		manager.set(AbstractEntity);
	}

}
