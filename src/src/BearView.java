package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class BearView extends View{
	
	private Graphics view;

	public void Draw(Graphics g, Point p) {
		// TODO Auto-generated method stub
		g.setColor(Color.pink);
		
		g.fillRect(p.x, p.y, 15, 15);
	}

}
