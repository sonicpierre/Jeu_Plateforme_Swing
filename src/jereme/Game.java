package jereme;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Physique.CollisionPlatforme;
import jereme.Carte.CarteNiveau1;
import jereme.Joueur.guerrier;
import jereme.Joueur.personnage;
import jereme.control.KeyController;
import jereme.control.MouseController;
import jereme.fenetre.Pannnnneau;
import jereme.plateforme.Plateforme;

public class Game extends Thread {

	private static Game instance;

	private boolean isRunning;

	List<Plateforme> plateformesListe = new ArrayList<Plateforme>(); // Permet d'avoir les plateformes dans un
																		// tableau de type liste

	personnage Clovis = new guerrier();
	private int TaillePerso = 100;

	// On déclare une map que l'on a construit

	
	List<Plateforme> maListePourCollision;
	double tempsEnlaire;
	

	//Variables concernant la gravité
	int EPAISSEUR_MUR_GAUCHE = 20;
	int EPAISSEUR_MUR_DROIT = 20;
	double TEMPS_TRAVERSE_ECRANT_MAP1 = 0.8;
	CarteNiveau1 cartes1 = new CarteNiveau1(EPAISSEUR_MUR_GAUCHE, EPAISSEUR_MUR_DROIT, 150, 0.8);
	int POSITION_SOL = 0;
	double DUREE_SAUT = 0.7;
	int VITESSE_LATERALE =1;
	
	
	private Game() {
		super("Mon Thread de jeu");

		isRunning = true;

		this.start(); // Lancement du run()
		
		//On calcule la constante de gravite propre à la map au début du jeu
	}

	@Override
	public void run() {
		super.run();

		// Début de jeu

		// On charge la première carte

		maListePourCollision = cartes1.listePlateformePourCollision(); // On appelle la fonction qui crée les maps

		float tempsEnlaire = 0;

		while (isRunning) {

			// Boucle

			if (MouseController.getmouseInstance().getMouseState()) { // A chaque fois qu'on appuie sur la sourie on
																		// ajoute une plateforme
				if (plateformeExistePas(plateformesListe)) {
					plateformesListe.add(new Plateforme(MouseController.getmouseInstance().getSourisX(),
							MouseController.getmouseInstance().getSourisY(), 50, 50, new Color(50, 50, 50)));
				}
			}
			
			//Premier test de plateforme
			
			

			if (Clovis.isEnLaire()) {
				tempsEnlaire += 0.01; // Correspond à la cadence du thread
			} else {
				tempsEnlaire = 0;
			}
			
			if (KeyController.getInstance().getState()[KeyController.KEY_Q] && (Clovis.posx - VITESSE_LATERALE > EPAISSEUR_MUR_GAUCHE)){
				Clovis.posx = CollisionPlatforme.getInstance().ColisionGauche(maListePourCollision, Clovis, TaillePerso, 1, TaillePerso);
			}
			if (KeyController.getInstance().getState()[KeyController.KEY_D] && (Clovis.posx + VITESSE_LATERALE < 1000 - EPAISSEUR_MUR_DROIT)) {
				Clovis.posx = CollisionPlatforme.getInstance().ColisionDroite(maListePourCollision, Clovis, TaillePerso, 1, TaillePerso);
			}
			
			if ((KeyController.getInstance().getState()[KeyController.KEY_Z]) && !Clovis.isSautEnCour() && !Clovis.isEnLaire()) {
				Clovis.setSautEnCour(true);
				Clovis.setEnLaire(true);
				Clovis.posy = CollisionPlatforme.getInstance().ColisionHautBas(maListePourCollision, Clovis, tempsEnlaire, POSITION_SOL, cartes1.getCstGravite(), DUREE_SAUT, TaillePerso);
			} else if (Clovis.isSautEnCour()){
				Clovis.posy = CollisionPlatforme.getInstance().ColisionHautBas(maListePourCollision, Clovis, tempsEnlaire, POSITION_SOL, cartes1.getCstGravite(), DUREE_SAUT, TaillePerso);
				//System.out.println("Ceci est ma position en y = " + Clovis.posy);
			} else if (Clovis.isEnLaire() && !Clovis.isSautEnCour()) {
				Clovis.posy = CollisionPlatforme.getInstance().ColisionHautBas(maListePourCollision, Clovis, tempsEnlaire, POSITION_SOL, cartes1.getCstGravite(), DUREE_SAUT, TaillePerso);
			}
			
			if(!Clovis.isEnLaire() && !Clovis.isSautEnCour()) {
				POSITION_SOL=Clovis.posy;
			}
			
		

		try {
			Thread.sleep(10); // Permet de déterminer le temps entre chaque regard sur le moteur
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Pannnnneau.getInstance().repaint();

	}

	// Fin de jeu
	}

	private boolean plateformeExistePas(List<Plateforme> maPlateformeListe) {
		for (Plateforme plateforme : maPlateformeListe) {
			if ((MouseController.getmouseInstance().getSourisX() == plateforme.getPosX())
					&& ((MouseController.getmouseInstance().getSourisY() == plateforme.getPosY()))) {

				return false;

			}
		}
		return true;
	}

	public static Game getInstance() {
		if (instance == null)
			instance = new Game();
		return instance;
	}

	public static List<Plateforme> getPlateformes() {
		return Game.getInstance().plateformesListe;
	}

	public void setTempsEnlaire(double tempsEnlaire) {
		this.tempsEnlaire = tempsEnlaire;
	}
}