package jereme;

import jereme.control.KeyController;

public class Game extends Thread {
	
	private static Game instance;
	
	private boolean isRunning;
	
	
	private Game() {
		super("Mon Thread de jeu");
		
		
		isRunning = true;
		
		this.start(); // Lancement du run()
	}
	
	@Override
	public void run() {
		super.run();
		
		// Début de jeu
		
		while (isRunning)
		{
			// Boucle 
			
			System.out.println("Etat du bouton z : " + KeyController.getInstance().getZState());
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		 
		// Fin de jeu
	}
	
	public static Game getInstance() {
		if (instance == null)
			instance = new Game();
		return instance;
	}
}
