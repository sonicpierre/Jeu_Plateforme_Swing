package jereme.deplacement;

public class immobile implements deplacement{

	@Override
	public int deplacedroite(int x) {
		System.out.println("Je suis immobile");
		return 0;
	}

	@Override
	public int deplacegauche(int x) {
		System.out.println("Je suis immobile");
		return 0;
	}

	@Override
	public int deplacehaut(int y) {
		System.out.println("Je suis immobile");
		return 0;
	}

	@Override
	public int deplacebas(int y) {
		System.out.println("Je suis immobile");
		return 0;
	}


}
