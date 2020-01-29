package jereme.Carte;

import java.util.List;

import jereme.plateforme.Plateforme;

public interface CreerCarte {
	public Plateforme definirSol();
	public Plateforme definirMurDroite();
	public Plateforme definirMurGauche();
	public Plateforme definirPlateformeFinale();
	public List<Plateforme> listePlateformePourCollision();
}
