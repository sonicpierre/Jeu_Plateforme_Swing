package jereme.deplacement;

public class courir implements deplacement{

	@Override
	public int deplacedroite(int x) {
		x+=5;
		return x;
	}

	@Override
	public int deplacegauche(int x) {
		x-=5;
		return x;
	}

	@Override
	public int deplacehaut(int y) {
		y-=5;
		return y;
	}

	@Override
	public int deplacebas(int y) {
		y+=5;
		return y;
	}


}
