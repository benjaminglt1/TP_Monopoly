package monopoly;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("e96b8118-a4db-4bb0-b372-daa6c946d058")
public class Impots extends Case {
    @objid ("4e32a37f-0b26-4bfc-aede-f40fdd5daa0b")
    private int argentRetire;

    public Impots(int i) {
    	this.argentRetire = i;
    	this.nom = "Impot";
	}

	@objid ("7fb6a13a-d192-42ae-9357-e6b2126219fa")
    int getArgentRetire() {
        
        return this.argentRetire;
    }

    @objid ("72736750-a3a7-4965-a6b6-15a62aeb28d7")
    void setArgentRetire(int value) {
        
        this.argentRetire = value;
    }
    
    public void actionSurCase(Joueur j) {
    	j.debiter(argentRetire);
    }

}
