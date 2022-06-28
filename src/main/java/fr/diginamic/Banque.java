package fr.diginamic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Banque")
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "seqBanque", strategy = "increment")
    private int id;
    @Column(name = "nomBanque", length = 50, nullable = false, unique = false)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Banque client;

    @OneToMany(mappedBy = "banque", orphanRemoval = true)
    private Set<Client> clients = new LinkedHashSet<>();

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Banque getClient() {
        return client;
    }

    public void setClient(Banque client) {
        this.client = client;
    }

    public Banque(int id) {
        this.id = id;
    }

    public Banque(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Banque{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", client=").append(client);
        sb.append(", clients=").append(clients);
        sb.append('}');
        return sb.toString();
    }
}
