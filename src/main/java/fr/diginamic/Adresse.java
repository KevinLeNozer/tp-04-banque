package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Embeddable
public class Adresse {
    @Column(name = "NUMERO")
    private int numero;
    @Column(name = "RUE", length = 60, nullable = false, unique = false)
    private String rue;
    @Column(name = "CODEPOSTAL")
    private int codePostal;
    @Column(name = "VILLE", length = 60, nullable = false, unique = false)
    private String ville;

    public Adresse() {
    }

    public Adresse(int numero, String rue, int codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Adresse{");
        sb.append(", numero=").append(numero);
        sb.append(", rue='").append(rue).append('\'');
        sb.append(", codePostal=").append(codePostal);
        sb.append(", ville='").append(ville).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
