package src;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
	private String[] playerNum;
	private JComboBox numChooser;
	private JButton startBtn;
	private JLabel plCnt;
	private int pleyercount;
	
	public MainMenu() {
		
		/**The constructor of frame*/
		//this = new JFrame();
		
		
		JPanel mainp=new JPanel(new GridBagLayout());//holding the whole 
		GridBagConstraints c = new GridBagConstraints();
		this.add(mainp);
		
		
		Toolkit tk=Toolkit.getDefaultToolkit(); 			//Initializing the Toolkit class.
		Dimension screenSize = tk.getScreenSize(); 			//Get the Screen resolution of our device.
		this.setSize(500,500); 	//Set the width and height of the JFrame.
		
		playerNum=new String[] {"3","4","5"};
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		logo=new JPanel();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		mainp.add(logo, c);
		
		
		plCnt= new JLabel("Number of players:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.3;
		//c.gridwidth = 1;
		c.gridx = 2;
		c.gridy = 1;
		mainp.add(plCnt, c);
		
		
		
		startBtn=new JButton("START");
		startBtn.addActionListener((ActionListener) this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		//c.weightx = 0.2;
		c.gridx = 0;
		c.gridy = 2;
		mainp.add(startBtn, c);
		
		JPanel whitespace=new JPanel();
		c.gridwidth = 1;
		//c.weightx = 0.2;
		c.gridx = 1;
		c.gridy = 2;
		mainp.add(whitespace, c);
		
		numChooser=new JComboBox(playerNum);
		numChooser.addActionListener(new ComboBoxListener());
		numChooser.setVisible(true);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		//c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 2;
		mainp.add(numChooser, c);		
	}
	
	final class ComboBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			int selected=Integer.parseInt((String)numChooser.getSelectedItem());
			subMenuFrame=new MainSubMenu(selected);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
        subMenuFrame.setVisible(true);
	}

	
}
