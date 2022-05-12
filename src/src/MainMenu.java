package src;

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
	
	private JFrame frame;
	private JPanel logo;
	private MainSubMenu subMenuFrame;
	private int[] playerNum;
	private JComboBox numChooser;
	private JButton startBtn;
	private JLabel lbCnt;
	
	public MainMenu() {
		
		/**The constructor of frame*/
		frame = new JFrame();
		
		/**The size of the frame*/
		frame.setSize(450, 475);
		
		frame.add(logo);
		
	}
}
