package monopoly;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("cbffd5eb-11f0-4024-af79-77ae2df28c4e")
public class Depart extends Action {
    @objid ("a83f4662-9e64-4bd7-987b-d799df234d3b")
    private int argentAjoute;
    
    public Depart() {
    	this.nom = "Départ";
    }

    @objid ("9b176622-a745-4cec-9c41-3f1888261674")
    int getArgentAjoute() {
        
        return this.argentAjoute;
    }

    @objid ("8f0152e8-0efd-46f1-bbe3-502a75db11d3")
    void setArgentAjoute(int value) {
        
        this.argentAjoute = value;
    }
    
    public void actionSurCase(Joueur j) {
    	System.out.println("On passe par la case départ");
    	j.crediter(argentAjoute);
    }

}
