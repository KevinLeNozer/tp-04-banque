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
        LocalDate dateNaissance2 = LocalDate.of(1996, 8, 29);
        LocalDate dateOperation = LocalDate.of(2020, 10, 14);
        LocalDate dateFin = LocalDate.of(2024, 10, 14);
        Adresse adresse = new Adresse(25, "rue des grissois", 86170, "Avanton");
        Adresse adresse2 = new Adresse(21, "rue des comptes", 86144, "Comptes");
        Client client = new Client("Kevin", "Le Nozer", dateNaissance, adresse);
        Client client2 = new Client("Toto", "Titi", dateNaissance2, adresse2);
        Operation operation = new Operation(dateOperation, 250d, "Loyer");
        Set<Operation> operations = new HashSet<>();
        operations.add(operation);
        Banque banque = new Banque("Fortuneo");
        client.setBanque(banque);
        client2.setBanque(banque);
        Set<Client> clients = new HashSet<>();
        clients.add(client);
        clients.add(client2);

        Compte compte = new Compte("0154870", 2578d, clients, operations);
        operation.setCompte(compte);
        et.persist(banque);

        LivretA compteLivretA = new LivretA("5154", 8054d, clients, operations, 1.5d);
        et.persist(compteLivretA);

        AssuranceVie compteAssuranceVie = new AssuranceVie("5458", 1500d, clients, operations, dateFin, 2.5d);
        et.persist(compteAssuranceVie);

        LocalDate dateVirement = LocalDate.of(2020, 4, 14);
        Virement operationVirement = new Virement(dateVirement, 500d, "Virement", "Kevin");

        LocalDate dateOperation2 = LocalDate.now();
        Operation operation1 = new Operation(dateOperation2, 1500d, "Virement");
        operation1.setCompte(compte);
        operationVirement.setCompte(compte);
        operations.add(operationVirement);

        et.persist(operationVirement);
        et.persist(operation1);
        et.persist(compte);
        et.getTransaction().commit();
    }
}
