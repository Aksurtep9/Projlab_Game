package src;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The very first frame that the user sees
 */
public class MainMenu extends JFrame{
	
	private static final long serialVersionUID = -7953672467585166161L;
	
	//private JFrame frame;
	private JPanel logo;
	private MainSubMenu subMenuFrame;
	private int[] playerNum;
	private JComboBox numChooser;
	private JButton startBtn;
	private JLabel plCnt;
	
	public MainMenu() {
		
		/**The constructor of frame*/
		//this = new JFrame();
		
		logo=new JPanel();
		this.add(logo);
		
		Toolkit tk=Toolkit.getDefaultToolkit(); 			//Initializing the Toolkit class.
		Dimension screenSize = tk.getScreenSize(); 			//Get the Screen resolution of our device.
		this.setSize(screenSize.width,screenSize.height); 	//Set the width and height of the JFrame.
		
		numChooser=new JComboBox();
		this.add(numChooser);
		startBtn=new JButton();
		this.add(startBtn);
		plCnt= new JLabel();
		this.add(plCnt);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	final class ComboBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			int selected=(int)numChooser.getSelectedItem();
			subMenuFrame=new MainSubMenu(selected);
		}
	}
}
