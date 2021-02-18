package monopoly;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("62390344-f917-4632-99b2-f2000b666d1f")
public class Plateau {
	ArrayList<Case> plateau = new ArrayList<Case>();
	//ArrayList<Quartier> quartiers = new ArrayList<Quartier>();
	
	public Plateau() throws FileNotFoundException, IOException, ParseException{
		ArrayList<Gare> listGare = new ArrayList<Gare>();
		ArrayList<Services> listServ = new ArrayList<Services>();
		ArrayList<Quartier> listQuartier = new ArrayList<Quartier>();
		
		Quartier q0 = new Quartier("#812B5C");listQuartier.add(q0);
		Quartier q1 = new Quartier("#119AEB");listQuartier.add(q1);
		Quartier q2 = new Quartier("#73316F");listQuartier.add(q2);
		Quartier q3 = new Quartier("#D16E2D");listQuartier.add(q3);
		Quartier q4 = new Quartier("#D32C19");listQuartier.add(q4);
		Quartier q5 = new Quartier("#E6E018");listQuartier.add(q5);
		Quartier q6 = new Quartier("#11862E");listQuartier.add(q6);
		Quartier q7 = new Quartier("#132450");listQuartier.add(q7);
		
		
		String fichier = "./ressource/monopoly.json";
		JSONParser jsonP = new JSONParser();	
		JSONArray proprietes = (JSONArray) ((JSONObject) jsonP.parse(new FileReader(fichier))).get("proprietes");
		
		for(int i = 0;i<proprietes.size();i++) {
			JSONObject p = (JSONObject) proprietes.get(i);
			
			String nom;
			long prixAchat;
			JSONArray loyers;
			long prixAchatMaison; 
			String quartier;
			String type = (String) p.get("case");
			switch(type) {
				case "depart":
					System.out.println("depart");
					Depart depart = new Depart();
					plateau.add(depart);
					break;
				case "impot":
					System.out.println("impot");
					Impots impot = new Impots(0);
					plateau.add(impot);
					break;
				case "gare":
					System.out.println("gare");
					nom = (String) p.get("nom");
					prixAchat = (long) p.get("prixAchat");
					loyers = (JSONArray) p.get("loyers");
					Gare gare = new Gare(nom,prixAchat,loyers);
					plateau.add(gare);
					listGare.add(gare);
					break;
				case "service":
					System.out.println("service");
					nom = (String) p.get("nom");
					prixAchat = (long) p.get("prixAchat");
					Services service = new Services(nom,prixAchat);
					plateau.add(service);
					listServ.add(service);
					break;
				case "propriete":
					System.out.println("propriete");
					nom = (String) p.get("nom");
					prixAchat = (long) p.get("prixAchat");
					prixAchatMaison = (long) p.get("prixAchatMaison");
					loyers = (JSONArray) p.get("loyers");
					quartier = (String) p.get("quartier");
					Propriete pr = new Propriete(nom,prixAchat,prixAchatMaison,loyers,quartier);
					plateau.add(pr);
					switch(quartier) {
						case "#812B5C":
							listQuartier.get(0).addPropriete(pr);
							break;
						case "#119AEB":
							listQuartier.get(1).addPropriete(pr);
							break;
						case "#73316F":
							listQuartier.get(2).addPropriete(pr);
							break;
						case "#D16E2D":
							listQuartier.get(3).addPropriete(pr);
							break;
						case "#D32C19":
							listQuartier.get(4).addPropriete(pr);
							break;
						case "#E6E018":
							listQuartier.get(5).addPropriete(pr);
							break;
						case "#11862E":
							listQuartier.get(6).addPropriete(pr);
							break;
						case "#132450":
							listQuartier.get(7).addPropriete(pr);
							break;
						default:
							System.err.println("Erreur : Propriete qui n'est pas dans un quartier");	
							break;
						
					}
					
					break;
				default:
					System.err.println("Erreur : Case non prise en compte");	
					break;
			}
			
			
			//System.out.println(p.toString());
			
		}
		
		for(int i = 0;i<plateau.size();i++) {
			if(plateau.get(i) instanceof Gare) {
				((Gare) plateau.get(i)).updateGare(listGare);
			}else if(plateau.get(i) instanceof Services) {
				((Services) plateau.get(i)).updateService(listServ);;
			}else if(plateau.get(i) instanceof Propriete){
				switch(((Propriete) plateau.get(i)).getColor()) {
				case "#812B5C":
					((Propriete) plateau.get(i)).setQuartier(listQuartier.get(0));
					break;
				case "#119AEB":
					((Propriete) plateau.get(i)).setQuartier(listQuartier.get(1));
					break;
				case "#73316F":
					((Propriete) plateau.get(i)).setQuartier(listQuartier.get(2));
					break;
				case "#D16E2D":
					((Propriete) plateau.get(i)).setQuartier(listQuartier.get(3));
					break;
				case "#D32C19":
					((Propriete) plateau.get(i)).setQuartier(listQuartier.get(4));
					break;
				case "#E6E018":
					((Propriete) plateau.get(i)).setQuartier(listQuartier.get(5));
					break;
				case "#11862E":
					((Propriete) plateau.get(i)).setQuartier(listQuartier.get(6));
					break;
				case "#132450":
					((Propriete) plateau.get(i)).setQuartier(listQuartier.get(7));
					break;
				default:
					System.err.println("Erreur");	
					break;		
				}
			}
		}
	}
	
    @objid ("9c7b9ea4-a70d-4f2d-865d-735ebc1f9a87")
    public void deplacerJoueur(Joueur joueur, Des de) {
    	int oldPos = joueur.getPosition();
    	System.out.println("oldPos:"+oldPos);
    	joueur.setPosition((de.getDe1()+de.getDe2())%39);
    	System.out.println("on avance de "+(de.getDe1()+de.getDe2()));
    	System.out.println("newPos:"+joueur.getPosition());
    	if(oldPos>joueur.getPosition()) {
    		plateau.get(0).actionSurCase(joueur);
    	}
    	System.out.println("Case : "+(plateau.get(joueur.getPosition())).getNom());
    	plateau.get(joueur.getPosition()).actionSurCase(joueur);
    }

}
