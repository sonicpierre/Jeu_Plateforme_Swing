package Physique;

import java.util.List;
import jereme.MonRectangle;

public interface Collision {
	public boolean ColisionDroite(List<MonRectangle> rec, int x, int y);			//A repenser !!
	public boolean ColisionGauche(MonRectangle rec, int x, int y);
	public boolean ColisionBas(MonRectangle rec, int x, int y);
	public boolean ColisionSol(int y);
}
