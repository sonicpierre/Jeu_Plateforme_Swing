package jereme.Joueur;
import java.awt.Color;
import java.awt.Graphics;

import jereme.Objet.Inventaire;
import jereme.deplacement.immobile;
import jereme.fenetre.Renderer;
public class guerrier extends personnage{

	//Inventaire sac = new Inventaire(10,3,3);
	
	public guerrier() {
		this.PVMax = 100;
		this.PMMax = 100;
		this.PV = 100;
		this.PM = 100;
		this.deplace = new immobile();
		this.sac = new Inventaire(10,3,3);
		Renderer.getInstance().add(this);
		}
	//Permettra à un feu de camps de restaurer toute sa vie
	
	public void RestaurerVie() {
		this.PV = this.PVMax;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(0, 255, 0));
		g.fillRect(posx,  posy, 100, 100);
	}

	@Override
	public int getLayer() {
		return Renderer.CHARACTER_LAYER;
	}
}