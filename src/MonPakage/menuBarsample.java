package MonPakage;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class menuBarsample extends JFrame{


	private static final long serialVersionUID = -5257593552959134741L;

	public menuBarsample() {
		super("Nouveau menu");
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.setJMenuBar(createMenuBar());
	}

	public JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu numFile = new JMenu("File");		//Il s'agie d'un onglet
		numFile.setMnemonic('F');
		numFile.add(actNew);
		numFile.addSeparator();
		numFile.add(actCut);
		numFile.addSeparator();
		numFile.add(actCopy);
		numFile.addSeparator();
		JMenuItem menuOpen = new JMenuItem ("Open File...");
		numFile.add(actPaste);
		numFile.addSeparator();
		numFile.add(menuOpen);
		menuBar.add(numFile);

		JMenu parametre = new JMenu("Paramètre");
		parametre.setMnemonic('P');
		JMenuItem menuCouleur = new JMenuItem ("Couleur");
		parametre.add(menuCouleur);
		menuBar.add(parametre);
		return menuBar;
	}

	public AbstractAction actNew = new AbstractAction() {

		private static final long serialVersionUID = -4143529234181763017L;

		{//C'est le constructeur
			putValue (Action.NAME, "File");
			putValue (Action.SMALL_ICON, new ImageIcon("icons/file.png"));
			putValue (Action.MNEMONIC_KEY, KeyEvent.VK_N);
			putValue( Action.SHORT_DESCRIPTION, "File (CTRL+N)");
			putValue ( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JMenuItem menuNew = new JMenuItem ();
			JOptionPane.showMessageDialog(menuNew,"Ca fera un nouveau fichier");

		}
	};

	public AbstractAction actCopy = new AbstractAction() {

		private static final long serialVersionUID = -4143529234181763017L;

		{//C'est le constructeur
			putValue (Action.NAME, "Copy");
			putValue (Action.SMALL_ICON, new ImageIcon("icons/copy.png"));
			putValue (Action.MNEMONIC_KEY, KeyEvent.VK_C);
			putValue( Action.SHORT_DESCRIPTION, "Copy (CTRL+C)");
			putValue ( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			JMenuItem menuCopy = new JMenuItem ();
			JOptionPane.showMessageDialog(menuCopy,"Ca copie ce qu'on veut");

		}
	};

	public AbstractAction actCut = new AbstractAction() {

		private static final long serialVersionUID = -4143529234181763017L;

		{//C'est le constructeur
			putValue (Action.NAME, "Cut");
			putValue (Action.SMALL_ICON, new ImageIcon("icons/couper.png"));
			putValue (Action.MNEMONIC_KEY, KeyEvent.VK_X);
			putValue( Action.SHORT_DESCRIPTION, "Cut (CTRL+X)");
			putValue ( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			JMenuItem menuCut = new JMenuItem ();
			JOptionPane.showMessageDialog(menuCut,"Ca coupe ce qu'on veut");

		}
	};

	public AbstractAction actPaste = new AbstractAction() {

		private static final long serialVersionUID = -4143529234181763017L;

		{//C'est le constructeur
			putValue (Action.NAME, "Paste");
			putValue (Action.SMALL_ICON, new ImageIcon("icons/paste.png"));
			putValue (Action.MNEMONIC_KEY, KeyEvent.VK_T);
			putValue( Action.SHORT_DESCRIPTION, "Cut (CTRL+V)");
			putValue ( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			JMenuItem menuCut = new JMenuItem ();
			JOptionPane.showMessageDialog(menuCut,"Ca colle putain !!!");

		}
	};
	public void actCut(JTextArea t) {
		t.copy();
	}
	public static void main(String[] args) throws Exception{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		menuBarsample window = new menuBarsample();
		window.setVisible(true);

	}
}
