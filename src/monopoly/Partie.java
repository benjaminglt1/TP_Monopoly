package monopoly;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import Interface.Fenetre;

@objid ("7b930610-eebe-4074-ad48-42d3d4d1548b")
public class Partie {
    @objid ("c793caab-4fb8-4a7f-84e5-f3ddd213c864")
    private Plateau plateau;
    private int nbJ;
    private int jCourant;
    private Scanner sc = new Scanner(System.in);

    @objid ("dd810a91-7a46-49b1-98f4-9ef1afd6c8e2")
    private List<Joueur> joueurs = new ArrayList<Joueur> ();

    @objid ("ddfcb697-a1f4-4586-949a-46b3822aab7c")
    private Des des = new Des();

    @objid ("6131bad8-bb43-4e49-a9b3-51956e3848d3")
    public void lancerPartie() throws FileNotFoundException, IOException, ParseException {
    	plateau = new Plateau();
    	initJoueurs();
    	System.out.println(joueurs.size());
    	jouerJoueur();
    }
    
    public void initJoueurs() {
    	

    	System.out.print("Nombre de joueur ? (2 à 4)");
    	nbJ = sc.nextInt();
    	System.out.print("Somme de départ pour chaques joueurs ?");
    	int argentDepart = sc.nextInt();
    	for(int i=0;i<nbJ;i++) {
    		System.out.print("nom du joueur "+i+" ?");
    		Joueur j = new Joueur(sc.next(),this);
    		joueurs.add(j);
    		joueurs.get(i).initPositionJoueur(0);
    		joueurs.get(i).initArgent(argentDepart);
    		
    	}
    }

    @objid ("0c9b3c52-2d97-4633-8ba6-3dcb2d074284")
    public void jouerJoueur() {
    	Random random = new Random();
    	jCourant = random.nextInt(nbJ);
    	boolean endFlag = false;//drapeau de fin de partie
    	while(!endFlag){
    		System.out.println("C'est au joueur "+jCourant+" ("+this.joueurs.get(jCourant).getName()+") de jouer :");
    		des.lancerDes();
    		plateau.deplacerJoueur(this.joueurs.get(jCourant), des);
    		
    		
    		//actionsPossibles();
    		if(!des.verifDouble()) {
    			
    			jCourant = (jCourant+1)%nbJ;
    		}else {
    			System.out.println("C'est un double");
    		}
    		
    		if(verifFin()) {
    			endFlag = true;
    		}
    		
    	}
    }

    private boolean verifFin() {
		// TODO Auto-generated method stub
		return false;
	}

	private void actionsPossibles() {
		
		
	}

	@objid ("014fe146-4f72-4a1c-ae9b-81f0f6fc503e")
    public boolean interfaceAcheter(long prix) {
		System.out.println("Voulez vous acheter cette propriété ? prix: "+prix);
		System.out.println("1 - Acheter");
		System.out.println("2 - Ne pas acheter");
		switch(sc.nextInt()) {
			case 1:
				return true;
			 
		 	case 2:
		 		return false;
		 	
		 	default:
				System.out.println("Erreur : choix non valide");
				return false;
		}
    }

    @objid ("912328e1-25dc-402f-8938-c878b8d92373")
    public void demanderConstruire() {
    }

    @objid ("7fdce396-f2f4-4d16-823b-b675424d502d")
    public void interfaceLancerDes() {
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		Partie p = new Partie();
		p.lancerPartie();
		//FenTest ft = new FenTest();
		//FenTestBis ftb = new FenTestBis();
		
	}
    
    

}
