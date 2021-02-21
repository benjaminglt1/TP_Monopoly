package Interface;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagLayout;

import monopoly.Joueur;

public class FenTest extends Frame {
	private Joueur joueur = new Joueur();
	
	public FenTest() {
		this.setTitle("Monopoly");
		this.setSize(new Dimension(400, 500));
		
		Player ptl = new Player(joueur);
		
		this.add(ptl);
		
		this.setVisible(true);
	}
}
