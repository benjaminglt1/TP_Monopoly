package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import monopoly.Joueur;

public class FenTestBis extends Frame {
	private Joueur joueur = new Joueur();
	
	public FenTestBis() {
		this.setTitle("Monopoly");
		this.setSize(this.getMaximumSize());
		this.setLayout(new BorderLayout());
		
		JPanel a = new JPanel();
		JButton t = new JButton("test");
		t.setSize(200, this.getHeight());
		a.setBackground(Color.cyan);
		a.add(t);
		JPanel b = new JPanel();
		b.setBackground(Color.yellow);
		
		JPanel c = new JPanel();
		c.setBackground(Color.pink);
		
		this.add(a, BorderLayout.WEST);
		this.add(b, BorderLayout.CENTER);
		this.add(c, BorderLayout.EAST);
		
		/*
		JPanel pjr = new JPanel();
		pjr.setBackground(Color.cyan);
		this.add(pjr);
		pjr.setBounds(0, 0, this.getWidth()/2, this.getHeight());
		*/
		
		
		this.setVisible(true);
	}
}
