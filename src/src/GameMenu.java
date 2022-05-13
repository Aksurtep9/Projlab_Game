package src;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameMenu extends JFrame {
	
	JButton btCraft;
	JButton btAnoint;
	JButton btPickUp;
	JButton btDrop;
	JButton btStealEq;
	JButton btStealMat;
	JButton btAttack;
	JButton btPass;
	Virologist currentPlayer;
	Game game;
	Thing selectedThing;
	Canvas canvas;
	
	GameMenu(Game game) {
		this.game=game;
		Toolkit tk=Toolkit.getDefaultToolkit(); 			//Initializing the Toolkit class.
		Dimension screenSize = tk.getScreenSize(); 			//Get the Screen resolution of our device.
		this.setSize(screenSize.width,screenSize.height); 	//Set the width and height of the JFrame
		
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel(new FlowLayout());
		
		
		 btCraft=new JButton("Craft");
		 btAnoint = new JButton("Anoint");
		 btPickUp = new JButton("Pick Up");
		 btDrop = new JButton("Drop");
		 btStealEq = new JButton("Steal Equipment");
		 btStealMat = new JButton("Steal Material");
		 btAttack= new JButton("Attack");
		 btPass= new JButton("Pass");
		 pane2.add(btCraft);
		 pane2.add(btAnoint);
		 pane2.add(btPickUp);
		 pane2.add(btDrop);
		 pane2.add(btStealEq);
		 pane2.add(btStealMat);
		 pane2.add(btAttack);
		 pane2.add(btPass);
		 pane1.setVisible(true);
		 pane2.setVisible(true);
		 
		 this.add(pane1, BorderLayout.NORTH);
		 this.add(pane2, BorderLayout.SOUTH);
		 this.pack();
		 this.setVisible(true);
	}
	
	public void CallCraft() {
		
	}

	public void CallAnoint() {
		
	}
	
	public void CallPick() {
		
	}
	
	public void CallStealEq() {
		
	}
	
	public void CallDrop() {
		
	}
	
	public void CallStealMat() {
		
	}
	
	public void CallAttack() {
		
	}
	
	public void CallPass() {
		
	}
	
	public void SetSelectedItem(Thing t) {
		
	}
	
	public Virologist GetCurrentPlayer() {
		return currentPlayer;
	}
	
	public void SetNewPanelField() {
		
	}
}
