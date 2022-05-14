package src;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Canvas extends JPanel {
	
	protected int verticesNum;
	protected Graphics shape;
	//protected ArrayList<View> thingsView;
	protected EnemyView enemy;
	protected EquipmentView equipment;
	protected MaterialView material;
	protected GenCodeView genCode;
	protected BearView bear;
	protected Image img;
	protected JButton[] buttons;
	
	public Canvas(int vert) {
		verticesNum = vert;
		
	}
	
	public void Draw(int vertices) {
		
	}
	
	public void ButtonPressed() {
		
	}
	
	public void Refresh() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(new ImageIcon("Lab_3").getImage(), 0,0,null);
		
		Graphics2D g2d = (Graphics2D) g;
		
	}

}
