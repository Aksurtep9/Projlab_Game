package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MaterialView extends View{
	
	private Graphics view;

	/**
	 * Draws rectangle to given coordinate
	 * @param p -  top left corner of the rectangle
	 */
	public void Draw(Graphics g, Point p) {
		// TODO Auto-generated method stub
		view.setColor(Color.green);
		
		view.fillRect(p.x, p.y, 15, 15);
	}


}
