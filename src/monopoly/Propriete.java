package monopoly;
import java.awt.Color;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("e7f62ec2-42ce-4889-9435-fcfdd3937788")
public class Propriete extends Achetables {
    @objid ("0f8e9aaa-6fdb-4b05-922a-104a1258d266")
    private int nbMaisons;

    @objid ("4ed4a8b9-a0d1-438a-aef5-1beddd55777d")
    private int loyer1M;

    @objid ("1923a380-a548-44d3-bc45-f77a4b559cb5")
    private int loyer2M;

    @objid ("7ac19fb6-9643-48a8-ad8d-fa964ba17d8a")
    private int loyer3M;

    @objid ("2582ccf9-2873-4a35-9c9f-441a4f34349a")
    private int loyer4M;

    @objid ("931474e7-0c31-4b04-a5dc-5c994e77dda7")
    private int loyer5M;

    @objid ("7fb205b2-2dea-4512-b7dc-dd03307b675b")
    private Quartier quartier;

    @objid ("47a6664f-d7b5-4871-8630-bbc0b9d9c080")
    private Etat etat;

	public Color color;

	public int xNom;

	public String nom;

	public int terrainNu;

	public int uneMaison;

	public int deuxMaisons;

	public int troisMaisons;

	public int quatreMaisons;

	public int hotel;

	public int prixMaison;

    @objid ("d22f6a51-1d56-47e5-9fc0-d60378bc4bad")
    public boolean construire() {
		return false;
    }

    @objid ("a3aa700e-0581-43cb-9130-7bc7e8538dfa")
    public void devientConstructible() {
    }

    @objid ("235082f1-c37c-4131-8f39-91d090d06a5e")
    public boolean estConstructible() {
		return false;
    }

    @objid ("bb16bcc1-f778-42b2-b0be-eb4003fd5e72")
    public void setEtat(Etat etat) {
    }

    @objid ("13b333e5-c2fd-422f-bc41-79f7994435c6")
    void setLoyer(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.loyer = value;
    }

    @objid ("e1fbe937-96e5-4f5c-8d66-541ffdf508aa")
    int getNbMaisons() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nbMaisons;
    }

    @objid ("0455c72d-a10c-4487-9828-9c7f403a9c59")
    void setNbMaisons(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.nbMaisons = value;
    }

    @objid ("5e92ccf7-3ee2-4798-91f7-e7104dfaa697")
    public void modifierProprietaire() {
    }

    @objid ("7a6d4760-b338-43fe-95ef-727af9426f47")
    int getLoyer5M() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.loyer5M;
    }

    @objid ("0dfd8d14-2d6f-41cf-9dea-95a4925f766b")
    void setLoyer5M(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.loyer5M = value;
    }

    @objid ("20a39902-5cac-42bf-b730-eb09afb88660")
    int getLoyer4M() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.loyer4M;
    }

    @objid ("69df5826-557c-4173-b048-38e1c4285a38")
    void setLoyer4M(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.loyer4M = value;
    }

    @objid ("c7fd9f31-9184-4d7a-b50e-2d21c1a4f556")
    int getLoyer3M() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.loyer3M;
    }

    @objid ("39413704-e9fd-4777-951c-30e2fc9212fa")
    void setLoyer3M(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.loyer3M = value;
    }

    @objid ("d299ce72-5c24-4716-a076-b7c93f3b7b54")
    int getLoyer2M() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.loyer2M;
    }

    @objid ("111e47ed-09ce-4372-8026-5481a5ce061b")
    void setLoyer2M(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.loyer2M = value;
    }

    @objid ("61f4c802-5b76-4cd2-bacf-06fcd9f372d9")
    int getLoyer1M() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.loyer1M;
    }

    @objid ("d3b37428-19a9-4c1f-b28c-f57f4076c561")
    void setLoyer1M(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.loyer1M = value;
    }

}
