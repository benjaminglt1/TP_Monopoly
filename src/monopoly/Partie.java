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
    	System.err.println("Initialisation de la Partie:\n");
    	
    	initJoueurs();
    	
    	//System.err.println("\nLa Partie commence:\n");
    	jouerJoueur();
    }
    
    public void initJoueurs() {
    	
    	System.out.print("Somme de départ pour chaques joueurs ?");
    	int argentDepart = sc.nextInt();
    	System.out.print("Nombre de joueur ? (2 à 4)");
    	nbJ = sc.nextInt();
    	
    	for(int i=0;i<nbJ;i++) {
    		System.out.print("    Nom du joueur "+(i+1)+" ?");
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
    		System.out.println("\nC'est au joueur "+(jCourant+1)+" ("+this.joueurs.get(jCourant).getName()+") de jouer :");
    		des.lancerDes();
    		plateau.deplacerJoueur(this.joueurs.get(jCourant), des);
    		
    		
    		actionsPossibles();
    		
 
    		if(this.joueurs.get(jCourant).getArgent()<0) {
    			System.out.println("Le joueur "+(jCourant+1) + " ("+ this.joueurs.get(jCourant).getName()+ ") a fait faillite");
    			this.joueurs.get(jCourant).clearPropriete();
    			this.joueurs.remove(jCourant);
    			nbJ--;
    		}else {
    			if(!des.verifDouble()) {
	    			
        			jCourant = (jCourant+1)%nbJ;
        		}else {
        			System.out.println("\nC'est un double");
        		}
    		}
    		
    		if(verifFin()) {
    			endFlag = true;
    			fin();
    		}
    		
    	}
    }

    private void fin() {
		System.out.println("\nFin de la partie\nC'est le joueur "+(((jCourant+1)%nbJ)+1) + " ("+ this.joueurs.get(0).getName()+ ") qui gagne !");
		
	}

	private boolean verifFin() {
		if(this.joueurs.size()<2) {
			return true;
		}
		return false;
	}

	private void actionsPossibles() {
		System.out.println("\nActions possibles :");
		System.out.println("1- Construire des maisons");
		System.out.println("2- Vendre des terrains");
		System.out.println("3- Lister mes propriete");
		System.out.println("4- Finir mon tour");
		switch(sc.nextInt()) {
			case 1:
				if(afficheTerrainsConstructibles()) {
					demanderConstruire(this.joueurs.get(jCourant).getProprieteConstructibles().get(sc.nextInt()-1));
				}
				
				actionsPossibles();
				break;
			case 2:
				if(afficheTerrains()) {
					this.joueurs.get(jCourant).getPropriete().get(sc.nextInt()-1).vendre();
				}
				actionsPossibles();
				break;
			case 3:
				afficheTerrains();
				actionsPossibles();
				break;
			case 4:
				break;
			default:
				System.out.println("Erreur : Choix non valide");
				break;
		}
		
		
	}

	private void demanderConstruire(Propriete propriete) {
		this.joueurs.get(jCourant).construireMaison(propriete);
	}

	private boolean afficheTerrains() {
		ArrayList<Achetables> prop = (ArrayList<Achetables>) this.joueurs.get(jCourant).getPropriete();
		if(prop.size() == 0) {
			System.out.println("\nVous ne possédez pas de propriétés");
			return false;
		}else {
			System.out.println("\nListe de vos propriétés :");
			
			for(int i =0;i<prop.size();i++) {
				System.out.println((i+1)+"- "+prop.get(i).getNom());
			}
			return true;
		}
	}

	private boolean afficheTerrainsConstructibles() {
		ArrayList<Propriete> prop = (ArrayList<Propriete>) this.joueurs.get(jCourant).getProprieteConstructibles();
		if(prop.size() == 0) {
			System.out.println("\nVous ne possédez pas de propriété constructible");
			return false;
		}else {
			System.out.println("\nVotre Solde: "+this.joueurs.get(jCourant).getArgent());
			System.out.println("\nListe des propriétés constructibles :");
			
			for(int i =0;i<prop.size();i++) {
				System.out.println((i+1)+"- "+prop.get(i).getNom() + " - Prix Maison: "+prop.get(i).getPrixMaison() + " - Nombre de maisons construites: "+prop.get(i).getNbMaisons());
			}
			return true;
		}
		
	}

	@objid ("014fe146-4f72-4a1c-ae9b-81f0f6fc503e")
    public boolean interfaceAcheter(long prix) {
		System.out.println("\nVotre Solde: "+this.joueurs.get(jCourant).getArgent());
		System.out.println("\nVoulez vous acheter cette propriété ? prix: "+prix);
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

    
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		Partie p = new Partie();
		System.out.println("Quelle partie commencer ?");
		System.out.println("1- User Storie 1 inc 1");
		System.out.println("2- User Storie 2 inc 1");
		System.out.println("3- User Storie 1/2 inc 2");
		System.out.println("4- User Storie 3 inc 2");
		System.out.println("5- User Storie 4 inc 2");
		System.out.println("6- User Storie 5 inc 2");
		System.out.println("7- Partie Classique");
	
		p.lancerPartie(p.sc.nextInt());	
	}

	private void lancerPartie(int choix) throws FileNotFoundException, IOException, ParseException {
		switch(choix) {
		
		case 7:
			this.lancerPartie();
			break;
		default:
			this.lancerPartieUS(choix);
			break;
		
	}
		
	}
	
	private void lancerPartieUS(int choix) throws FileNotFoundException, IOException, ParseException {
		plateau = new Plateau();
    	System.err.println("Initialisation de la Partie:\n");
    	initJoueurs(3);
    	
    	System.err.println("\nLa Partie commence:\n");
    	jouerJoueurUS(choix);
	}

	private void jouerJoueurUS(int choix) {
		switch(choix) {
			case 1:
				jCourant = 0;
				System.out.println("\nC'est au joueur "+(jCourant+1)+" ("+this.joueurs.get(jCourant).getName()+") de jouer :");
	    		des.lancerDes(0,0);
	    		plateau.deplacerJoueur(this.joueurs.get(jCourant), des);
	    		actionsPossibles();
	    		jCourant++;
	    		System.out.println("\nC'est au joueur "+(jCourant+1)+" ("+this.joueurs.get(jCourant).getName()+") de jouer :");
	    		des.lancerDes(0,0);
	    		plateau.deplacerJoueur(this.joueurs.get(jCourant), des);
	    		actionsPossibles();
	    		jCourant++;
	    		System.out.println("\nC'est au joueur "+(jCourant+1)+" ("+this.joueurs.get(jCourant).getName()+") de jouer :");
	    		des.lancerDes(0,0);
	    		plateau.deplacerJoueur(this.joueurs.get(jCourant), des);
	    		actionsPossibles();
	    		
	    		System.err.println("User storie 1 inc 1 terminée");
				break;
				
			case 2:
				jCourant = 0;
				System.out.println("\nC'est au joueur "+(jCourant+1)+" ("+this.joueurs.get(jCourant).getName()+") de jouer :");
	    		des.lancerDes(6,0);
	    		afficheSolde(0);
	    		plateau.deplacerJoueur(this.joueurs.get(jCourant), des);
	    		afficheSolde(0);
	    		actionsPossibles();
	    		jCourant++;
	    		System.out.println("\nC'est au joueur "+(jCourant+1)+" ("+this.joueurs.get(jCourant).getName()+") de jouer :");
	    		System.err.println("User storie 2 inc 1 terminée");
	    		break;
	    		
	    		//39-37
			case 3:
				jCourant = 1;
				((Propriete) plateau.plateau.get(37)).getEtat().actionSurCaseP(this.joueurs.get(jCourant));
				System.out.println("\nC'est au joueur "+(jCourant+1)+" ("+this.joueurs.get(jCourant).getName()+") de jouer :");
	    		this.joueurs.get(jCourant).setPosition(37);
	    		
	    		des.lancerDes(2,0);
	    		plateau.deplacerJoueur(this.joueurs.get(jCourant), des);
	    		actionsPossibles();
	    		System.err.println("User storie 1 inc 2 terminée");
	    		
	    		jCourant++;
	    		System.out.println("\nC'est au joueur "+(jCourant+1)+" ("+this.joueurs.get(jCourant).getName()+") de jouer :");
	    		
	    		this.joueurs.get(jCourant).setPosition(37);
	    		des.lancerDes(2,0);
	    		//solde theo avant // solde luc avant
	    		afficheSolde(1,2);
	    		plateau.deplacerJoueur(this.joueurs.get(jCourant), des);
	    		///solde theo après // solde luc après
	    		afficheSolde(1,2);
	    		actionsPossibles();
	    		System.err.println("User storie 2 inc 2 terminée");
	    		break;
	    		
			case 4:
				jCourant = 2;
				((Services) plateau.plateau.get(28)).actionSurCaseP(this.joueurs.get(jCourant));
	    		
	    		jCourant = 0;
				System.out.println("\nC'est au joueur "+(jCourant+1)+" ("+this.joueurs.get(jCourant).getName()+") de jouer :");
	    		des.lancerDes(28,0);
	    		afficheSolde(2,0);
	    		plateau.deplacerJoueur(this.joueurs.get(jCourant), des);
	    		afficheSolde(2,0);
	    		actionsPossibles();
				
	    		System.err.println("User storie 3 inc 2 terminée");
				break;
			
			case 5:
				jCourant = 0;
				((Gare) plateau.plateau.get(5)).actionSurCaseP(this.joueurs.get(jCourant));
				((Gare) plateau.plateau.get(15)).actionSurCaseP(this.joueurs.get(jCourant));
				((Gare) plateau.plateau.get(25)).actionSurCaseP(this.joueurs.get(jCourant));
	    		
	    		jCourant++;
	    		((Propriete) plateau.plateau.get(1)).getEtat().actionSurCaseP(this.joueurs.get(jCourant));
	    		((Propriete) plateau.plateau.get(3)).getEtat().actionSurCaseP(this.joueurs.get(jCourant));
	    		((Propriete) plateau.plateau.get(37)).getEtat().actionSurCaseP(this.joueurs.get(jCourant));
	    		((Propriete) plateau.plateau.get(39)).getEtat().actionSurCaseP(this.joueurs.get(jCourant));
	    		System.out.println("\nC'est au joueur "+(jCourant+1)+" ("+this.joueurs.get(jCourant).getName()+") de jouer :");
	    		des.lancerDes(5,0);
	    		afficheSolde(0,1);
	    		plateau.deplacerJoueur(this.joueurs.get(jCourant), des);
	    		afficheSolde(0,1);
	    		actionsPossibles();
	    		System.err.println("User storie 4 inc 2 terminée");
				break;
				
			case 6:
				jCourant = 1;
				
	    		((Propriete) plateau.plateau.get(37)).getEtat().actionSurCaseP(this.joueurs.get(jCourant));
				((Propriete) plateau.plateau.get(39)).getEtat().actionSurCaseP(this.joueurs.get(jCourant));	
	    		
	    		jCourant++;
	    		System.out.println("\nC'est au joueur "+(jCourant+1)+" ("+this.joueurs.get(jCourant).getName()+") de jouer :");
	    		this.joueurs.get(jCourant).setPosition(37);
	    		des.lancerDes(2,0);
	    		
	    		afficheSolde(1,2);
	    		//solde theo avant // solde luc avant
	    		plateau.deplacerJoueur(this.joueurs.get(jCourant), des);
	    		afficheSolde(1,2);
	    		///solde theo après // solde luc après
	    		actionsPossibles();
	    		System.err.println("User storie 5 inc 2 terminée");
				break;
		}
		
		
	}

	private void afficheSolde(int i, int j) {
		System.out.println("\nSolde des deux joueurs :");
		System.out.println("Solde "+ this.joueurs.get(i).getName() + " = " + this.joueurs.get(i).getArgent());
		System.out.println("Solde "+ this.joueurs.get(j).getName() + " = " + this.joueurs.get(j).getArgent());
	}
	
	private void afficheSolde(int i) {
		System.out.println("\nSolde du joueur :");
		System.out.println("Solde "+ this.joueurs.get(i).getName() + " = " + this.joueurs.get(i).getArgent());
	}

	private void initJoueurs(int i) {
    	int argentDepart = 1000000;
    	Joueur x = new Joueur("Paul",this);
    	joueurs.add(x);
    	joueurs.get(0).initPositionJoueur(0);
    	joueurs.get(0).initArgent(argentDepart);
    	
    	Joueur y = new Joueur("Luc",this);
    	joueurs.add(y);
    	joueurs.get(1).initPositionJoueur(0);
    	joueurs.get(1).initArgent(argentDepart);
    	
    	Joueur z = new Joueur("Théo",this);
    	joueurs.add(z);
    	joueurs.get(2).initPositionJoueur(0);
    	joueurs.get(2).initArgent(argentDepart);
		
	}
    
    

}
