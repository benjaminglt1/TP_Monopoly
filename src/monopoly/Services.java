package monopoly;
import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("955c7966-fdac-4c2e-a392-b36400efe868")
public class Services extends Achetables {
    public Services(String nom, long prixAchat) {
		this.nom = nom;
		this.prixAchat = prixAchat;
	}

	@objid ("602b997c-996e-46cc-ac2c-6fec1512a5d8")
    private ArrayList<Services> services = new ArrayList<Services> ();
	
	public void updateService(ArrayList<Services> s) {
		this.services = s;
	}

    @objid ("00fd2f67-549e-4f21-89be-05798f30b96f")
    private Des des;

}
