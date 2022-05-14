package src;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainSubMenu extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel[] Virologists;
	private JTextField[] ViroNames;
	private JButton GameStartBtn;
	private GameMenu gameFrame;
	private int playerCnt=3;
	
	public void GameStartBtnPress(int playerCnt) {
		boolean allTextFieldsFull=true;
		
		for(int i=0;i< playerCnt;i++) {
			if(ViroNames[i].getText().equals("")) {
				allTextFieldsFull=false;
			}
		}
		
		if(allTextFieldsFull) {
			int w=1120; int h=1020;
			System.out.println(playerCnt);
			gameFrame=new GameMenu(new Game(playerCnt));
			gameFrame.setSize(w,h);
			gameFrame.setVisible(true);
			this.dispose();
		}
	}
	
	public MainSubMenu(int playerCnt) {
		Virologists=new JLabel[playerCnt];
		ViroNames=new JTextField[playerCnt];
		this.playerCnt=playerCnt;
		GameStartBtn=new JButton("START GAME");
		GameStartBtn.addActionListener(new GameActionListener());
		this.setSize(800,800);
		
		JPanel submainpanel=new JPanel(new GridLayout(playerCnt+1,2,50,50));
		
		Dimension size=new Dimension(200,25);			//this is the default(minimum) size of all the JTextFields and JLabels
		
		for(int i=0;i<playerCnt;i++) {
			Virologists[i]=new JLabel("Virologist "+(i+1));
			Virologists[i].setSize(size);
			ViroNames[i]=new JTextField();
			ViroNames[i].setSize(size);
			submainpanel.add(Virologists[i]);
			submainpanel.add(ViroNames[i]);
			
			Virologists[i].setVisible(true);
			ViroNames[i].setVisible(true);
		}
		submainpanel.add(GameStartBtn);
		this.add(submainpanel);
		
		this.setVisible(true);
	}
	
	final class GameActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			GameStartBtnPress(playerCnt);
		}		
	}
}
