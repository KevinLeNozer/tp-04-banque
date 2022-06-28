package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "seqOperation", strategy = "increment")
    private int id;
    @Column(name = "DATE")
    private LocalDate date;
    @Column(name = "MONTANT")
    private double montant;
    @Column(name = "MOTIF", length = 255, nullable = false, unique = false)
    private String motif;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "numeroCompte")
    private Compte compte;

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Operation() {
    }

    public Operation(LocalDate date, double montant, String motif) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Operation{");
        sb.append("id=").append(id);
        sb.append(", date=").append(date);
        sb.append(", montant=").append(montant);
        sb.append(", motif='").append(motif).append('\'');
        sb.append(", compte=").append(compte);
        sb.append('}');
        return sb.toString();
    }
}
