package monopoly;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("8c51a0e5-13d1-4392-93d7-7c8c96a767a8")
public class Joueur {
	private Partie partie;
    @objid ("7ae12daf-64c6-4380-b302-cdd1dafec2cd")
	private int position;

    @objid ("5d4bdb3a-b279-48b1-9e79-c9a443789b72")
	private int argent;

    @objid ("4af61eab-b76c-43c0-8495-a1625882ca7d")
    private List<Achetables> propriete = new ArrayList<Achetables> ();

	public Image pionImg;//

	public String pion;//

	private String name;//
	
	public Joueur(String nom, Partie partie) {
		this.name = nom;
		this.partie = partie;
	}

    @objid ("a95e532e-c8c3-4211-a5ab-5107a18be4d4")
    public void initPositionJoueur(int positionDepart) {
    	this.position = positionDepart;
    }

    @objid ("680d5cc7-1782-4a88-8aec-34f0cad55e66")
    public void initArgent(int argentDepart) {
    	this.argent = argentDepart;
    }

    @objid ("4a8932f0-7df3-4902-95c1-541307a8f7c6")
    public void debiter(int montant) {
    	this.argent -= montant;
    }

    @objid ("049212bf-1921-4772-b633-66e3b8ca7b24")
    public void construireMaison(Propriete p) {
    	p.construire();
    }

    @objid ("51cec632-3125-47cb-8d3f-a25247f3ed7e")
    public void crediter(int montant) {
    	this.argent += montant;
    }
    

    @objid ("a64d49ef-9838-4fff-851f-0d2c8dce8387")
	public
    int getPosition() {
        
        return this.position;
    }

    @objid ("90c250b5-673a-499a-b29a-4021ee8ff81a")
    void setPosition(int value) {
        
        this.position += value;
    }

    @objid ("adac272e-ba56-4af8-8621-5f14018b1fab")
    int getArgent() {
        
        return this.argent;
    }

    @objid ("47c89d4e-15ae-4ee7-9142-1a3f3a47dba3")
    void setArgent(int value) {
        
        this.argent = value;
    }

    @objid ("b8179ed5-63e3-4844-a217-40aa97a86b09")
    public boolean verifierArgent(int i) {
    	return this.argent>i;
    }

    @objid ("55335325-66a2-48ab-8921-91c7d15cc459")
    public void ajouterPropriete(Propriete propriete) {
    	this.propriete.add(propriete);
    }
    
    public void ajouterPropriete(Gare gare) {
    	this.propriete.add(gare);
    }
    
    public void ajouterPropriete(Services serv) {
    	this.propriete.add(serv);
    }

	public List<Achetables> getPropriete() {
		return propriete;
	}

	public void setPropriete(List<Achetables> propriete) {
		this.propriete = propriete;
	}

	String getName() {
		return this.name;
	}

	Partie getPartie() {
		return this.partie;
		
	}

	public ArrayList<Propriete> getProprieteConstructibles() {
		ArrayList<Propriete> res = new ArrayList<Propriete>();
		for(int i=0;i<this.propriete.size();i++) {
			if(this.propriete.get(i) instanceof Propriete) {
				if((((Propriete) this.propriete.get(i)).getEtat() instanceof Constructible) || (((Propriete) this.propriete.get(i)).getEtat() instanceof Construit)) {
					res.add((Propriete) this.propriete.get(i));
				}
			}
		}
		return res;
	}

	public void vendre(Case p) {
		for(int i =0;i<this.propriete.size();i++) {
			if(this.propriete.get(i).nom == p.nom) {
				this.propriete.remove(i);
			}
		}
	}

	public void clearPropriete() {
		for(int i=0;i<this.propriete.size();i++) {
			this.propriete.get(i).vendre();
		}
		
	}

}
