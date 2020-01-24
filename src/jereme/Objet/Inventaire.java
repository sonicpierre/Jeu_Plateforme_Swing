package jereme.Objet;


public class Inventaire {
	protected int Contenance=0;
	protected int nbPotion=0;
	protected int nbGrossePotion=0;
	
	Soin soin = new AucunePotion();
	
	public Inventaire() {}
	public Inventaire(int contenance, int nbPotion, int nbGrossePotion) {
		this.Contenance=contenance;
		this.nbPotion=nbPotion;
		this.nbGrossePotion=nbGrossePotion;
	}
	
	//Permet d'utiliser les différentes potions
	
	public void utliserPotion() {
		if(nbPotion != 0) {
			this.nbPotion--;
			this.soin = new Potion();
			this.setSoin(this.soin);
			this.soin.soigner();
		}
		else {
			this.soin = new AucunePotion();
			this.setSoin(this.soin);
			this.soin.soigner();
		}
	}
	
	public void utlisergrossePotion() {
		if(nbPotion != 0) {
			this.nbGrossePotion--;
			this.soin = new grossePotion();
			this.setSoin(this.soin);
			this.soin.soigner();
		}
		else {
			this.soin = new AucunePotion();
			this.setSoin(this.soin);
			this.soin.soigner();
		}
	}
	
	
	//Permet de ramassser une potion
	
	public void ramasserPotion() {
		if((this.nbPotion + this.nbGrossePotion)<=this.Contenance) {
			this.nbPotion++;
		}
		else {
			System.out.println("Le sac est plein c'est con");
		}
	}
	public void ramasserGrossePotion() {
		if((this.nbPotion + this.nbGrossePotion)<=this.Contenance) {
			this.nbGrossePotion++;
		}
		else {
			System.out.println("Le sac est plein c'est con");
		}
	}
	
	//Permet de savoir combien il nous reste de potions !!
	
	public int getContenance() {
		return Contenance;
	}

	public int getNbPotion() {
		return nbPotion;
	}

	public int getNbGrossePotion() {
		return nbGrossePotion;
	}


	public void setSoin(Soin soin) {
		this.soin = soin;
	}
	
	@Override
	public String toString() {
		return "Inventaire [Contenance=" + Contenance + ", nbPotion=" + nbPotion + ", nbGrossePotion=" + nbGrossePotion + "]";
	}

	
}
