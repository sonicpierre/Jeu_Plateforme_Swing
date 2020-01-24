package jereme.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter {

	public static short KEY_Z = 0;

	private static KeyController instance;

	// boolean isPressed[] = {false,false,false,false}; //Correspond à dans l'ordre
	// z q d //Chois de le mettre "statique" comme on connait le nombre de touches

	boolean[] isPressed = new boolean[4]; // C'est plus propre pour initialiser un tableau de bool à false

	/*
	 * Tu peux remplacer l'utilisation d'indice 0, 1, 2, 3 pour z, q, s, d avec des
	 * constantes, de la même maniere que Keyboard.VK_Z
	 * 
	 * L'avantage de ma méthode et que c'est plus simple de t'y retrouver dans le
	 * code. Lorque tu auras des accès depuis un peu partout à KeyController (plus
	 * de 4 touches de jeux), tu seras très content d'avoir accès à la touche que tu
	 * veux de cette manière. Et déclarée une constante n'est pas très difficile.
	 * 
	 * Je te change ça pour z et tu feras le reste. (oublie pas de voir ce que j'ai
	 * fait en conséquence dans le Game.
	 * 
	 */

	boolean inanythingPressed = false; // Pas forcément utile tu peux le remplacer par un "ou" entre tous les booleans du tableau.

	private KeyController() {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		// Tu peux utiliser un switch :
		switch (e.getKeyCode()) {
		case KeyEvent.VK_Z:
			// ce qu'il y a à faire.
			break;
		}
		if (e.getKeyCode() == KeyEvent.VK_Z)
			isPressed[KEY_Z] = true;
		inanythingPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_Q)
			isPressed[1] = true;
		inanythingPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_D)
			isPressed[2] = true;
		inanythingPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_S)
			isPressed[3] = true;
		inanythingPressed = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		if (e.getKeyCode() == KeyEvent.VK_Z)
			isPressed[KEY_Z] = false;
		inanythingPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_Q)
			isPressed[1] = false;
		inanythingPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_D)
			isPressed[2] = false;
		inanythingPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_S)
			isPressed[3] = false;
		inanythingPressed = false;
	}

	public boolean[] getState() {
		return isPressed;
	}

	public boolean getAnyState() {
		return inanythingPressed;
	}

	public static KeyController getInstance() {
		if (instance == null)
			instance = new KeyController();
		return instance;
	}
}
