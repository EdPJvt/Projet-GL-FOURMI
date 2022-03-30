package gui;

import java.awt.Graphics;
//import java.util.List;
import engine.map.Map;

import javax.swing.JPanel;

import character.AbstractEntity;
//import config.GameConfiguration;
import engine.process.MobileElementManager;

import java.util.ArrayList;

import engine.map.Block;

import character.Ant;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author tianxiao.liu@cyu.fr
 *
 */
public class GameDisplay extends JPanel {

	private static final long serialVersionUID = 1L;

	private Map map;
	private MobileElementManager manager;
	private PaintStrategy paintStrategy = new PaintStrategy();

	public GameDisplay(Map map, MobileElementManager manager) {
		this.map = map;

	this.manager = manager;
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		paintStrategy.paint(map, g);

		AbstractEntity entity = manager.getAnt();
		paintStrategy.paint(entity, g);
		
		ArrayList<Block> fourmilieres = manager.getFourmilieres();
		paintStrategy.paint(fourmilieres,g);
		
		ArrayList<Ant> ants = manager.getAnts();
		paintStrategy.paint(ants,g);
		
		ArrayList<Block> foodsources= manager.getFoodSources();
		paintStrategy.paintFood(foodsources, g);
/*
		for (AbstractEntity entity : manager.getPredator()) {
			paintStrategy.paint(enemy, g);
		}
*/
	}

}
