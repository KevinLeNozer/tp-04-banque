package fr.diginamic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "Operation")
public class Operation {
    @Id
    private int id;
    @Column(name = "DATE")
    private LocalDate date;
    @Column(name = "MONTANT")
    private double montant;
    @Column(name = "MOTIF", length = 255, nullable = false, unique = false)
    private String motif;

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
        sb.append('}');
        return sb.toString();
    }
}
