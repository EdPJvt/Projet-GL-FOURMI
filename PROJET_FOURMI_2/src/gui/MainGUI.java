package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import character.AbstractEntity;
import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.process.GameBuilder;
import gui.GameDisplay;
import engine.process.MobileElementManager;

/**
 * Copyright SEDAMOP - Software Engineering
 * 
 * @author tianxiao.liu@cyu.fr
 *
 */
public class MainGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private Map map;

	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);
	private final static Dimension halfPrefSize = new Dimension(GameConfiguration.WINDOW_WIDTH/2, GameConfiguration.WINDOW_HEIGHT/2);
	
	private MobileElementManager manager;

	private GameDisplay dashboard;
	
	private Ihm ihm;

	public MainGUI(String title) {
		super(title);
		init();
	}

	private void init() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		KeyControls keyControls = new KeyControls();
		JTextField textField = new JTextField();
		textField.addKeyListener(keyControls);
		contentPane.add(textField);
		
		MouseControls mouseControls =new MouseControls();
		contentPane.addMouseListener(mouseControls);
		

		map = GameBuilder.buildMap();
		manager = GameBuilder.buildInitMobile(map);
		dashboard = new GameDisplay(map, manager);
		ihm = new Ihm(map, manager);
		
		

		dashboard.setPreferredSize(preferredSize);
		contentPane.add(dashboard, BorderLayout.CENTER);
		
		contentPane.add(new Ihm(map, manager), BorderLayout.EAST);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}


	public void run() {
		while (true) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
			manager.nextRound();
			dashboard.repaint();
		}
	}

	private class KeyControls implements KeyListener {


		public void keyPressed(KeyEvent event) {
			char keyChar = event.getKeyChar();
			switch (keyChar) {

			case 'q':
				manager.moveLeftEntity();
				break;
			case 'd':
				manager.moveRightEntity();
				break;
			case 'z':
				manager.moveUpEntity();
				break;
			case 's':
				manager.moveDownEntity();
				break;
			default:
				break;
			}
		}

		public void keyTyped(KeyEvent e) {

		}

		public void keyReleased(KeyEvent e) {

		}
	}

	private class MouseControls implements MouseListener {


		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX(); 
			int y = e.getY();
		
			
			int line = y/GameConfiguration.BLOCK_SIZE;
			int column = x/GameConfiguration.BLOCK_SIZE;
			
		
			Block position = new Block(line, column);
			manager.generateItem(position);
			dashboard.repaint();
			

		}

	}

}
