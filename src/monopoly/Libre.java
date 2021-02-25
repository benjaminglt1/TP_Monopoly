package monopoly;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("ea327d47-93c6-4376-8795-b68cb46f9273")
public class Libre extends Etat {
    @objid ("274ff6cb-3425-4c6f-b7a3-4f9995260aac")
    public void actionSurCase(Joueur j) {
    	System.out.println("\nPropriete libre");
    	if(j.getPartie().interfaceAcheter(this.propriete.getPrixAchat())) {
    		j.debiter((int) this.propriete.getPrixAchat());
    		modifierProprietaire(j);
    		j.ajouterPropriete(this.propriete);
    		this.propriete.setEtat(new Vendu());
    	}
    	
    }
    
    public void actionSurCaseP(Joueur j) {
    	j.debiter((int) this.propriete.getPrixAchat());
		modifierProprietaire(j);
		j.ajouterPropriete(this.propriete);
		this.propriete.setEtat(new Vendu());
    }

    @objid ("2ae3ae28-798e-4e17-b17d-c20b426f5760")
    public boolean acheter() {
		return false;
    }

    @objid ("44a2e167-0c5d-453f-a8ac-515b269c669d")
    public void modifierProprietaire(Joueur j) {
    	this.propriete.modifierProprietaire(j);
    }

    @objid ("189dbecc-74d0-4d75-9dcb-8c4ebdf83072")
    public boolean estProprietaire() {
		return false;
    }
    
    public boolean estLibre() {
    	return true;
    }

}
