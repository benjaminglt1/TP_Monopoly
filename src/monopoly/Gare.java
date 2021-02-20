package monopoly;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("40bf6ef9-1a85-41a0-93a9-c8f504d9e5ef")
public class Gare extends Achetables {
    private ArrayList<Long> loyers = new ArrayList<Long>();
    
    @objid ("cf3fad4a-2fde-4f45-b407-4e1ccd9f0705")
    private ArrayList<Gare> gare = new ArrayList<Gare>();

    public Gare(String nom, long prixAchat, JSONArray l) {
    	this.nom = nom;
    	this.prixAchat = prixAchat;
    	for(int i =0;i<loyers.size();i++) {
			loyers.add((Long) l.get(i));
		}
	}

    public void updateGare(ArrayList<Gare> g) {
    	this.gare = g;
    }
    
    public void actionSurCase(Joueur j) {
    	if(!estLibre()) {
    		if(!estProprietaire(j)) {
    			System.out.println("Payer le loyer");
    			payerLoyer(j);
    		}
    	}else {
    		System.out.println("propriete libre");
        	if(j.getPartie().interfaceAcheter(this.getPrixAchat())) {
        		j.debiter((int) this.getPrixAchat());
        		modifierProprietaire(j);
        		j.ajouterPropriete(this);
        	}
    	}	
    }
    
    private void modifierProprietaire(Joueur j) {
		this.proprietaire = j;
		
	}

	public void payerLoyer(Joueur j) {
    	long aPayer = calculerLoyer(j);
    	j.debiter((int) aPayer);
    	this.getProprietaire().crediter((int) aPayer); 
    }
    
    public long calculerLoyer(Joueur j) {
		int cptGare=0;
    	for(int i=0;i<this.gare.size();i++){
			if(gare.get(i).getProprietaire().equals(this.getProprietaire())) {
				cptGare++;
			}
		}
    	
    	return this.loyers.get(cptGare);
    	
    }
    
    public void vendre() {
		this.proprietaire.crediter((int) this.prixAchat);
		this.proprietaire.vendre(this);
		this.proprietaire = null;
	}
	

}
