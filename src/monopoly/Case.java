package monopoly;
import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("900f4a9d-cd4e-4093-8209-72f5a6144c36")
public abstract class Case {
    
    protected String nom;
    @objid ("60a80f7e-2a25-4f31-b789-8ab5d2293c8a")
    public void actionSurCase(Joueur joueur) {
    }
    
    String getNom() {
    	return this.nom;
    }

}
