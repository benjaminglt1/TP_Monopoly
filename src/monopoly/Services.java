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
		int cptServ=0;
    	for(int i=0;i<this.services.size();i++){
			if(this.services.get(i).getProprietaire().equals(this.getProprietaire())) {
				cptServ++;
			}
		}
    	des.lancerDes();
    	if(cptServ == 2) {
    		return 10*(des.getDe1()+des.getDe2());
    	}else {
    		return 4*(des.getDe1()+des.getDe2());
    	}
    	
    }
    
    public void vendre() {
		this.proprietaire.crediter((int) this.prixAchat);
		this.proprietaire.vendre(this);
		this.proprietaire = null;
	}
}
