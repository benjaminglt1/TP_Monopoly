package monopoly;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("cc72e367-fead-43c1-86b4-6c175317af1e")
public class Vendu extends Etat {

	@objid ("32020ccd-d54d-4995-881e-31ae22723894")
    public void actionSurCase(Joueur joueur) {
    }

    @objid ("49ecab1a-5280-4a8e-9f51-488faa4981a9")
    public void setEtat() {
    	
    }
    
    public boolean estConstructible() {
    	
    	if(!((this.propriete.getQuartier()).verifConstructible())) {
    		this.propriete.setEtat(new NonConstructible());
    		return false;
    	}else {
    		
    		return true;
    	}
    }

    public void devientConstructible() {
    	this.propriete.setEtat(new Constructible());
    }
}
