package jereme.plateforme;

import java.awt.Color;
import java.awt.Graphics;

import jereme.fenetre.IRenderable;
import jereme.fenetre.Renderer;

public class Plateforme implements IRenderable{
	private int posX;
	private int posY;
	private int width;
	private int height;
	private Color color;
	
	public Plateforme(int x, int y, int width, int height, Color c) {
		this.posX = x;
		this.posY = y;
		this.color = c;
		this.width = width;
		this.height = height;
		Renderer.getInstance().add(this);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(this.posX, this.posY, this.width, this.height);
	}

	@Override
	public int getLayer() {
		return Renderer.BACKGROUND_LAYER;
	}
	
	
}
