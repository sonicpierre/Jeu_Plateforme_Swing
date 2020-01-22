package Physique;



import jereme.MonRectangle;
import java.util.List;
public class CollisionPlatforme implements Collision {



	@Override
	public boolean ColisionGauche(MonRectangle rec, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean ColisionBas(MonRectangle rec, int x, int y) {
		return false;
	}

	@Override
	public boolean ColisionSol(int y) {
		if ((y + 50) > 840) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ColisionDroite(List<MonRectangle> rec, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
