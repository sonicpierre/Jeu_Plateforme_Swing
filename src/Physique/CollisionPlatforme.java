package Physique;


import java.util.List;

import jereme.Game;
import jereme.Joueur.personnage;
import jereme.plateforme.Plateforme;

public class CollisionPlatforme implements Collision {

	private static CollisionPlatforme instance;
	
	private CollisionPlatforme() {
	}
	
	

	public static CollisionPlatforme getInstance() {
		if (instance == null)
			instance = new CollisionPlatforme();
		return instance;
	}





	@Override
	public int ColisionHautBas(List<Plateforme> listePlateforme, personnage monPerso, double tempsEnAire, int PosYSol, double g, double tempsASautTop, int taillePerso) {
		
		for(Plateforme plateforme : listePlateforme) {
			//Cas où on tombe à cause de la gravite
			if(monPerso.isSautEnCour()) {
				double futurePosition = monPerso.sauter(tempsEnAire, PosYSol, g, tempsASautTop);
				//On vérifie si au prochain mouvement le perso sera sous la plateforme
				if( (futurePosition + taillePerso >plateforme.getPosY()) && (futurePosition)< (plateforme.getPosY()+plateforme.getHeight())){
					if((monPerso.posx+taillePerso>plateforme.getPosX())&&(monPerso.posx<plateforme.getPosX()+plateforme.getWidth())) {
						//System.out.println("Le bas de ma plateforme est à " + (plateforme.getPosY() + plateforme.getHeight()) + " je suis à " + monPerso.posy);
						if(plateforme.getPosY() + plateforme.getHeight() <= monPerso.posy) {
							//System.out.println("Je tape au niveau de mon saut en haut");
							monPerso.setSautEnCour(false);
							Game.getInstance().setTempsEnlaire(0); 			//On refait démarrer à 0 t quand on touche la tête contre une plateforme
							return plateforme.getPosY()+plateforme.getHeight();
						}else {
							//System.out.println("Je tape au niveau de mon saut en bas");
							monPerso.setEnLaire(false);
							monPerso.setSautEnCour(false);
							return plateforme.getPosY()-taillePerso;
						}
					}
				}
				//Cas où on tombe suite à un saut
			} else if((monPerso.isEnLaire()) && (!monPerso.isSautEnCour())) {
				double futurePosition = monPerso.gravite(tempsEnAire, PosYSol, g);
				if( (futurePosition + taillePerso >=plateforme.getPosY()) && (futurePosition)< (plateforme.getPosY()+plateforme.getHeight())){
					if((monPerso.posx+taillePerso>plateforme.getPosX())&&(monPerso.posx<plateforme.getPosX()+plateforme.getWidth())) {
						//System.out.println("Je tape dedans !!");
						monPerso.setEnLaire(false);
						//System.out.println(plateforme.getPosY() - taillePerso);
						return plateforme.getPosY() - taillePerso;
					}
				}
			}
		}
		//On tombe à cause du saut
		if(monPerso.isSautEnCour()) {
			//System.out.println("Je suis saute");
			return (int) monPerso.sauter(tempsEnAire, PosYSol, g, tempsASautTop);
		}else if (monPerso.isEnLaire()&&!monPerso.isSautEnCour()){			//On tombe à cause de la gravité
			//System.out.println("Je tombe à cause de la gravité");
			return (int) monPerso.gravite(tempsEnAire, PosYSol, g);
		}
		System.out.println("Je suis passé làà");
		//System.out.println("c'est en l'aire = " + monPerso.isEnLaire() + " Je saute = " + monPerso.isSautEnCour());
		return 0;
	}



	@Override
	public int ColisionDroite(List<Plateforme> listePlateforme, personnage monPerso, int taillePerso, int vitesseLateral, int TaillePerso) {
		int futureposition = monPerso.posx + vitesseLateral;
		boolean aToucheDroite = false;
		for(Plateforme plateforme : listePlateforme) {
			
			//On vérifie qu'on est encore sur la plateforme
			
			if(!monPerso.isEnLaire() && (monPerso.posx >= plateforme.getWidth() + plateforme.getPosX()) && (monPerso.posy + taillePerso == plateforme.getPosY())) {
				monPerso.setEnLaire(true);
			}
			
			if((plateforme.getPosY() > monPerso.posy) && (plateforme.getPosY() < monPerso.posy + taillePerso)) {
				
				if((plateforme.getPosX() < futureposition + TaillePerso) && (plateforme.getPosX() + plateforme.getWidth() > futureposition )) {
						aToucheDroite = true;
					}		
					
			}
			
			if((plateforme.getPosY() + plateforme.getHeight() > monPerso.posy) && (plateforme.getPosY() + plateforme.getHeight() < monPerso.posy + taillePerso)) {
				
				if((plateforme.getPosX() < futureposition + TaillePerso) && (plateforme.getPosX() + plateforme.getWidth() > futureposition )) {
						aToucheDroite = true;
					}		
				}
			
		}
		
		if(aToucheDroite) {
			return monPerso.posx;
			
		} else {
			return futureposition;
		}
	}
	
	
	@Override
	public int ColisionGauche(List<Plateforme> listePlateforme, personnage monPerso, int taillePerso, int vitesseLateral, int TaillePerso) {
		int futureposition = monPerso.posx - vitesseLateral;
		boolean aToucheGauche = false;
		for(Plateforme plateforme : listePlateforme) {
			//On vérifie qu'on est encore sur la plateforme
			
			if(!monPerso.isEnLaire() && (monPerso.posx + taillePerso <= plateforme.getPosX()) && (monPerso.posy + taillePerso == plateforme.getPosY())) {
				monPerso.setEnLaire(true);
			}
			
			if((plateforme.getPosY() > monPerso.posy) && (plateforme.getPosY() < monPerso.posy + taillePerso)&& (monPerso.posx + taillePerso > plateforme.getPosX())) {
				if(plateforme.getPosX() + plateforme.getWidth() >= futureposition) {
						aToucheGauche = true;
					}		
					
			}
			
			if((plateforme.getPosY() + plateforme.getHeight() > monPerso.posy) && (plateforme.getPosY() + plateforme.getHeight() < monPerso.posy + taillePerso)) {
				if((plateforme.getPosX() + plateforme.getWidth() >= futureposition) && (monPerso.posx + taillePerso > plateforme.getPosX())) {
						aToucheGauche = true;
					}		
				}
		}
		
		if(aToucheGauche) {
			return monPerso.posx;
			
		} else {
			return futureposition;
		}
	}
}
