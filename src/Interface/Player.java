package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import monopoly.Joueur;
import monopoly.Propriete;

public class Player extends JPanel {
	private Joueur j;
	
	Player(Joueur j){ //Use : ImageIcon pion = new ImageIcon("mon_image.jpg");
		this.j = j;
		
		this.setMinimumSize(new Dimension(400, 1000));
		this.setPreferredSize(new Dimension(460, 1000));
		this.setLayout(new BorderLayout());
		this.setBackground(Color.white);
		
		//Création partie info joueur
		JPanel pij = new JPanel(new GridBagLayout());
		pij.setBackground(Color.WHITE);
		
		JPanel pp = new JPanel();
		pp.setBackground(Color.white);
		pp.setPreferredSize(new Dimension(100, 100));
		JLabel imgp = new JLabel(j.pion);
		pp.add(imgp);
		pij.add(pp);
		
		//Info nom & argent
		JPanel spij = new JPanel();
		spij.setBackground(Color.white);
		
		Label jn = new Label(j.name);
		Label ja = new Label(j.argent + " $");
		spij.add(jn);
		spij.add(ja);
		pij.add(spij);
		
		this.add(pij, BorderLayout.NORTH);
		
		
		//Création partie propriete
		
		JPanel p = new JPanel(new GridLayout(2, 4));
		

		//afficher les 11 premieres prop
		
		int limite = 7;
		int k = 0;
		while(k < limite) {
			ProprieteCanvas pc;
			if(k < j.propriete.size()) {
				pc = new ProprieteCanvas(j.propriete.get(k));
			}
			else {
				pc = new ProprieteCanvas(new Propriete());
			}
			p.add(pc);
			k++;
		}
		
		this.add(p, BorderLayout.CENTER);
		
	}
}
