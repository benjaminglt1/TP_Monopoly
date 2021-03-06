package monopoly;
import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("785141eb-87eb-443e-822e-10bfa7230c25")
public class Quartier {
    @objid ("18b84395-5fbf-46c4-b259-6a52ed5f47e4")
    private String couleur;

    @objid ("a1c4326d-1b34-493d-96df-3402220327ab")
    private ArrayList<Propriete> propriete = new ArrayList<Propriete>();

    public Quartier(String couleur) {
		this.couleur = couleur;
	}

	@objid ("fc0ff36b-24a8-4128-bbd7-20e29d13c343")
    public void rendreConstructible() {
    }

    @objid ("cb9413ff-6929-4400-a2d0-6fabe5eab040")
    public boolean verifConstructible() {
		Joueur prop = propriete.get(0).getProprietaire();
    	for(int i=1;i<propriete.size();i++) {
    		if(propriete.get(i).getProprietaire() != null) {
				if(propriete.get(i).getProprietaire().equals(prop)) {
					
				}else {
					return false;
				}
    		}else { 
    			return false;
    		}
		}
    	
    	for(int i=0;i<propriete.size();i++) {
    		this.propriete.get(i).devientConstructible();
    	}
    	
    	return true;
    }

    @objid ("f33f85df-6fa4-45c0-93bb-8bcee247bd92")
    String getCouleur() {
        
        return this.couleur;
    }

    @objid ("35fa561a-7407-40f5-979e-218db433c88f")
    void setCouleur(String value) {
        
        this.couleur = value;
    }
    
    void addPropriete(Propriete p) {
    	this.propriete.add(p);
    }

	ArrayList<Propriete> getPropriete() {
		return this.propriete;
	}

}
