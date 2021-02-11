package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import monopoly.Joueur;

public class Plateau extends JPanel{
	private int DIM = 1000;
	private ArrayList<Joueur> joueurs;
	
	public Plateau(ArrayList<Joueur> listeJoueurs) {
		this.joueurs = listeJoueurs;
		this.setPreferredSize(new Dimension(DIM,DIM));
	}
	
	public void paintComponent(Graphics g) {		
		try {
			Image img = ImageIO.read(new File("monopoly-classique-plateau.jpg"));
			g.drawImage(img, 0, 0, DIM, DIM, this);
		} catch(IOException e) {
			e.printStackTrace();
		}
		g.setColor(Color.red);
		
		//Placement des pions sur le plateau
		int xDepart = this.getWidth()-122;
		int yDepert = this.getHeight()-120;
		int taillePion = 35;
		
		int xCase;
		int yCase;
		
		int xDifJoueur;
		int yDifJoueur;
		
		
		//TODO enlever 
		//xDepart -= 90;
		
		for(int i=0; i<joueurs.size(); i++) {
			
			//TODO calculer xCase et yCase
			int numCase = joueurs.get(i).position;
			xCase = xDepart + calculXCase(numCase);
			yCase = yDepert + calculYCase(numCase);
			
			//Pour j0 xCase et yCase
			//Pour j1 xCase+60 et yCase
			//Pour j2 xCase et yCase+60
			//Pour j3 xCase+60 et yCase+60
			xDifJoueur = calculXDifJoueur(i);
			yDifJoueur = calculYDifJoueur(i);
			
			g.drawImage(joueurs.get(i).pionImg, xCase+xDifJoueur, yCase+yDifJoueur, taillePion, taillePion, this);
			
		}
	}
	
	private int calculXDifJoueur(int numJoueur) {
		int ecart = 40;
		switch(numJoueur) {
			case 0:
				return 0;
			case 1:
				return ecart;
			case 2:
				return 0;
			case 3:
				return ecart;
			default:
				return 0;
		}
	}
	
	private int calculYDifJoueur(int numJoueur) {
		int ecart = 40;
		switch(numJoueur) {
			case 0:
				return 0;
			case 1:
				return 0;
			case 2:
				return ecart;
			case 3:
				return ecart;
			default:
				return 0;
		}
	}
	
	private int calculXCase(int numCase) {
		int d = -83;
		if(numCase >= 1 && numCase <= 9) {//case 1 a 10
			return numCase * d;
		}
		else if(numCase >= 11 && numCase <= 20) {//case 11 a 20
			return 10 * d - 30;
		}
		else if(numCase >= 21 && numCase <= 29) { //case 21 a 29
			switch(numCase) {
				case 21: return 9*d;
				case 22: return 8*d;
				case 23: return 7*d;
				case 24: return 6*d;
				case 25: return 5*d;
				case 26: return 4*d;
				case 27: return 3*d;
				case 28: return 2*d;
				case 29: return 1*d;
				default: return 0;
			}
		}
		else { //case 0, 31 a 39
			return 0;
		}
	}
	
	private int calculYCase(int numCase) {
		int d = -90;
		if(numCase >= 1 && numCase <= 10) {//case 1 a 10
			return 0;
		}
		else if(numCase >= 11 && numCase <= 20) {//case 11 a 20
			return (numCase - 10) * d;
		}
		else if(numCase >= 21 && numCase <= 29) { //case 21 a 29
			return 20 * d;
		}
		else { //case 0, 31 a 39
			switch(numCase) {
				case 31: return 9*d;
				case 32: return 8*d;
				case 33: return 7*d;
				case 34: return 6*d;
				case 35: return 5*d;
				case 36: return 4*d;
				case 37: return 3*d;
				case 38: return 2*d;
				case 39: return 1*d;
				default: return 0;
			}
		}
	}
}
