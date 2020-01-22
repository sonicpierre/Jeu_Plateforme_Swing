package jereme;

import java.awt.Color;
import java.awt.Graphics;

public class MonOvale {
	private final int x, y, height, width;
	private final Color couleur;
	
	public MonOvale(int x, int y, int height, int width, Color couleur) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.couleur=couleur;
	}
	public void draw(Graphics g) {
		g.setColor(couleur);
		g.fillOval(x, y, height, width);
	}

}
