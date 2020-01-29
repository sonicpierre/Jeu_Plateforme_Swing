package jereme.Carte;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import jereme.plateforme.Plateforme;

public class CarteNiveau1 implements CreerCarte{
	
	private List <Plateforme> listeDePlateformes = new ArrayList<Plateforme>();

	private int largeurMurDroit;
	private int largeurMurgauche;
	private int epaisseurSol;
	private double cstGravite;
	private double TEMPS_TRAVERSE_MAP;
	
	public CarteNiveau1(int largeurMurDroit, int largeurMurGauche, int epaisseurSol, double TEMPS_TRAVERSE_MAP) {
		this.largeurMurDroit = largeurMurDroit;
		this.largeurMurgauche = largeurMurGauche;
		this.epaisseurSol = epaisseurSol;
		this.cstGravite = this.constanteGrav(TEMPS_TRAVERSE_MAP, 1000 - epaisseurSol);
		listeDePlateformes.add(definirSol());
		listeDePlateformes.add(definirMurDroite());
		listeDePlateformes.add(definirMurGauche());				
		listeDePlateformes.add(definirPlateformeFinale());
		listeDePlateformes.add(new Plateforme(630, 600, 150, 20, new Color(0, 100, 200)));
		listeDePlateformes.add(new Plateforme(250, 300, 150, 20, new Color(0, 100, 200)));
	}
	public int getLargeurMurDroit() {
		return largeurMurDroit;
	}
	public void setLargeurMurDroit(int largeurMurDroit) {
		this.largeurMurDroit = largeurMurDroit;
	}
	public int getLargeurMurgauche() {
		return largeurMurgauche;
	}
	public void setLargeurMurgauche(int largeurMurgauche) {
		this.largeurMurgauche = largeurMurgauche;
	}
	public int getEpaisseurSol() {
		return epaisseurSol;
	}
	public void setEpaisseurSol(int epaisseurSol) {
		this.epaisseurSol = epaisseurSol;
	}
	
	@Override
	public Plateforme definirSol() {
		return new Plateforme(0,1000-this.epaisseurSol, 1000, this.epaisseurSol, new Color(100, 100, 100));
	}

	@Override
	public Plateforme definirMurDroite() {
		return new Plateforme(1000-this.largeurMurDroit,0, this.largeurMurDroit, 1000-this.epaisseurSol, new Color(200, 100, 200));
	}

	@Override
	public Plateforme definirMurGauche() {
		return new Plateforme(0,0, this.largeurMurgauche, 1000-this.epaisseurSol, new Color(200, 100, 200));
	}

	@Override
	public Plateforme definirPlateformeFinale() {
		return new Plateforme(700,100, 200, 20, new Color(255, 255, 0));
	}

	@Override
	public List<Plateforme> listePlateformePourCollision() {
		return listeDePlateformes;
	}

	protected double constanteGrav(double tempsTraverseFenetre, int PosSol) {

		return 2 * (1000 - PosSol) / (tempsTraverseFenetre * tempsTraverseFenetre);
	}
	public double getCstGravite() {
		return cstGravite;
	}
	public double getTEMPS_TRAVERSE_MAP() {
		return TEMPS_TRAVERSE_MAP;
	}
	public void setTEMPS_TRAVERSE_MAP(int tEMPS_TRAVERSE_MAP) {
		TEMPS_TRAVERSE_MAP = tEMPS_TRAVERSE_MAP;
	}

}

	

