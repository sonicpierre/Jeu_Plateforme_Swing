package jereme.position;

public class positionJoueur {
	public int xPerso = 0;
	public int yPerso = 0;

	public positionJoueur(int xPerso, int yPerso) {
		this.xPerso = xPerso;
		this.yPerso = yPerso;
	}

	public int getxPerso() {
		return xPerso;
	}

	public void mouvementDroitePerso() {
		this.xPerso = xPerso + 5;
	}

	public void mouvementGauchePerso() {
		this.xPerso = xPerso - 5;
	}

	public void mouvementHautPerso() {
		this.yPerso = yPerso - 5;
	}

	public void mouvementBasPerso() {
		this.yPerso = yPerso + 5;
	}

	public int getyPerso() {
		return yPerso;
	}

}
