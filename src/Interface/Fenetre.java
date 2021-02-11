package Interface;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import monopoly.Joueur;

public class Fenetre extends Frame implements ActionListener{
	
	private Joueur joueur = new Joueur();

	final static int HAUTEUR = 1000;
	final static int LARGEUR = 1800;
	
	public Fenetre() {
		this.setTitle("Monopoly");
		this.setSize(this.getMaximumSize());
		this.setLayout(new BorderLayout());


		//Configuration pour les panels sur les cotés du plateau
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 1;
				
		
		ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
		joueurs.add(joueur);
		joueurs.add(joueur);
		joueurs.add(joueur);
		joueurs.add(joueur);
		
		//Création du plateau au centre :
		Plateau plateau = new Plateau(joueurs);
		plateau.setMinimumSize(new Dimension(1000, 1000));
		
		
		
		//Création panel player left
		JPanel pjl = new JPanel(new GridLayout(2,1));
				
		//Création du player top-left
		Player ptl = new Player(joueur);
		pjl.add(ptl);
		
		//Création du player bot-left
		Player pbl = new Player(joueur);
		pjl.add(pbl);
		
		
		
		//Création panel player right
		JPanel pjr = new JPanel(new GridLayout(2, 1));
		
		//Création du player top-right
		Player ptr = new Player(joueur);
		pjr.add(ptr);
		
		//Création du player bot-right
		Player pbr = new Player(joueur);
		pjr.add(pbr);
		
		
		
		//Ajout des players interface dans la fenetre
		this.add(pjl, BorderLayout.WEST);
		this.add(plateau, BorderLayout.CENTER);
		this.add(pjr, BorderLayout.EAST);
		
		
	    //Ecouteur pour fermer fenetre
	    this.addWindowListener(new java.awt.event.WindowAdapter() {
	    	public void windowClosing(java.awt.event.WindowEvent evt) {
                dispose();
	    	}
	    });
	    
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Fenetre f = new Fenetre();
		//FenTest ft = new FenTest();
		//FenTestBis ftb = new FenTestBis();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
