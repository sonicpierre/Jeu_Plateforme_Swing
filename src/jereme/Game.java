package jereme;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import jereme.control.KeyController;
import jereme.control.MouseController;
import jereme.fenetre.Pannnnneau;
import jereme.position.positionJoueur;

public class Game extends Thread {
	
	private static Game instance;
	
	private boolean isRunning;
	
	static List <MonRectangle> plateformesListe = new ArrayList<MonRectangle>();					//Permet d'avoir les plateformes dans un tableau de type liste
	
	static positionJoueur position;
	
	
	private Game() {
		super("Mon Thread de jeu");
		
		isRunning = true;
		
		this.start(); // Lancement du run()
	}
	
	@Override
	public void run() {
		super.run();
		position = new positionJoueur(0,0);
		
		// Début de jeu
		
		while (isRunning)
		{
			// Boucle 
			

			if(MouseController.getmouseInstance().getMouseState()) {								//A chaque fois qu'on appuie sur la sourie on ajoute une plateforme

				plateformesListe.add(new MonRectangle(MouseController.getmouseInstance().getSourisX(), MouseController.getmouseInstance().getSourisY(), 50 ,50));
				Pannnnneau.getInstance().repaint();
			}
			if(KeyController.getInstance().getAnyState()) {						//On regarde et on repaint seulement si une touche a été appuyé
				if(KeyController.getInstance().getState()[0]) {
					position.mouvementHautPerso();
				}
				if(KeyController.getInstance().getState()[1]) {
					position.mouvementGauchePerso();
				}
				if(KeyController.getInstance().getState()[2]) {
					position.mouvementDroitePerso();
				}
				if(KeyController.getInstance().getState()[3]) {
					position.mouvementBasPerso();
				}
				Pannnnneau.getInstance().repaint();
			}
			
			try {
				Thread.sleep(20);						//Permet de déterminer le temps entre chaque regard sur le moteur
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		
		// Fin de jeu
	}
	
	public static Game getInstance() {
		if (instance == null)
			instance = new Game();
		return instance;
	}
	
	
	
	public static List <MonRectangle> getPlateformes(){
		return plateformesListe;
	}
	
	public static MonOvale positionPerso() {
		return new MonOvale(position.getxPerso(), position.getyPerso(), 100, 100, new Color(50,100,200));
	}
	
}