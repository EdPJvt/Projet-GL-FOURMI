package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
import javax.swing.JPanel;

import engine.map.Map;
import engine.process.MobileElementManager;

public class Ihm extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Map map ;
	private MobileElementManager manager;
	//private JMenu menu;
	
	public Ihm(Map map, MobileElementManager tmpmanager) {
		this.map = map;
		this.manager = tmpmanager;
		
	  

	    JCheckBox e1 = new JCheckBox("Ant");
	    ActionListener checkListener1 = new ActionListener() {
	        public void actionPerformed(ActionEvent actionEvent) {
	          AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
	          boolean selected = abstractButton.getModel().isSelected();
	          
	          if(selected) {
	        	  manager.setSelected("Ant");
	          }
	          else {
	        	  manager.setSelected(null);
	          }
	          
	        }
	      };
	    e1.addActionListener(checkListener1);
	    
	    JCheckBox e2 = new JCheckBox("Predator");
	    ActionListener checkListener2 = new ActionListener() {
	        public void actionPerformed(ActionEvent actionEvent) {
	          AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
	          boolean selected = abstractButton.getModel().isSelected();
	          
	          if(selected) {
	        	  manager.setSelected("Predator");
	          }
	          else {
	        	  manager.setSelected(null);
	          }
	          
	        }
	      };
	      e2.addActionListener(checkListener2);
	      
	    JCheckBox e3 = new JCheckBox("Food");
	    ActionListener checkListener3 = new ActionListener() {
	        public void actionPerformed(ActionEvent actionEvent) {
	          AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
	          boolean selected = abstractButton.getModel().isSelected();
	          
	          if(selected) {
	        	  manager.setSelected("Food");
	          }
	          else {
	        	  manager.setSelected(null);
	          }
	          
	        }
	      };
	      e3.addActionListener(checkListener3);
	      
	    JCheckBox e4 = new JCheckBox("Anthill");
	    ActionListener checkListener4 = new ActionListener() {
	        public void actionPerformed(ActionEvent actionEvent) {
	          AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
	          boolean selected = abstractButton.getModel().isSelected();
	          
	          if(selected) {
	        	  manager.setSelected("Anthill");
	          }
	          else {
	        	  manager.setSelected(null);
	          }
	          
	        }
	      };
	      e4.addActionListener(checkListener4);
	      
	    JCheckBox e5 = new JCheckBox("Stone");
	    ActionListener checkListener5 = new ActionListener() {
	        public void actionPerformed(ActionEvent actionEvent) {
	          AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
	          boolean selected = abstractButton.getModel().isSelected();
	          
	          if(selected) {
	        	  manager.setSelected("Stone");
	          }
	          else {
	        	  manager.setSelected(null);
	          }
	          
	        }
	      };
	      e5.addActionListener(checkListener5);
	    

	    this.add(e1); 
	    this.add(e2); 
	    this.add(e3);

	    this.add(e4); 
	    this.add(e5);

	   

	    
		
	    JButton pauseButt =new JButton("Pause");
	    
	    ActionListener pushedListener1 = new ActionListener() {
	        public void actionPerformed(ActionEvent actionEvent) {
	          
	          manager.setPaused(true);
	          
	        }
	      };
	      
	    pauseButt.addActionListener(pushedListener1);
	    this.add(pauseButt);
	    
	    
	    JButton playButt =new JButton("Play");
	    
	    ActionListener pushedListener2 = new ActionListener() {
	        public void actionPerformed(ActionEvent actionEvent) {
	          
	          
	          manager.setPaused(false);
	          
	        }
	      };
	      
	    playButt.addActionListener(pushedListener2);
	    this.add(playButt);
	   
	    
	}
	  
  
	
	 

}
