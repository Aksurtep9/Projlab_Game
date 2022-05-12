package src;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainSubMenu extends JFrame{
	private JLabel[] Virologists;
	private JTextField[] ViroNames;
	private JButton GameStartBtn;
	private GameMenu gameFrame;
	private int playerCnt=0;
	
	public void GameStartBtnPress(int playerCnt) {
		boolean allTextFieldsFull=true;
		
		for(int i=0;i< playerCnt;i++) {
			if(ViroNames[i].getText().equals("")) {
				allTextFieldsFull=false;
			}
		}
		
		if(allTextFieldsFull) {
			int w=1120; int h=1020;
			gameFrame=new GameMenu(new Game(playerCnt));
			gameFrame.setSize(w,h);
			gameFrame.setVisible(true);
			this.setVisible(false);
		}
	}
	
	public MainSubMenu(int playerCnt) {
		Virologists=new JLabel[playerCnt];
		ViroNames=new JTextField[playerCnt];
		this.playerCnt=playerCnt;
		GameStartBtn=new JButton();
		this.setSize(800,800);
		
		
		Dimension size=new Dimension(100,200);			//ez  a merete a textfieldeknek + labeleknek
		Dimension posLabel=new Dimension(100,200);
		Dimension posTextField=new Dimension(100,500);	//ezek a poziciok
		for(int i=0;i<playerCnt;i++) {
			Virologists[i].setSize(size);
			ViroNames[i].setSize(size);
			this.add(Virologists[i],posLabel);
			this.add(ViroNames[i],posTextField);
			posLabel.height+=100;
			posTextField.height+=100;
			Virologists[i].setVisible(true);
			ViroNames[i].setVisible(true);
		}
		
		this.add(GameStartBtn);
		this.setVisible(true);
	}
	
	final class GameActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			GameStartBtnPress(playerCnt);
		}		
	}
}
