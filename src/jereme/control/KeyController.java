package jereme.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter{

	boolean isZPressed = false;
	
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
}
