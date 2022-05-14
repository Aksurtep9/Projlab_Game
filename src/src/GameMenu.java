package src;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private Thing selectedThing;
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
		
		this.setIconImage(new ImageIcon(this.getClass().getResource("icon.png")).getImage());
		
		this.setTitle("Game");
		
		
		 btCraft=new JButton("Craft");						//if the button is pressed, the according function gets called
		 btCraft.addActionListener(new ActionListener() {	 
			public void actionPerformed(ActionEvent e) {
				/** checks whether the current player has any action points left and know any gencode to craft*/
				if(currentPlayer.GetGenCodeCollection().GetAgents().size()==0 || game.getActionCount()==0)
				{
					return;
				}
				CallCraft();
			}
		 });
		 
		 btAnoint = new JButton("Anoint");
		 btAnoint.addActionListener(new ActionListener() {	 
				public void actionPerformed(ActionEvent e) {
					/** checks whether the current player has any action point left and has any available agent to anoint with*/
					if(currentPlayer.GetCraftedACollection().GetAgents().size()==0 || game.getActionCount()==0)
					{
						return;
					}
					int cnt;
					ArrayList<Virologist> virologists= new ArrayList<Virologist>();
					for (Thing vir : currentPlayer.field.GetThings()) {
						if(vir.toString().equals("Virologist"))
							virologists.add((Virologist)vir);
							cnt++;
					}
					if(cnt==0)
						return;
					CallAnoint();
				}
			 });
		 
		 btPickUp = new JButton("Pick Up");
		 btPickUp.addActionListener(new ActionListener() {	 
				public void actionPerformed(ActionEvent e) {
					/**checks whether the currentz player has any action points left and has empty space for an equipment*/
					if(currentPlayer.field.GetThings().size()==0 || game.getActionCount()==0)
					{
						return;
					}
					CallPick();
				}
			 });
		 
		 btDrop = new JButton("Drop");
		 btDrop.addActionListener(new ActionListener() {	 
				public void actionPerformed(ActionEvent e) {
					/** checks whether the current player has any action points left and can drop an item*//
					if(currentPlayer.GetEquipmentCollection().GetEquipments().size()==0 || game.getActionCount()==0)
					{
						return;
					}
					CallDrop();
				}
			 });
		 
		 btStealEq = new JButton("Steal Equipment");
		 btStealEq.addActionListener(new ActionListener() {	 
				public void actionPerformed(ActionEvent e) {
					/**checks whether the current player has any action points left to use and has space for more equipment*/
					if(game.getActionCount()==0 || currentPlayer.GetEquipmentCollection().GetEquipments().size()>=3)
					{
						return;
					}
					int cnt=0;
					/** checks whether there is an available virologist on the field to rob*/
					ArrayList<Virologist> virologists= new ArrayList<Virologist>();
					for (Thing vir : currentPlayer.field.GetThings()) {
						if(vir.toString().equals("Virologist"))
							virologists.add((Virologist)vir);
							cnt++;
					}
					if(cnt==0)
						return;
					/**checks whether the current player can store any more equipment*/
					int eq=0;
					for (Virologist vir : virologists) {
						if(vir.GetEquipmentCollection().GetEquipments().size()>0)
							eq++;
					}
					if(eq==0)
						return;
					CallStealEq();
				}
			 });
		 
		 btStealMat = new JButton("Steal Material");
		 btStealMat.addActionListener(new ActionListener() {	 
				public void actionPerformed(ActionEvent e) {
					/** checks if there is any actionpoint left and  whether the virologist has any space left for materials*/
					if(game.getActionCount()==0 || (currentPlayer.GetMaterialCollection().GetAmino().GetAmount()>=20 && currentPlayer.GetMaterialCollection().GetNucle().GetAmount()>=20 ))
					{
						return;
					}
					/**checks whether is a virologist to be robbed*/
					int cnt=0;
					ArrayList<Virologist> virologists= new ArrayList<Virologist>();
					for (Thing vir : currentPlayer.field.GetThings()) {
						if(vir.toString().equals("Virologist"))
							virologists.add((Virologist)vir);
							cnt++;
					}
					if(cnt==0)
						return;
					/**checks whether the current player could steal material from victim*/
					int eq=0;
					for (Virologist vir : virologists) {
						if(vir.GetMaterialCollection().GetAmino().GetAmount()>0 || vir.GetMaterialCollection().GetNucle().GetAmount()>0)
							eq++;
					}
					if(eq==0)
						return;
					CallStealMat();
				}
			 });
		 
		 btAttack= new JButton("Attack");
		 btAttack.addActionListener(new ActionListener() {	 
				public void actionPerformed(ActionEvent e) {
					
					/**if there are no actionpoint left*/
					if(game.getActionCount()==0)
					{
						return;
					}
					/**checks if there are avaliable virologist to kill*/
					int cnt=0;
					ArrayList<Virologist> virologists= new ArrayList<Virologist>();
					for (Thing vir : currentPlayer.field.GetThings()) {
						if(vir.toString().equals("Virologist"))
							virologists.add((Virologist)vir);
							cnt++;
					}
					if(cnt==0)
						return;
					/**checks if said virologist is bear*/
					int bear=0;
					for (Virologist vir : virologists) {
						if(vir.isBear())
							bear++;
					}
					if(bear==0)
						return;
					/** checks whether the current player has an axe usable*/
					int axe=0;
					for(Equipment eq : currentPlayer.GetEquipmentCollection().GetEquipments()) {
						if(eq.toString().equals("Axe")&& eq.useTime>0)
							axe++;
					}
					if(axe==0)
						return;
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
		
		// Selecting the genCode
		selectMenu = new SelectThingsMenu(currentPlayer,"genCode" , this);
		selectMenu.setVisible(true);
		GameMenu frame = this;
		
		Thread t = new Thread() {
			public void run() {
				synchronized (lock) {
					while(selectMenu.isVisible()) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// Do Nothing
						}
					}
					// After closing it
					game.getCurrentPlayer().Craft((Agent) frame.GetSelectedItem());
				}
			}
		};
		t.start();
	}
	
	public Object getLock() { return lock; }

	
	public void CallAnoint() {
		selectMenu = new SelectThingsMenu(currentPlayer,"Virologists" , this);
		selectMenu.setVisible(true);
		GameMenu frameThis = this;
		
		Thread t1 = new Thread() {
			public void run() {
				synchronized (lock) {
					while(selectMenu.isVisible()) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// Do Nothing
						}
					}
					// After closing it
					Virologist localEnemy = (Virologist) frameThis.GetSelectedItem();
					
					// Selecting the agent
					selectMenu = new SelectThingsMenu(currentPlayer, "Crafts", frameThis);
					selectMenu.setVisible(true);
					
					Thread t2 = new Thread() {
						public void run() {
							synchronized (lock) {
								while(selectMenu.isVisible()) {
									try {
										lock.wait();
									} catch (InterruptedException e) {
										// Do Nothing
									}
								}
								//After closing it
								Agent virus = (Agent) frameThis.GetSelectedItem();
								game.getCurrentPlayer().Anoint(localEnemy, virus);
							}
						}
					};
					t2.start();
				}
			}
		};
		t1.start();
	}
	
	public void CallPick() {
		// Selecting the equipment
		selectMenu = new SelectThingsMenu(currentPlayer, "Equipments from Field" , this);
		selectMenu.setVisible(true);
		GameMenu frameThis = this;
		
		Thread t = new Thread() {
			public void run() {
				synchronized (lock) {
					while(selectMenu.isVisible()) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// Do Nothing
						}
					}
					// After closing it
					game.getCurrentPlayer().PickUpEquipment((Equipment) frameThis.GetSelectedItem());
				}
			}
		};
		t.start();
	}
	
	public void CallStealEq() {
		// Selecting enemy
		selectMenu = new SelectThingsMenu(currentPlayer, "Virologists" , this);
		selectMenu.setVisible(true);
		GameMenu frameThis = this;
		
		Thread t1 = new Thread() {
			public void run() {
				synchronized (lock) {
					while(selectMenu.isVisible()) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// Do Nothing
						}
					}
					// After closing it
					Virologist localEnemy = (Virologist) frameThis.GetSelectedItem();
					
					// Selecting the Equipment
					selectMenu = new SelectThingsMenu(localEnemy, "Equipments from Virologist", frameThis);
					selectMenu.setVisible(true);
					
					Thread t2 = new Thread() {
						public void run() {
							synchronized (lock) {
								while(selectMenu.isVisible()) {
									try {
										lock.wait();
									} catch (InterruptedException e) {
										// Do Nothing
									}
								}
								//After closing it
								Equipment eq = (Equipment) frameThis.GetSelectedItem();
								game.getCurrentPlayer().StealEquipment(localEnemy, eq);
							}
						}
					};
					t2.start();
				}
			}
		};
		t1.start();
	}
	
	public void CallDrop() {
		// Selecting the equipment
		selectMenu = new SelectThingsMenu(currentPlayer, "Equipments from Virologist" , this);
		selectMenu.setVisible(true);
		GameMenu frameThis = this;
		
		Thread t = new Thread() {
			public void run() {
				synchronized (lock) {
					while(selectMenu.isVisible()) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// Do Nothing
						}
					}
					// After closing it
					game.getCurrentPlayer().DropEquipment((Equipment) frameThis.GetSelectedItem());
				}
			}
		};
		t.start();
	}
	
	public void CallStealMat() {
		// Selecting the enemy
		selectMenu = new SelectThingsMenu(currentPlayer, "Virologists" , this);
		selectMenu.setVisible(true);
		GameMenu frame = this;
		
		Thread t = new Thread() {
			public void run() {
				synchronized (lock) {
					while(selectMenu.isVisible()) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// Do Nothing
						}
					}
					// After closing it
					game.getCurrentPlayer().StealMaterial((Virologist) frame.GetSelectedItem());
				}
			}
		};
		t.start();
	}
	
	public void CallAttack() {
		// Selecting the enemy
		selectMenu = new SelectThingsMenu(currentPlayer, "Virologists" , this);
		selectMenu.setVisible(true);
		GameMenu frame = this;
		
		Thread t = new Thread() {
			public void run() {
				synchronized (lock) {
					while(selectMenu.isVisible()) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// Do Nothing
						}
					}
					// After closing it
					game.getCurrentPlayer().Attack((Virologist) frame.GetSelectedItem());
				}
			}
		};
		t.start();
	}
	
	public void CallPass() {
		game.NewRound();
	}
	
	public void SetSelectedItem(Thing t) {
		this.selectedThing = t;
	}
	
	public Thing GetSelectedItem() { return selectedThing; }
	
	public Virologist GetCurrentPlayer() {
		return currentPlayer;
	}
	
	public void SetNewPanelField() {
		
	}

}
