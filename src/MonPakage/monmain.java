package MonPakage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class monmain extends JFrame {

	private static final long serialVersionUID = -5875576434729094921L;

	public monmain() {
		super("My first swing app");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 500);
		//Penser à donner la taille de la fenêtre avant de centrer
		this.setLocationRelativeTo(null); //Permet de centrer qq soit l'écran
		
		JPanel contentPane = (JPanel) this.getContentPane();
		//contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 50));	//Permet de mettre les éléments les uns à côté des autres
		//Penser GridLayout() pour organiser en tableau
		
		contentPane.add(createToolBar(),BorderLayout.NORTH);
		
		//JButton clickme = new JButton("coucou");
		//clickme.setPreferredSize(new Dimension(100,0));
		JScrollPane clickme = new JScrollPane(new JTree());
		
		contentPane.add(clickme, BorderLayout.WEST);
		clickme.setPreferredSize(new Dimension(120,0));
		contentPane.add(createStatusBar(),BorderLayout.SOUTH); //Permet de faire une case à cocher
		
		JTextArea txtEditMe = new JTextArea("Bonjour toi...");
		JScrollPane scrContent = new JScrollPane(txtEditMe);
		contentPane.add(scrContent);
		
		contentPane.add(createRightPannel(), BorderLayout.EAST);
	}
	
	private JToolBar createToolBar() {
			JToolBar toolBar = new JToolBar();
			
			JButton fichier = new JButton("Fichier");
			toolBar.add(fichier);
			
			JButton source = new JButton("Source");
			toolBar.add(source);
			
			return toolBar;
	}
	
	private JPanel createStatusBar() {
		JPanel statusBar = new JPanel(new FlowLayout());
		
		JLabel lblStatus1 = new JLabel("Tous les droits sont à M VIRGAUX");
		//lblStatus1.setPreferredSize(new Dimension(50,50));
		statusBar.add(lblStatus1);
		
		return statusBar;
	}

	private JPanel createRightPannel() {
		JPanel rightBar = new JPanel(new GridLayout(2,1));
		rightBar.add(new JButton("Boutton 1"));
		rightBar.add(new JButton("Boutton 2"));
		
		return rightBar;
	}
	
	public static void main(String[] args) throws Exception{		//Pour éviter les erreurs
		/*
		 * Cours open classeroom
		 * 
		 * Fenetre fen = new Fenetre(); //Fenetre momo = new Fenetre();
		 * fen.setLocation(0, 0); //momo.setLocation(600,400); fen.setResizable(false);
		 */

		//On peut appliquer un look and feel
		
		UIManager.setLookAndFeel(new NimbusLookAndFeel());	//C'est une skin de fenêtre
		
		monmain mafenetre = new monmain();
		mafenetre.setVisible(true);
	}

}
