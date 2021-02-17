package monopoly;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("3949a541-1cbd-497e-ba61-d5a0eda5a22d")
public class Etat {
    @objid ("31e5f494-61b0-476f-a324-ce203861c883")
	protected Propriete propriete;

    @objid ("f94aa6ed-311e-45bc-a64b-ff0cddf49cf6")
    public boolean construire() {
		return false;
    }

    @objid ("904b9168-4904-43e7-ba63-c0f3ba3bbf0d")
    public boolean acheter() {
		return false;
    }

    @objid ("2ec97f9a-f692-4fdc-83bc-7e60d8ddf5c5")
    public boolean estConstructible() {
		return false;
    }

    @objid ("45d02a21-50d0-43fe-9222-d63d363ae2e7")
    public void devientConstructible() {
    }

    @objid ("fdcd7e49-bfae-4a40-bc0b-7dfbe4ed9649")
    public void payerLoyer(Joueur j) {
    }

    @objid ("29d58843-2221-4e1a-9bb8-311f69a894bc")
    public long calculerLoyer() {
		return 0;
    }

    @objid ("84f54ad6-015e-493c-8164-eb7ca8fc9624")
    public void actionSurCase(Joueur joueur) {
    }

    @objid ("eb648890-4aea-4084-ad4c-54bbd57fe141")
    public void setEtat() {
    }

    @objid ("ec7b5c78-de3c-449b-af07-4d0668f735e5")
    public boolean estProprietaire(Joueur j) {
    	if((this.propriete.getProprietaire()).equals(j)) {
    		return true;
    	}
		return false;
    }

    @objid ("c2ad3bcd-09fb-48d7-8866-d2c0c37d0ef4")
    public void modifierProprietaire() {
    }

	public void setPropriete(Propriete propriete) {
		this.propriete = propriete;
		
	}

}
