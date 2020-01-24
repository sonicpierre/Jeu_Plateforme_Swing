package jereme.fenetre;

import java.awt.Graphics;

public interface IRenderable {
	
	public void draw(Graphics g);
	
	public int getLayer();
}
