package entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Logement {
    private int reference;
    private String adresse;
    private String delegation;
    private String gouvernorat;
    private String type;
    private String description;
    private float prix;

    public Logement() {
    }

    public Logement(int reference, String adresse, String delegation, String gouvernorat, String type, String description, float prix) {
        this.reference = reference;
        this.adresse = adresse;
        this.delegation = delegation;
        this.gouvernorat = gouvernorat;
        this.type = type;
        this.description = description;
        this.prix = prix;
    }

    @XmlElement
    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    @XmlElement
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @XmlElement
    public String getDelegation() {
        return delegation;
    }

    public void setDelegation(String delegation) {
        this.delegation = delegation;
    }

    @XmlElement
    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    @XmlElement
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement
    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}