package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class TestBanque {
    public static void main(String[] args) {
        EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("banque-jpa");

        EntityManager et = entityManager.createEntityManager();

        et.getTransaction().begin();

        LocalDate dateNaissance = LocalDate.of(1993, 9, 14);
        LocalDate dateOperation= LocalDate.of(2020, 10, 14);
        Adresse adresse = new Adresse(25, "rue des grissois", 86170, "Avanton");
        Client client = new Client("Kevin", "Le Nozer", dateNaissance, adresse);
        Operation operation = new Operation(dateOperation, 250d, "Loyer");
        Set<Operation> operations = new HashSet<>();
        operations.add(operation);
        Banque banque = new Banque("Fortuneo");
        client.setBanque(banque);
        Set<Client> clients = new HashSet<>();
        clients.add(client);
        Compte compte = new Compte("0154870", 2578d, clients, operations);
        operation.setCompte(compte);
        et.persist(banque);
        et.persist(compte);

        et.getTransaction().commit();
    }
}
