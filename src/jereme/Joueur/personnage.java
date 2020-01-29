package jereme.Joueur;

import java.awt.Graphics;

import jereme.Objet.Inventaire;
import jereme.deplacement.*;
import jereme.fenetre.IRenderable;

public class personnage extends Physic implements IRenderable {
	protected int PVMax; // Nous permettra d'avoir des persos avec des PV et PM différents
	protected int PMMax;
	protected int PV;
	protected int PM;

	deplacement deplace = new marcher(); // Nous permettra de courrir et marcher dans différentes directions
	public int posx = 450; // On place notre perso en 0,0 au début
	public int posy = 0;

	private boolean EnLaire = true;
	private boolean SautEnCour = false;

	// Penser à redéfinir le mouvement comme un facteur * un nombre de pixel définit
	// par l'équipement

	public boolean isEnLaire() {
		return EnLaire;
	}


	public boolean isSautEnCour() {
		return SautEnCour;
	}



	public void setSautEnCour(boolean sautEnCour) {
		SautEnCour = sautEnCour;
	}



	public void setEnLaire(boolean enLaire) {
		EnLaire = enLaire;
	}

	Inventaire sac;

	public personnage() {
	}

	public personnage(int PMMax, int PVMax, deplacement deplace, Inventaire sac) {
		this.PVMax = PVMax;
		this.PMMax = PMMax;
		this.deplace = deplace;
		this.sac = sac;
	}

	public int getPV() {
		System.out.println("J'ai " + PV + " PV !!");
		return PV;
	}

	public void setPV(int pV) {
		PV = pV;
	}

	public int getPM() {
		System.out.println("J'ai " + PM + " PM !!");
		return PM;
	}

	public void setPM(int pM) {
		PM = pM;
	}

	public deplacement getDeplace() {
		return deplace;
	}

	// Chaque Personnage a les mêmes déplacements

	// Pour courir

	public void coursdroite() {
		this.deplace = new courir();
		this.posx = this.deplace.deplacedroite(this.posx);
	}

	public void coursgauche() {
		this.deplace = new courir();
		this.posx = this.deplace.deplacegauche(this.posx);
	}

	public void courshaut() {
		this.deplace = new courir();
		this.posy = this.deplace.deplacehaut(this.posy);
	}

	// Pour marcher

	public void marchedroite() {
		this.deplace = new marcher();
		this.posx = this.deplace.deplacedroite(this.posx);
	}

	public void marchegauche() {
		this.deplace = new marcher();
		this.posx = this.deplace.deplacegauche(this.posx);
	}

	public void marchehaut() {
		this.deplace = new marcher();
		this.posy = this.deplace.deplacehaut(this.posy);
	}

	//Permet définir un saut qui à la gravité mais le problèmè sera avec les plateformes quand on retourne posY
	
	public double sauter(double tempsEnAire, int PosYSol, double g, double tempsASautTop) {
		double vo = vitesseDusaut(PosYSol, g, tempsASautTop);
		return 0.5 * g * (tempsEnAire*tempsEnAire) - vo * tempsEnAire + PosYSol;
	}
	
	public void Arreter() {
		this.deplace = new immobile();
	}

	// Pour savoir où je suis

	public void OuSuisJe() {
		System.out.println("Je suis en x = " + this.posx + " et y = " + this.posy);
	}

	// Chaque Personnage peut ramasser des objets Gagner ou perdre des PV et mourir

	public void PerdreVie(int pointsVieARetirer) {
		this.PV -= pointsVieARetirer;
		if (this.PV <= 0) {
			System.out.println("GAME OVER");
		}
	}

	public void Interagir(int x, int y) {
		System.out.println("Je suis entrain d'interagir !!");
	}

	// Permet d'accéder à l'inventaire

	public Inventaire getSac() {
		return sac;
	}

	public void utiliserPotion() {
		this.getSac().utliserPotion();
		if (this.PV < this.PVMax - 10) {
			this.PV += 10;
		} else {
			this.PV = this.PVMax;
		}
	}

	public void utiliserGrossePotion() {
		this.getSac().utlisergrossePotion();
		if (this.PV < this.PVMax - 30) {
			this.PV += 30;
		} else {
			this.PV = this.PVMax;
		}
	}

	public double gravite(double tempsEnAire, int PosYSol, double g) {
		
		return (0.5) * g * (tempsEnAire * tempsEnAire) + PosYSol;
	}


	@Override
	public void draw(Graphics g) {
		// Pas utile dans personnage
		
	}


	@Override
	public int getLayer() {
		// Pas utile dans personnage
		return 0;
	}

}