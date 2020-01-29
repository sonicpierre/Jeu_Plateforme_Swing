package Physique;

import java.util.List;

import jereme.Joueur.personnage;
import jereme.plateforme.Plateforme;

public interface Collision {
	public int ColisionGauche(List<Plateforme> listePlateforme, personnage monPerso, int taillePerso, int vitesseLateral, int TaillePerso);
	public int ColisionDroite(List<Plateforme> listePlateforme, personnage monPerso, int taillePerso, int vitesseLateral, int TaillePerso);
	public int ColisionHautBas(List<Plateforme> listePlateforme, personnage monPerso, double tempsEnAire, int PosYSol,
			double tempsTraverseFenetre, double tempsASautTop, int taillePerso);

}
