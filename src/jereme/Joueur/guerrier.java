package jereme.Joueur;
import jereme.Objet.*;
import jereme.deplacement.*;
public class guerrier extends personnage{

	//Inventaire sac = new Inventaire(10,3,3);
	
	public guerrier() {
		this.PVMax = 100;
		this.PMMax = 100;
		this.PV = 100;
		this.PM = 100;
		this.deplace = new immobile();
		this.sac = new Inventaire(10,3,3);
		
		}
	//Permettra à un feu de camps de restaurer toute sa vie
	
	public void RestaurerVie() {
		this.PV = this.PVMax;
	}
}