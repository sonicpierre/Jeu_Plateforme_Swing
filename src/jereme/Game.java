package jereme;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import jereme.Joueur.guerrier;
import jereme.Joueur.personnage;
import jereme.control.KeyController;
import jereme.control.MouseController;
import jereme.fenetre.Pannnnneau;


public class Game extends Thread {
	
	private static Game instance;
	
	private boolean isRunning;
	
	
	/*
	 * Pourquoi utiliser du static quand tu as un singleton ? 
	 * 
	 * Le singleton permet un accès à une instance unique depuis n'importe où.
	 * 
	 * Enleve ses statics inutiles et pas beaux
	 * 
	 */
	
	List <MonRectangle> plateformesListe = new ArrayList<MonRectangle>();					//Permet d'avoir les plateformes dans un tableau de type liste
	
	
	personnage Clovis = new guerrier();
	
	private Game() {
		super("Mon Thread de jeu");
		
		isRunning = true;
		
		this.start(); // Lancement du run()
	}
	
	@Override
	public void run() {
		super.run();
		
		// Début de jeu
		
		while (isRunning)
		{
			// Boucle 
			

			if(MouseController.getmouseInstance().getMouseState()) {								//A chaque fois qu'on appuie sur la sourie on ajoute une plateforme

				plateformesListe.add(new MonRectangle(MouseController.getmouseInstance().getSourisX(), MouseController.getmouseInstance().getSourisY(), 50 ,50));
				Pannnnneau.getInstance().repaint();
			}
			if(KeyController.getInstance().getAnyState()) {						//On regarde et on repaint seulement si une touche a été appuyé
				
				if(KeyController.getInstance().getState()[KeyController.KEY_Z]) {
					Clovis.marchehaut();
				}
				if(KeyController.getInstance().getState()[KeyController.KEY_Q]) {
					Clovis.marchegauche();
				}
				if(KeyController.getInstance().getState()[KeyController.KEY_D]) {
					Clovis.marchedroite();
				}
				if(KeyController.getInstance().getState()[KeyController.KEY_S]) {
					Clovis.marchebas();
				}
				Pannnnneau.getInstance().repaint();
			}
			
			try {
				Thread.sleep(10);						//Permet de déterminer le temps entre chaque regard sur le moteur
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
		return Game.getInstance().plateformesListe;
	}
	
	public static MonOvale positionPerso() {
		return new MonOvale(Game.getInstance().Clovis.posx,Game.getInstance().Clovis.posy, 100, 100, new Color(50,100,200));
	}
	
}