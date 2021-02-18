package monopoly;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("d532c03f-66b7-4c8d-adeb-e7b0eee91e6c")
public class Constructible extends Etat {
    @objid ("fa0056a0-3df5-4147-8064-65a27fdf1641")
    public void actionSurCase(Joueur joueur) {
    }

    @objid ("e71015e9-1620-4a2c-a8d8-6bb738d17d08")
    public boolean construire() {
    	if(this.propriete.getProprietaire().verifierArgent(this.propriete.getPrixMaison())) {
    		this.propriete.getProprietaire().debiter(this.propriete.getPrixMaison());
    		this.propriete.addMaison();
    		if(this.propriete.getNbMaisons() == 5) {
    			this.propriete.setEtat(new Construit());
    		}
    		return true;
    	}
		return false;
    }

    @objid ("e6989142-e342-4e97-aae6-c023def5cce7")
    public void payerLoyer(Joueur j) {
    	long aPayer = calculerLoyer();
    	j.debiter((int) aPayer);
    	this.propriete.getProprietaire().crediter((int) aPayer);
    	
    }

    @objid ("eedb7f3b-fdcf-4dbb-b023-b7f1ed8961c0")
    public long calculerLoyer() {
    	return this.propriete.getLoyers(0)*2;
    }

    @objid ("24bcbd54-c4e4-4b80-a21c-b6851c33453b")
    public void setEtat() {
    }

}
