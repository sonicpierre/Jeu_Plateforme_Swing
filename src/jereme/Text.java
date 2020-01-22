package jereme;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Text {

	
	public void drawPlacement(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int fontSize = 20;
        Font f = new Font("Comic Sans MS", Font.BOLD, fontSize);
        g2.setFont(f);
        g2.drawString("Placement des plateformes", 400, 50);
		}
	
	public void drawDeplacement(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int fontSize = 20;
        Font f = new Font("Comic Sans MS", Font.BOLD, fontSize);
        g2.setFont(f);
        g2.drawString("Sauter pour arriver à vos fins", 400, 50);
		}
	
	public void drawNbPlateformes(Graphics g, int Plat) {
        Graphics2D g2 = (Graphics2D) g;
        int fontSize = 10;
        Font f = new Font("Comic Sans MS", Font.BOLD, fontSize);
        g2.setFont(f);
        g2.drawString("Il reste que " + Plat + " plateformes", 470, 880);
		}
	
}
