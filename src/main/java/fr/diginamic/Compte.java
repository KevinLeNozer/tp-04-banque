package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Compte")
public class Compte {
    @Id
    @Column(name = "numeroCompte", length = 255, nullable = false, unique = false)
    private String numero;
    @Column(name = "SOLDE")
    private double solde;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "Compte_clients",
            joinColumns = @JoinColumn(name = "compte_client"),
            inverseJoinColumns = @JoinColumn(name = "clients_id"))
    private Set<Client> clients = new LinkedHashSet<>();

    @OneToMany(mappedBy = "compte", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<Operation> operations = new LinkedHashSet<>();

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Compte() {
    }

    public Compte(String numero, double solde, Set<Client> clients, Set<Operation> operations) {
        this.numero = numero;
        this.solde = solde;
        this.clients = clients;
        this.operations = operations;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Compte{");
        sb.append(", numero='").append(numero).append('\'');
        sb.append(", solde=").append(solde);
        sb.append(", clients=").append(clients);
        sb.append('}');
        return sb.toString();
    }
}
