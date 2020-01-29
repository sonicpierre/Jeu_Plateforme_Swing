package jereme.fenetre;

import java.awt.Graphics;

import javax.swing.JPanel;

import jereme.control.KeyController;
import jereme.control.MouseController;

@SuppressWarnings("serial")
public class Pannnnneau extends JPanel {
	private static Pannnnneau instance;
	private Pannnnneau() {
		addKeyListener(KeyController.getInstance());
		addMouseListener(MouseController.getmouseInstance());
		add(Renderer.getInstance());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Renderer.getInstance().paint(g);
	}
	
	
	public static Pannnnneau getInstance() {
		if (instance == null)
			instance = new Pannnnneau();
		return instance;
	}
}