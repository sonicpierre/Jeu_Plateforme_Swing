package jereme.Joueur;

public abstract class Physic {

	
	protected double vitesseDusaut(int PosYSol, double g, double tempsASautTop) {
		return g * tempsASautTop;
	}
}
