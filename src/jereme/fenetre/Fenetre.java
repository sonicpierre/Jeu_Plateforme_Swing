package jereme.fenetre;

import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Fenetre extends JFrame {

	public Fenetre() {
		setSize(new Dimension(1000, 1000));
		Pannnnneau paneau = Pannnnneau.getInstance();
		paneau.setFocusable(true);
		getContentPane().add(paneau);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
}
