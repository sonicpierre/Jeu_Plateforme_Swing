package jereme.fenetre;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Renderer extends Canvas {
	
	public static final int TOP_LAYER = 3;
	public static final int BOT_LAYER = 0;
	
	public static final int BACKGROUND_LAYER = 0;
	public static final int ENEMY_LAYER = 1;
	public static final int CHARACTER_LAYER = 2;
	public static final int GUI_LAYER = 3;
	
	private static final int MAX_LAYER = 4;
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 1000;

	private static final Color backgroundColor = new Color(255, 0, 255);
	private static final Color transparentColor = new Color(0, 0, 0, 0);

	private static Renderer instance;

	private BufferedImage[] layers; // Chaque image représente un calque.
	private BufferedImage image;
	
	private List<IRenderable> elements;

	private Renderer() {
		elements = new ArrayList<IRenderable>();
		layers = new BufferedImage[MAX_LAYER];
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < MAX_LAYER; ++i)
			layers[i] = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
	}

	public void render() {
		Graphics g = image.getGraphics();
		g.setColor(backgroundColor);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		for (BufferedImage layer : layers) {
			Graphics2D g2d = (Graphics2D) layer.getGraphics();
			g2d.setBackground(transparentColor);
			g2d.clearRect(0, 0, WIDTH, HEIGHT);
		}

		for (IRenderable e : elements) {
			if (e.getLayer() > TOP_LAYER) continue;
			e.draw(layers[e.getLayer()].getGraphics());
		}
		
		for (BufferedImage layer : layers)
			g.drawImage(layer, 0, 0, null);
	}

	public static Renderer getInstance() {
		if (instance == null)
			instance = new Renderer();
		return instance;
	}

	@Override
	public void paint(Graphics g) {
		//super.paint(g);
		render();
		g.drawImage(image, 0, 0, null);
	}
	
	public void add(IRenderable renderable) {
		elements.add(renderable);
	}
	
	public void remove(IRenderable renderable) {
		elements.remove(renderable);
	}

}
