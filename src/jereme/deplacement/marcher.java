package jereme.deplacement;

public class marcher implements deplacement{

	@Override
	public int deplacedroite(int x) {
		x++;
		return x;
	}

	@Override
	public int deplacegauche(int x) {
		x--;
		return x;
	}

	@Override
	public int deplacehaut(int y) {
		y--;
		return y;
	}


}
