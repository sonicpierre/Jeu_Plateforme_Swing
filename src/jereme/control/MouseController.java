package jereme.control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseController extends MouseAdapter{

	private static MouseController mouseInstance;
	boolean isMousePressed = false;
	int xSourisClicked = 0;
	int ySourisClicked = 0;
	
	private MouseController() {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		isMousePressed = true;
		xSourisClicked = e.getX();
		ySourisClicked = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {			//indicateur de la souri relachée
		super.mouseReleased(e);
		isMousePressed = false;
		
	}
	
	public boolean getMouseState() {				//Retourne le booléen qui indique si la souris est appuyée ou non
		return isMousePressed;
	}
	
	public int getSourisX() {
		return xSourisClicked;
	}
	
	public int getSourisY() {
		return ySourisClicked;
	}
	
	public static MouseController getmouseInstance() {
		if(mouseInstance == null) {
			mouseInstance = new MouseController();
		}
		return mouseInstance;
		
	}
	
}
