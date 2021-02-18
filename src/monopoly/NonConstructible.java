package monopoly;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("a6754d06-392d-4851-9efb-32f8b70f2fa1")
public class NonConstructible extends Etat {
    @objid ("eaaa05f7-c23f-4bf6-9552-a77da8d43094")
    public void actionSurCase(Joueur joueur) {
    }

    @objid ("3bf1644d-eb35-484b-bb58-bc60fb939b93")
    public void devientConstructible() {
    	this.propriete.setEtat(new Constructible());
    }

    @objid ("f051e7a7-4baa-455c-b529-e6c2770a4f03")
    public void payerLoyer(Joueur j) {
    	long aPayer = calculerLoyer();
    	j.debiter((int) aPayer);
    	this.propriete.getProprietaire().crediter((int) aPayer);
    }

    @objid ("99fda1aa-efb9-4639-bb88-1de2212d6a24")
    public long calculerLoyer() {
		return this.propriete.getLoyers(0);
    }

    @objid ("9fd8306d-2d55-48cc-be04-f4e5a6569e95")
    public void setEtat() {
    }

}
