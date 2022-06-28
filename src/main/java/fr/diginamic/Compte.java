package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "seqCompte", strategy = "increment")
    private int id;
    @Column(name = "numeroCompte", length = 255, nullable = false, unique = false)
    private String numero;
    @Column(name = "SOLDE")
    private double solde;

    @ManyToMany
    @JoinTable(name = "Compte_clients",
            joinColumns = @JoinColumn(name = "compte_client"),
            inverseJoinColumns = @JoinColumn(name = "clients_id"))
    private Set<Client> clients = new LinkedHashSet<>();

    public Set<Client> getClients() {
        return clients;
    }


    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
    
    public Compte() {
    }

    public Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        sb.append("id=").append(id);
        sb.append(", numero='").append(numero).append('\'');
        sb.append(", solde=").append(solde);
        sb.append(", clients=").append(clients);
        sb.append('}');
        return sb.toString();
    }
}
