package demifarquhar01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import demifarquhar01.creational_pattern.SimpleFactory;

public class SimpleFactoryTest {
//JUnit 5
    @Test
    public void testCreateClient() {
        User user = SimpleFactory.createUser("Client", "C001", "Alice", "alice@email.com", "password123");

        assertNotNull(user);
        assertTrue(user instanceof Client);
        assertEquals("C001", user.getUserId());
        assertEquals("Alice", user.getName());
        assertEquals("alice@email.com", user.getEmail());
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testCreateNailTechnician() {
        User user = SimpleFactory.createUser("NailTechnician", "T001", "Bob", "bob@email.com", "password456");

        assertNotNull(user);
        assertTrue(user instanceof NailTechnician);
        assertEquals("T001", user.getUserId());
        assertEquals("Bob", user.getName());
        assertEquals("bob@email.com", user.getEmail());
        assertEquals("password456", user.getPassword());
    }

    @Test
    public void testCreateSalonOwner() {
        User user = SimpleFactory.createUser("SalonOwner", "S001", "Sarah", "sarah@email.com", "password789");

        assertNotNull(user);
        assertTrue(user instanceof SalonOwner);
        assertEquals("S001", user.getUserId());
        assertEquals("Sarah", user.getName());
        assertEquals("sarah@email.com", user.getEmail());
        assertEquals("password789", user.getPassword());
    }

    @Test
    public void testCreateITAdministrator() {
        User user = SimpleFactory.createUser("ITAdministrator", "I001", "John", "john@email.com", "adminpassword");

        assertNotNull(user);
        assertTrue(user instanceof ITAdministrator);
        assertEquals("I001", user.getUserId());
        assertEquals("John", user.getName());
        assertEquals("john@email.com", user.getEmail());
        assertEquals("adminpassword", user.getPassword());
    }

    @Test
    public void testCreateUserWithInvalidType() {
        User user = SimpleFactory.createUser("InvalidType", "X001", "Invalid", "invalid@email.com", "password");

        assertNull(user);
    }

    @Test
    public void testCreateUserWithNullValues() {
        User user = SimpleFactory.createUser("Client", null, null, null, null);

        assertNotNull(user);
        assertNull(user.getUserId());
        assertNull(user.getName());
        assertNull(user.getEmail());
        assertNull(user.getPassword());
    }

    @Test
    public void testCreateUserWithEmptyValues() {
        User user = SimpleFactory.createUser("Client", "", "", "", "");

        assertNotNull(user);
        assertEquals("", user.getUserId());
        assertEquals("", user.getName());
        assertEquals("", user.getEmail());
        assertEquals("", user.getPassword());
    }
}
