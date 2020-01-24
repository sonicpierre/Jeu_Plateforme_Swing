package jereme;

import java.awt.Color;
import java.awt.Graphics;

public class MonRectangle {

	private final int 	x, y, w, h;

	
	public MonRectangle(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(100, 100, 200));
		g.fillRect(x, y, w, h);
	}
}
