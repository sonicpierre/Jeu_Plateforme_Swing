package jereme.fenetre;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import jereme.Game;
import jereme.MonRectangle;
import jereme.control.KeyController;
import jereme.control.MouseController;

@SuppressWarnings("serial")
public class Pannnnneau extends JPanel {
	private static Pannnnneau instance;
	private Pannnnneau() {
		addKeyListener(KeyController.getInstance());
		addMouseListener(MouseController.getmouseInstance());
	}

	public void paintComponent(Graphics g, int xImage, int yImage, File image) {
		try {
			Image img = ImageIO.read(image);
			g.drawImage(img, xImage, yImage, this);

			// Pour une image de fond
			// g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Pannnnneau getInstance() {
		if (instance == null)
			instance = new Pannnnneau();
		return instance;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("Coucou !!!!", 500, 500);
		Game.positionPerso().draw(g);
		for (MonRectangle plateformes : Game.getPlateformes()) {
			plateformes.draw(g);
		}
		
		// System.out.println("Paint");

	}

}