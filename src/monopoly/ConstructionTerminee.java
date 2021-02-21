package monopoly;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("429e4e80-65b3-4bad-831e-2b44e950dcb8")
public class ConstructionTerminee extends Etat {
    @objid ("6445b8f9-516d-46a5-8908-2b5dc011c31a")
    public void actionSurCase(Joueur joueur) {
    }

    @objid ("6c2a688d-d223-4248-8e63-b93c3ea04fb2")
    public void payerLoyer(Joueur j) {
    	long aPayer = calculerLoyer();
    	j.debiter((int) aPayer);
    	this.propriete.getProprietaire().crediter((int) aPayer);
    }

    public long calculerLoyer() {
    	return this.propriete.getLoyers(5);
    }
    

    @objid ("7e191488-a1c4-44fb-a310-a374a34a4d94")
    public void setEtat() {
    }
    
    public void vendre() {
      this.propriete.getProprietaire().crediter((int) this.propriete.getPrixAchat()+(this.propriete.getPrixMaison()*this.propriete.getNbMaisons()));
      this.propriete.getProprietaire().vendre(this.propriete);
      this.propriete.proprietaire = null;
      this.propriete.setEtat(new Libre());
	  }

}
