package fr.diginamic;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class AssuranceVie extends Compte{
    private LocalDate dateFin;
    private double taux;

    public AssuranceVie() {
        super();
    }

    public AssuranceVie(String numero, double solde, Set<Client> clients, Set<Operation> operations, LocalDate dateFin, double taux) {
        super(numero, solde, clients, operations);
        this.dateFin = dateFin;
        this.taux = taux;
    }


    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
