package src;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Canvas extends JPanel {
	
	protected int verticesNum;
	protected Graphics graphics;
	//protected ArrayList<View> thingsView;
	protected EnemyView enemy;
	protected EquipmentView equipment;
	protected MaterialView material;
	protected GenCodeView genCode;
	protected BearView bear;
	protected View field;
	//protected Image img;
	protected JButton[] buttons;
	
	public Canvas(int vert) {
		verticesNum = vert;
		buttons = new JButton[verticesNum];
		//System.out.println(verticesNum);
		for(int i = 0; i < verticesNum; i++) {
			buttons[i] = new JButton();
			this.add(buttons[i]);
		}
		enemy = new EnemyView();
		equipment = new EquipmentView();
		material = new MaterialView();
		genCode = new GenCodeView();
		bear = new BearView();
	}
	
	public void Draw(int vertices) {
		
		switch(vertices) {
		case 3:
			buttons[0].setBounds(200, 350, 150, 100);
			buttons[0].setVisible(true);
			buttons[1].setBounds(350, 400, 150, 100);
			buttons[1].setVisible(true);
			buttons[2].setBounds(350, 300, 150, 100);
			buttons[2].setVisible(true);
			
			
			break;
		case 4:
			buttons[0].setBounds(350, 100, 150, 100);
			buttons[0].setVisible(true);
			buttons[1].setBounds(600, 350, 150, 100);
			buttons[1].setVisible(true);
			buttons[2].setBounds(350, 600, 150, 100);
			buttons[2].setVisible(true);
			buttons[3].setBounds(100, 600, 150, 100);
			buttons[3].setVisible(true);
			break;
		case 5:
			buttons[0].setBounds(450, 150, 150, 100);
			buttons[0].setVisible(true);
			buttons[1].setBounds(400, 400, 150, 100);
			buttons[1].setVisible(true);
			buttons[2].setBounds(350, 500, 150, 100);
			buttons[2].setVisible(true);
			buttons[3].setBounds(300, 400, 150, 100);
			buttons[3].setVisible(true);
			buttons[4].setBounds(250, 150, 150, 100);
			buttons[4].setVisible(true);
			break;
		case 6:
			buttons[0].setBounds(450, 150, 150, 100);
			buttons[0].setVisible(true);
			buttons[1].setBounds(400, 400, 150, 100);
			buttons[1].setVisible(true);
			buttons[2].setBounds(350, 500, 150, 100);
			buttons[2].setVisible(true);
			buttons[3].setBounds(300, 400, 150, 100);
			buttons[3].setVisible(true);
			buttons[4].setBounds(250, 150, 150, 100);
			buttons[4].setVisible(true);
			buttons[5].setBounds(350, 150, 150, 100);
			buttons[5].setVisible(true);
			break;
		case 7:
			buttons[0].setBounds(450, 150, 150, 100);
			buttons[0].setVisible(true);
			buttons[1].setBounds(400, 400, 150, 100);
			buttons[1].setVisible(true);
			buttons[2].setBounds(350, 500, 150, 100);
			buttons[2].setVisible(true);
			buttons[3].setBounds(300, 400, 150, 100);
			buttons[3].setVisible(true);
			buttons[4].setBounds(250, 150, 150, 100);
			buttons[4].setVisible(true);
			buttons[5].setBounds(350, 150, 150, 100);
			buttons[5].setVisible(true);
			buttons[6].setBounds(150, 150, 150, 100);
			buttons[6].setVisible(true);
			break;
		case 8:
			buttons[0].setBounds(450, 150, 150, 100);
			buttons[0].setVisible(true);
			buttons[1].setBounds(400, 400, 150, 100);
			buttons[1].setVisible(true);
			buttons[2].setBounds(350, 500, 150, 100);
			buttons[2].setVisible(true);
			buttons[3].setBounds(300, 400, 150, 100);
			buttons[3].setVisible(true);
			buttons[4].setBounds(250, 150, 150, 100);
			buttons[4].setVisible(true);
			buttons[5].setBounds(350, 150, 150, 100);
			buttons[5].setVisible(true);
			buttons[6].setBounds(150, 150, 150, 100);
			buttons[6].setVisible(true);
			buttons[7].setBounds(150, 400, 150, 100);
			buttons[7].setVisible(true);
			break;
		default:
			break;
			
		}
		Point p = new Point(100,100);
		field.Draw(graphics,p);
		
	}
	
	public void ButtonPressed() {
		
	}
	
	public void Refresh() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}

}
