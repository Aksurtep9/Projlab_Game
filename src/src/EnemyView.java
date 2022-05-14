package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class EnemyView extends View{
	
	//private Graphics view;

	/**
	 * Draws circle to given coordinate
	 * @param p - top left corner of the rectangle
	 */
	public void Draw(Graphics g, Point p) {
		// TODO Auto-generated method stub
		g.setColor(Color.yellow);
		
		g.fillOval(p.x, p.y, 15, 15);
	}

}
