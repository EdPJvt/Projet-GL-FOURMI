package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import character.*;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author edgar.juvernat@cytu.etu.fr
 *
 */
public class PaintStrategy extends JLabel{
	public void paint(Map map, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block[][] blocks = map.getBlocks();

		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];

				if ((lineIndex + columnIndex) % 2 == 0) {
					graphics.setColor(new Color(0,100,0));
					graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);
				}
				else {
					graphics.setColor(new Color(0,128,0));
					graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);
				}
			}
		}
	}

	public void paint(AbstractEntity entity, Graphics graphics) {
		Block position = entity.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		
		Image antPng = Toolkit.getDefaultToolkit().getImage("C:\\PROJET_FOURMI_2\\ant.png");
		graphics.drawImage(antPng, x*blockSize, y*blockSize, null);
	}
	
	public void paintFood(ArrayList<Block> foodsources, Graphics graphics) {
		int i;
		for(i=0;i<foodsources.size();i++) {
			Block tmp = foodsources.get(i);
			int y = tmp.getLine();
			int x = tmp.getColumn();
			
			graphics.setColor(Color.YELLOW);
			graphics.fillRect(x, y, GameConfiguration.BLOCK_SIZE, GameConfiguration.BLOCK_SIZE);
			
		}
	}
	
	public void paintPredator(ArrayList<Block> predators, Graphics graphics) {
		int i;
		for(i=0;i<predators.size();i++) {
			Block tmp = predators.get(i);
			int y = tmp.getLine();
			int x = tmp.getColumn();
			
			graphics.setColor(Color.RED);
			graphics.fillRect(x, y, GameConfiguration.BLOCK_SIZE, GameConfiguration.BLOCK_SIZE);
			
		}
	}
	
	public void paintStoneObstacles(ArrayList<Block> stoneObstacles, Graphics graphics) {
		int i;
		for(i=0;i<stoneObstacles.size();i++) {
			Block tmp = stoneObstacles.get(i);
			int y = tmp.getLine();
			int x = tmp.getColumn();
			
			graphics.setColor(Color.GRAY);
			graphics.fillRect(x, y, GameConfiguration.BLOCK_SIZE, GameConfiguration.BLOCK_SIZE);
			
		}
	}
	
	public void paint(ArrayList<Block> fourmilieres, Graphics graphics) {
		int i;
		for(i=0;i<fourmilieres.size();i++) {
			Block tmp = fourmilieres.get(i);
			int y = tmp.getLine();
			int x = tmp.getColumn();
			
			graphics.setColor(new Color(139,69,19));
			graphics.fillRect(x, y, GameConfiguration.BLOCK_SIZE, GameConfiguration.BLOCK_SIZE);
			
		}
		
	}
	
	public void paint(List<Ant> ants, Graphics graphics) {
		int i;
		for(i=0;i<ants.size();i++) {
			Ant tmpant = ants.get(i);
			Block position = tmpant.getPosition();
			int y = position.getLine();
			int x = position.getColumn();
			int blockSize= GameConfiguration.BLOCK_SIZE;
			
			graphics.setColor(Color.RED);
			graphics.drawOval(x * blockSize + blockSize / 2, y * blockSize, 5, 5);
			graphics.drawLine(x * blockSize + blockSize / 2, y * blockSize, (x + 1) * blockSize, (y + 1) * blockSize);
			graphics.drawLine(x * blockSize + blockSize / 2, y * blockSize, x * blockSize + blockSize / 2, (y + 1) * blockSize);			
		}

	}
/*
	public void paint(AbstractEntity entity, Graphics graphics) {
		Block position = enemy.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		graphics.setColor(Color.RED);
		graphics.fillOval(x * blockSize, y * blockSize, blockSize, blockSize);
	}
*/
	
}
