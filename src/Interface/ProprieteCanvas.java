package Interface;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import monopoly.Propriete;

public class ProprieteCanvas extends Canvas {
	private Propriete p;
	
	public ProprieteCanvas(Propriete p ) {
		this.p = p;
	}
	
	public void paint(Graphics g) {
		//background white
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		if(p.color == Color.black) return;
		//zone texte nom prop
		g.setColor(p.color);
		g.fillRect(0, 0, this.getWidth(), 40);
		
		//cadre
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, this.getWidth(), 40);
		g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
		
		
		//zone loyer
		
		int xl = 10; //x label
		int xv = 80; //x value
		int y = 22;
		int ecart = 17; 
		
		g.drawString(p.nom, p.xNom, y);
		
		y += 40;
		g.drawString("Terrain nu", xl, y);
		g.drawString(Integer.toString(p.terrainNu), xv, y);
		y += ecart;
		g.drawString("1 Maison", xl, y);
		g.drawString(Integer.toString(p.uneMaison), xv, y);
		y += ecart;
		g.drawString("2 Maisons", xl, y);
		g.drawString(Integer.toString(p.deuxMaisons), xv, y);
		y += ecart;
		g.drawString("3 Maisons", xl, y);
		g.drawString(Integer.toString(p.troisMaisons), xv, y);
		y += ecart;
		g.drawString("4 Maisons", xl, y);
		g.drawString(Integer.toString(p.quatreMaisons), xv, y);
		y += ecart;
		g.drawString("HOTEL", xl, y);
		g.drawString(Integer.toString(p.hotel), xv, y);
		
		//zone prix maison
		y += 25;
		g.drawString("Prix Maisons :", xl, y);
		g.drawString(Integer.toString(p.prixMaison), xv, y);
		//TODO
	}

}
