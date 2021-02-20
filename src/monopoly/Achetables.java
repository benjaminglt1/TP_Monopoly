package monopoly;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("2c49c135-791c-48de-b86a-4427de4e94e4")
public abstract class Achetables extends Case {
    @objid ("554628ea-dc32-42e5-9a0e-fe785f87b9d1")
    protected long prixAchat;

    @objid ("3e0a18b8-7367-4ce8-b7a9-8876b6d40334")
    protected Joueur proprietaire = null;

    @objid ("0e378a7f-fe5c-41d3-9865-633efdcf6c50")
    public void acheter() {
    }

    @objid ("31d8286f-170f-41ca-8101-7f554cd188ac")
    public boolean estProprietaire(Joueur j) {
    	if(this.proprietaire != null) {
	    	if(this.proprietaire.equals(j)) {
	    		return true;
	    	}
    	}
		return false;
    }
    
    public Joueur getProprietaire() {
    	return this.proprietaire;
    }

    @objid ("57a4ba64-9582-4b9b-91a4-589c18569eaa")
    public int calculerLoyer() {
		return 0;
    }

    @objid ("a5fcdee2-e5b9-4920-9d48-b03622911518")
    public void payerLoyer(Joueur locataire) {
    }

    @objid ("0806a365-2b9b-40ad-ab9a-8ce7cb71f10d")
    public boolean estLibre() {
		if(this.proprietaire != null) {
			return false;
			
		}
		return true;
    }

    @objid ("88a2a229-a3b8-40d8-bf02-5f61a849a549")
    long getPrixAchat() {
        
        return this.prixAchat;
    }

    @objid ("ca22947e-6536-4621-b4d1-1706a3cce444")
    void setPrixAchat(int value) {
        
        this.prixAchat = value;
    }

	public void vendre() {		
	}

}
