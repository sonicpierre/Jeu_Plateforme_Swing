package jereme.equipement;

public enum casque {
	
	AucunCasque(0),					//NomDuCasque(Armure)
	
	CasqueMedieval(10),
	CasqueChevalier(10);
	
	private int armure;
	
	casque(int Armure) {
		this.armure=Armure;
	}

	public int getArmure() {
		return armure;
	}
	
}
