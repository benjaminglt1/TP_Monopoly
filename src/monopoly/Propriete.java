package monopoly;
import java.awt.Color;
import java.util.ArrayList;

import org.json.simple.JSONArray;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("e7f62ec2-42ce-4889-9435-fcfdd3937788")
public class Propriete extends Achetables {
    @objid ("0f8e9aaa-6fdb-4b05-922a-104a1258d266")
    private int nbMaisons;
    
    private ArrayList<Long> loyers = new ArrayList<Long>();

    @objid ("7fb205b2-2dea-4512-b7dc-dd03307b675b")
    private Quartier quartier;

    @objid ("47a6664f-d7b5-4871-8630-bbc0b9d9c080")
    private Etat etat;

	private String color;
	
	public int xNom;

	public long prixMaison;


    public Propriete(String nom, long prixAchat, long prixAchatMaison, JSONArray l, String quartier) {
		this.nom = nom;
		this.prixAchat = prixAchat;
		this.prixMaison = prixAchatMaison;
		this.nbMaisons = 0;
		this.etat = new Libre();
		this.etat.setPropriete(this);
		this.color = quartier;
		for(int i =0;i<l.size();i++) {
			loyers.add((Long) l.get(i));
		}
		
	}

	@objid ("d22f6a51-1d56-47e5-9fc0-d60378bc4bad")
    public boolean construire() {
		return etat.construire();
    }

    @objid ("a3aa700e-0581-43cb-9130-7bc7e8538dfa")
    public void devientConstructible() {
    	etat.devientConstructible();
    }

    public void vendre() {
		etat.vendre();
	}
    @objid ("235082f1-c37c-4131-8f39-91d090d06a5e")
    public boolean estConstructible() {
    	return false;
	}

    @objid ("bb16bcc1-f778-42b2-b0be-eb4003fd5e72")
    public void setEtat(Etat etat) {
    	this.etat = etat;
    	this.etat.setPropriete(this);
    	System.out.println("CHANGEMENT D'ETAT -> "+this.etat.getClass().getName());
    	if(this.etat instanceof Vendu) {
    		this.etat.estConstructible();
    	}
    }

    @objid ("e1fbe937-96e5-4f5c-8d66-541ffdf508aa")
    int getNbMaisons() {
        
        return this.nbMaisons;
    }
    
    String getColor() {
        
        return this.color;
    }

    @objid ("0455c72d-a10c-4487-9828-9c7f403a9c59")
    void setNbMaisons(int value) {
        
        this.nbMaisons = value;
    }

    @objid ("5e92ccf7-3ee2-4798-91f7-e7104dfaa697")
    public void modifierProprietaire(Joueur j) {
    	this.proprietaire = j;
    }

	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
		
	}
	
	public void actionSurCase(Joueur j) {
		
		if(!this.etat.estProprietaire(j) && this.getProprietaire()!=null) {
			System.out.println("Cette propriete ne vous appartient pas vous devez donc payer le loyer");
			etat.payerLoyer(j);
		}else {
			etat.actionSurCase(j);
		}
		
	}
	
	Etat getEtat() {
		return this.etat;
	}

	public long getLoyers(int index) {
		return this.loyers.get(index);
	}

	public Quartier getQuartier() {
		return this.quartier;
	}

	public int getPrixMaison() {
		return (int) this.prixMaison;
	}

	public void addMaison() {
		this.nbMaisons+=1;		
	}


}
