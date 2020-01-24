package jereme.Joueur;

import jereme.Objet.Inventaire;
import jereme.deplacement.*;
import jereme.fenetre.IRenderable;

public abstract class personnage implements IRenderable {
	protected int PVMax;			//Nous permettra d'avoir des persos avec des PV et PM différents
	protected int PMMax;
	protected int PV;
	protected int PM;
	
	deplacement deplace = new marcher();		//Nous permettra de courrir et marcher dans différentes directions
	public int posx=0;						//On place notre perso en 0,0 au début
	public int posy=0;
	
	//Penser à redéfinir le mouvement comme un facteur * un nombre de pixel définit par l'équipement
	
	Inventaire sac;
	
	public personnage() {}
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
	
	//Chaque Personnage a les mêmes déplacements
	
	//Pour courir
	
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
	public void coursbas() {
		this.deplace = new courir();
		this.posy = this.deplace.deplacebas(this.posy); 
	}
	
	//Pour marcher
	
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
	public void marchebas() {
		this.deplace = new marcher();
		this.posy = this.deplace.deplacebas(this.posy); 
	}
	
	public void Arreter() {
		this.deplace = new immobile();
	}
	
	//Pour savoir où je suis
	
	public void OuSuisJe() {
		System.out.println("Je suis en x = " + this.posx + " et y = " + this.posy);
	}
	
	//Chaque Personnage peut ramasser des objets Gagner ou perdre des PV et mourir
	
	
	public void PerdreVie(int pointsVieARetirer) {
		this.PV -= pointsVieARetirer;
		if(this.PV <= 0) {
			System.out.println("GAME OVER");
		}
	}
	
	public void Interagir(int x, int y) {
		System.out.println("Je suis entrain d'interagir !!");
	}
	
	//Permet d'accéder à l'inventaire
	
	public Inventaire getSac() {
		return sac;
	}
	
	public void utiliserPotion() {
		this.getSac().utliserPotion();
		if(this.PV<this.PVMax-10) {
			this.PV+=10;
		}
		else {
			this.PV=this.PVMax;
		}
	}
	
	public void utiliserGrossePotion() {
		this.getSac().utlisergrossePotion();
		if(this.PV<this.PVMax-30) {
			this.PV+=30;
		}
		else {
			this.PV=this.PVMax;
		}
	}
	
}
