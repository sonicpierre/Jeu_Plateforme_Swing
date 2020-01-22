package jereme.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter{

	private static KeyController instance;
	boolean isZPressed = false;
	
	
	private KeyController() {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		if (e.getKeyCode() == KeyEvent.VK_Z)
			isZPressed = true;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		if (e.getKeyCode() == KeyEvent.VK_Z)
			isZPressed = false;
	}
	
	
	public boolean getZState() {
		return isZPressed;
	}
	
	public static KeyController getInstance() {
		if (instance == null)
			instance = new KeyController();
		return instance;
	}
}
