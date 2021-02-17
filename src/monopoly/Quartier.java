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
		return false;
    }

    @objid ("f33f85df-6fa4-45c0-93bb-8bcee247bd92")
    String getCouleur() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.couleur;
    }

    @objid ("35fa561a-7407-40f5-979e-218db433c88f")
    void setCouleur(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.couleur = value;
    }
    
    void addPropriete(Propriete p) {
    	this.propriete.add(p);
    }

}
