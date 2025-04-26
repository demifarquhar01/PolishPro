package demifarquhar01;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.repositories.ClientRepository;
import demifarquhar01.repositories.inmemory.InMemoryClientRepository;


 // tests/InMemoryClientRepositoryTest.java
public class InMemoryClientRepositoryTest {
    private ClientRepository repo;

    @BeforeEach
    public void setup() {
        repo = new InMemoryClientRepository();
    }

    @Test
    public void testSaveClient() {
        Client client = new Client("c1", "Demi Client", "client@example.com", "secret");
        repo.save(client);

        // No assertion yet because save is verified through findById
        // You could check size if needed, but usually we test retrieval separately
        assertEquals(1, repo.findAll().size(), "After saving, repository should have 1 client");
    }

    @Test
    public void testFindByIdClient() {
        Client client = new Client("c1", "Demi Client", "client@example.com", "secret");
        repo.save(client); // save first

        Optional<Client> found = repo.findById("c1");

        assertTrue(found.isPresent(), "Client should be found by ID");
        assertEquals("Demi Client", found.get().getName(), "Found client's name should match");
    }

    @Test
    public void testDeleteClient() {
        Client client = new Client("c2", "Anna Client", "anna@example.com", "hidden");
        repo.save(client);
        repo.delete("c2");

        assertFalse(repo.findById("c2").isPresent(), "Client should not exist after deletion");
    }

    @Test
    public void testFindAllClients() {
        repo.save(new Client("c3", "Client1", "c1@mail.com", "123"));
        repo.save(new Client("c4", "Client2", "c2@mail.com", "456"));

        assertEquals(2, repo.findAll().size(), "Repository should return all saved clients");
    }
}
   

