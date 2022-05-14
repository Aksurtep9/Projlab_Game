package src;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private Virologist currentPlayer;
	Game game;
	Thing selectedThing;
	Canvas canvas;
	
	private static Object lock = new Object();
	private static JFrame selectMenu = new JFrame();
	
	GameMenu(Game game) {
		this.game=game;
		currentPlayer = game.getCurrentPlayer();
		Toolkit tk=Toolkit.getDefaultToolkit(); 			//Initializing the Toolkit class.
		Dimension screenSize = tk.getScreenSize(); 			//Get the Screen resolution of our device.
		this.setSize(screenSize.width,screenSize.height); 	//Set the width and height of the JFrame
		
		JPanel pane1 = new JPanel();
		JPanel pane2 = new JPanel(new FlowLayout());
		
		
		 btCraft=new JButton("Craft");						//if the button is pressed, the according function gets called
		 btCraft.addActionListener(new ActionListener() {	 
			public void actionPerformed(ActionEvent e) {
				CallCraft();
			}
		 });
		 
		 btAnoint = new JButton("Anoint");
		 btAnoint.addActionListener(new ActionListener() {	 
				public void actionPerformed(ActionEvent e) {
					CallAnoint();
				}
			 });
		 
		 btPickUp = new JButton("Pick Up");
		 btPickUp.addActionListener(new ActionListener() {	 
				public void actionPerformed(ActionEvent e) {
					CallPick();
				}
			 });
		 
		 btDrop = new JButton("Drop");
		 btDrop.addActionListener(new ActionListener() {	 
				public void actionPerformed(ActionEvent e) {
					CallDrop();
				}
			 });
		 
		 btStealEq = new JButton("Steal Equipment");
		 btStealEq.addActionListener(new ActionListener() {	 
				public void actionPerformed(ActionEvent e) {
					CallStealEq();
				}
			 });
		 
		 btStealMat = new JButton("Steal Material");
		 btStealMat.addActionListener(new ActionListener() {	 
				public void actionPerformed(ActionEvent e) {
					CallStealMat();
				}
			 });
		 
		 btAttack= new JButton("Attack");
		 btAttack.addActionListener(new ActionListener() {	 
				public void actionPerformed(ActionEvent e) {
					CallAttack();
				}
			 });
		 
		 btPass= new JButton("Pass");
		 btPass.addActionListener(new ActionListener() {	 
				public void actionPerformed(ActionEvent e) {
					CallPass();
				}
			 });
		 
		 pane2.add(btCraft); //adding the buttons which are responsible for controlling the game to the panel
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
		game.getCurrentPlayer().CloneGenCode(new Protect());
		selectMenu = new SelectThingsMenu(currentPlayer,"gencodecollection" , this);
		selectMenu.setVisible(true);
		
		Thread t = new Thread() {
			public void run() {
				synchronized (lock) {
					//Várakozás
					while(selectMenu.isVisible()) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// well
						}
					}
					
					// Várakozás vége
					System.out.println("Now working.");
				}
			}
		};
		t.start();
	}
	
	public Object getLock() { return lock; }

	public void CallAnoint() {
		SelectThingsMenu setsdf=new SelectThingsMenu(currentPlayer,"virologists" , this);
	}
	
	public void CallPick() {
		SelectThingsMenu setsdf=new SelectThingsMenu(currentPlayer,"equipment" , this);
	}
	
	public void CallStealEq() {
		SelectThingsMenu setsdf=new SelectThingsMenu(currentPlayer,"virologists" , this);
		Thing enemy = this.selectedThing;
		SelectThingsMenu stm = new SelectThingsMenu(enemy, "equipment", this);
		currentPlayer.StealEquipment((Virologist)enemy, (Equipment)this.selectedThing);
	}
	
	public void CallDrop() {
		SelectThingsMenu setsdf=new SelectThingsMenu(currentPlayer,"equipment" , this);
	}
	
	public void CallStealMat() {
		SelectThingsMenu setsdf=new SelectThingsMenu(currentPlayer,"virologists" , this);
	}
	
	public void CallAttack() {
		SelectThingsMenu setsdf=new SelectThingsMenu(currentPlayer,"virologists" , this);
	}
	
	public void CallPass() {
		
	}
	
	public void SetSelectedItem(Thing t) {
		this.selectedThing = t;
	}
	
	public Virologist GetCurrentPlayer() {
		return currentPlayer;
	}
	
	public void SetNewPanelField() {
		
	}

}
