package monopoly;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("eedbb245-3fcf-4834-8343-d6daee850c64")
public class Construit extends Etat {
    @objid ("0ba70016-fabb-46d9-80d1-877147845549")
    public void actionSurCase(Joueur joueur) {
    }

    @objid ("49f3dfa3-b151-4fe4-b5de-0cb33f3713dc")
    public boolean construire() {
    	if(this.propriete.getProprietaire().verifierArgent(this.propriete.getPrixMaison())) {
    		this.propriete.getProprietaire().debiter(this.propriete.getPrixMaison());
    		this.propriete.addMaison();
    		if(this.propriete.getNbMaisons() == 5) {
    			this.propriete.setEtat(new ConstructionTerminee());
    		}
    		return true;
    	}
		return false;
    }

    @objid ("fb3f7722-7e34-43cb-a06c-e43e36a3d1c9")
    public void payerLoyer(Joueur j) {
    	long aPayer = calculerLoyer();
    	j.debiter((int) aPayer);
    	this.propriete.getProprietaire().crediter((int) aPayer);
    }

    @objid ("e475c35f-6f0b-41b2-9512-3ffe0a47ae1f")
    public long calculerLoyer() {
    	return this.propriete.getLoyers(this.propriete.getNbMaisons());
    }

    @objid ("7ba064f0-1453-4654-80dd-e8ec02ea1345")
    public void setEtat() {
    }
    
    public void vendre() {
		this.propriete.getProprietaire().crediter((int) this.propriete.getPrixAchat()+(this.propriete.getPrixMaison()*this.propriete.getNbMaisons()));
		this.propriete.getProprietaire().vendre(this.propriete);
		this.propriete.proprietaire = null;
		this.propriete.setEtat(new Libre());
	}

}
