package jereme.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter{

	private static KeyController instance;
	boolean isPressed[] = {false,false,false,false};					//Correspond à dans l'ordre z q d //Chois de le mettre "statique" comme on connait le nombre de touches 
	boolean inanythingPressed = false;
	private KeyController() {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		if (e.getKeyCode() == KeyEvent.VK_Z)
			isPressed[0]=true;
			inanythingPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_Q)
			isPressed[1]=true;
			inanythingPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_D)
			isPressed[2]=true;
			inanythingPressed = true;
		if (e.getKeyCode() == KeyEvent.VK_S)
			isPressed[3]=true;
			inanythingPressed = true;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		if (e.getKeyCode() == KeyEvent.VK_Z)
			isPressed[0]=false;
			inanythingPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_Q)
			isPressed[1]=false;
			inanythingPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_D)
			isPressed[2]=false;
			inanythingPressed = false;
		if (e.getKeyCode() == KeyEvent.VK_S)
			isPressed[3]=false;
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
