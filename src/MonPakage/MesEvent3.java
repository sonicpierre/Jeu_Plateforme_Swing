package MonPakage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class MesEvent3 extends JFrame {
	menuBarsample menu = new menuBarsample();

	private static final long serialVersionUID = -5875576434729094921L;

	public MesEvent3() {
		super("Word Maison");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);		//On pourra mettre une boite de confirmation comme ça
		this.setSize(500, 500);
		//Penser à donner la taille de la fenêtre avant de centrer
		this.setLocationRelativeTo(null); //Permet de centrer qq soit l'écran
		JPopupMenu popUpMenu = this.createPopupMenu();
		JPanel contentPane = (JPanel) this.getContentPane();
		//contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 50));	//Permet de mettre les éléments les uns à côté des autres
		//Penser GridLayout() pour organiser en tableau

		
		
		contentPane.add(createTopSet(),BorderLayout.NORTH);

		//JButton clickme = new JButton("coucou");
		//clickme.setPreferredSize(new Dimension(100,0));
		JScrollPane arbre = new JScrollPane(new JTree());

		contentPane.add(arbre, BorderLayout.WEST);
		arbre.setPreferredSize(new Dimension(120,0));
		contentPane.add(createStatusBar(),BorderLayout.SOUTH); //Permet de faire une case à cocher

		JTextArea txtEditMe = new JTextArea("Bonjour toi...");
		JScrollPane scrContent = new JScrollPane(txtEditMe);
		txtEditMe.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent event) {
				if(event.isPopupTrigger()) {
					popUpMenu.show(event.getComponent(), event.getX(), event.getY());
					menu.actCut(txtEditMe);
				}
			}

		});


		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, arbre, scrContent);

		contentPane.add(splitPane);

		contentPane.add(createRightPannel(), BorderLayout.EAST);

		this.addWindowListener(new WindowAdapter() {
			//Permet de confirmer avant de quitter le la fenêtre
			public void windowClosing(java.awt.event.WindowEvent e) {
				int clickedButton =	JOptionPane.showConfirmDialog(MesEvent3.this, "T'es sur ?","Confirmation",JOptionPane.YES_NO_OPTION);
				if (clickedButton == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu monPopUp = new JPopupMenu();

		monPopUp.add(menu.actNew);
		monPopUp.add(menu.actCopy);
		monPopUp.add(menu.actCut);
		monPopUp.add(menu.actPaste);
		return monPopUp;
	}

	private JPanel createTopSet() {

		JPanel setHaut = new JPanel(new GridLayout(2,1));
		JToolBar toolBar = new JToolBar();

		JButton fichier = toolBar.add(menu.actNew);
		fichier.setToolTipText("Permet de créer un nouveau fichier");
		toolBar.add(fichier);

		JMenuBar menuBar = new JMenuBar();
		menuBar = menu.createMenuBar();
		setHaut.add(menuBar);
		setHaut.add(toolBar);
		return setHaut;
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
		JButton monBouton = new JButton("Boutton 1");
		monBouton.addMouseListener( new MouseAdapter() {


			@Override
			public void mouseExited(MouseEvent arg0) {
				monBouton.setForeground(Color.BLACK);
				System.out.println("He ça marche");

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				monBouton.setForeground(Color.RED);

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("T'as clické !!");

			}
		});
		rightBar.add(monBouton);

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

		MesEvent3 mafenetre = new MesEvent3();
		mafenetre.setVisible(true);
	}

}
