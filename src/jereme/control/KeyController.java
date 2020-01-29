package jereme.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter {

	public static short KEY_Z = 0;
	public static short KEY_Q = 1;
	public static short KEY_S = 2;
	public static short KEY_D = 3;
	
	private static KeyController instance;


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


	private KeyController() {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);

		
		if(e.getKeyCode() == KeyEvent.VK_Z)
			isPressed[KEY_Z] = true;
		
		if(e.getKeyCode() == KeyEvent.VK_Q)
			isPressed[KEY_Q] = true;

		if (e.getKeyCode() == KeyEvent.VK_D)
			isPressed[KEY_D] = true;

		if (e.getKeyCode() == KeyEvent.VK_S)
			isPressed[KEY_S] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);

		
		if (e.getKeyCode() == KeyEvent.VK_Z)
			isPressed[KEY_Z] = false;
		
		if (e.getKeyCode() == KeyEvent.VK_Q)
			isPressed[KEY_Q] = false;
		
		if (e.getKeyCode() == KeyEvent.VK_D)
			isPressed[KEY_D] = false;
		
		if (e.getKeyCode() == KeyEvent.VK_S)
			isPressed[KEY_S] = false;
		
	}

	public boolean[] getState() {
		return isPressed;
	}

	public static KeyController getInstance() {
		if (instance == null)
			instance = new KeyController();
		return instance;
	}
}
