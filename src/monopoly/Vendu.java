package monopoly;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("cc72e367-fead-43c1-86b4-6c175317af1e")
public class Vendu extends Etat {
    
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
