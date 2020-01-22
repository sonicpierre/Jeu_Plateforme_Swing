package jereme.fenetre;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Physique.Collision;
import Physique.CollisionPlatforme;
import jereme.MonRectangle;
import jereme.Text;
import jereme.control.KeyController;

@SuppressWarnings("serial")
public class Pannnnneau extends JPanel {

	private List<MonRectangle> rectangles;
	private List<File> images;
	private Text text = new Text();
	private static Random random = new Random();
	private boolean deplacementlateral = false;			//Permet de savoir comment se déplace le joueur en latéral


	int x = 0;				// x et y des plateformes
	int y = 0;
	int a=0;				//pour les animations

	int xImage = 10;		// x et y de l'image du perso
	int yImage = 800;
	Collision coco = new CollisionPlatforme();

	public int compteurPlateformes = 0;

	public Pannnnneau() {
		rectangles = new ArrayList<MonRectangle>();
		images = new ArrayList<File>();
		images.add(new File("personnage/megamanD1.gif"));
		images.add(new File("personnage/megamanD2.gif"));
		images.add(new File("personnage/megamanD3.gif"));
		images.add(new File("personnage/megamanD4.gif"));
		images.add(new File("personnage/megamanD5.gif"));
		images.add(new File("personnage/megamanD6.gif"));
		images.add(new File("personnage/megamanD7.gif"));
		images.add(new File("personnage/megamanD8.gif"));
		images.add(new File("personnage/megamanD9.gif"));
		addKeyListener(KeyController.getInstance());
		
		addMouseListener(new MouseAdapter() { // Ajout d'un event pour les clics

			public void mouseClicked(MouseEvent e) {
				int x = e.getX() - 30; // Coordonnée horizontale du clic
				int y = e.getY() - 30; // Coordonnée verticale du clic
				int w = 60; // Taille horizontale
				int h = 60; // Taille verticale
				Color c = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()); // Création d'une

				if (compteurPlateformes < 5) {
					rectangles.add(new MonRectangle(x, y, w, h, c)); // Ajout du rectangle a ma liste seulement si il y
					compteurPlateformes++; // a moins de 4 plateformes....
					repaint();
				}
			}
		});

	}
/*
	public void keyPressed(KeyEvent e) {

		/*
		if (this.compteurPlateformes >= 5) {

			if (e.getKeyChar() == 'z') {
				{
					this.yImage -= 10;
					deplacementlateral = true;
					repaint();

				}
			}

			if (e.getKeyChar() == 'q') {
				{
					this.xImage -= 10;
					deplacementlateral = true;
					// couleur aléatoire
					repaint();

				}
			}

			if (e.getKeyChar() == 'd') {
				{
					this.xImage += 10;
					deplacementlateral = true;
					repaint();

				}
			}
		}

	}

	public void keyReleased(KeyEvent arg0) {
		repaint();

	}

	public void keyTyped(KeyEvent e) {

	}
*/
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

	@Override
	public void paint(Graphics g) {

		super.paint(g);
		// System.out.println("Paint");

		if (this.compteurPlateformes < 5) {
			text.drawPlacement(g);
			text.drawNbPlateformes(g, 5 - this.compteurPlateformes);
		} else {
			text.drawDeplacement(g);
		}

		g.drawLine(0, 7 * this.getHeight() / 8, this.getWidth(), 7 * this.getHeight() / 8);

		// Permet d'afficher l'images qui corespond à un mouvement

		if (deplacementlateral == true) {
				
				System.out.println(a);
				paintComponent(g, this.xImage, this.yImage, images.get(this.a));
				try {
					Thread.sleep(60);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(this.a!=8) {
					repaint();
					this.a++;
				}
				else {
					this.a=0;
				}
			deplacementlateral = false;
		} else {
			if(this.coco.ColisionSol(this.yImage)) {
				paintComponent(g, this.xImage, this.yImage, new File("personnage/megamanImmo.gif"));
			}
			else {
				this.yImage+=5;
				paintComponent(g, this.xImage, this.yImage, new File("personnage/megamanImmo.gif"));
				System.out.println("SAlut");
				repaint();
			}
			
		}
		for (MonRectangle monRectangle : rectangles) {
			monRectangle.draw(g);
		}

	}
	
	private boolean colisionPlatforme(){
//			if(this.coco.ColisionDroite(rectangles, this.xImage, this.yImage)&&(this.coco.ColisionGauche(i, this.xImage, this.yImage))&&(this.coco.ColisionBas(i, this.xImage, this.yImage))){
//				System.out.println("Okkk");
//			}
//			else {
//				System.out.println("Tampis");
//				return false;
//			}
//		
		return true;
	}

}