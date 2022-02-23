package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import character.AbstractEntity;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author edgar.juvernat@cytu.etu.fr
 *
 */
public class PaintStrategy {
	public void paint(Map map, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block[][] blocks = map.getBlocks();

		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];

				if ((lineIndex + columnIndex) % 2 == 0) {
					graphics.setColor(Color.GRAY);
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

		graphics.setColor(Color.BLUE);
		graphics.drawLine(x * blockSize + blockSize / 2, y * blockSize, x * blockSize, (y + 1) * blockSize);
		graphics.drawLine(x * blockSize + blockSize / 2, y * blockSize, (x + 1) * blockSize, (y + 1) * blockSize);
		graphics.drawLine(x * blockSize + blockSize / 2, y * blockSize, x * blockSize + blockSize / 2, (y + 1) * blockSize);

	}

/*	public void paint(AbstractEntity entity, Graphics graphics) {
		Block position = enemy.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();

		graphics.setColor(Color.RED);
		graphics.fillOval(x * blockSize, y * blockSize, blockSize, blockSize);
	}
*/
}
