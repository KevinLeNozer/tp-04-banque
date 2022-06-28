package fr.diginamic;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
public class LivretA extends Compte{
    private double taux;

    public LivretA() {
        super();
    }

    public LivretA(double taux) {
        this.setTaux(taux);
    }

    public LivretA(String numero, double solde, Set<Client> clients, Set<Operation> operations, double taux) {
        super(numero, solde, clients, operations);
        this.taux = taux;
    }


    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
