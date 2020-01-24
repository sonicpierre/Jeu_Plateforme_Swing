package jereme.position;

// Zeubi on avait dit majuscule sur les objets
public class positionJoueur {
	
	/*
	 * As tu vraiment besoin d'un objet position joueur ? 
	 * (Il existe un objet Point en java, qui fais plus ou moins ce que tu veux, à part les déplacements.
	 * 
	 * Le mieux ca serait pas d'avoir un objet joueur ? 
	 * Et au passage tu pourrais y appeller ta fonction de dessin (comme on a vu avec le rectangle :p)
	 * 
	 * et fais moi penser à te parler des "interfaces du genre drawable" quand on aura le temps, ca va te rendre dingue ;p
	 *
	 *
	 * Enfin, y a vraiment besoin d'écrire perso dans chaque nom de méthode ?
	 * Tu utiliseras de toutes manières ses méthodes en faisant perso.méthode() donc le perso sera deja dit :D
	 */
	
	
	
	
	// Toujours en privé !!!!
	// Tous les atributs doivent être privé, ou au maximum protected, ca evite de faire n'importe quoi :D
	public int xPerso = 0; // C'est de bas à 0 pas besoin de lui dire ...
	public int yPerso = 0;

	public positionJoueur(int xPerso, int yPerso) {
		this.xPerso = xPerso; // ... surtout que tu changes la valeur ici.
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
