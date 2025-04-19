package demifarquhar01;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import demifarquhar01.creational_pattern.SimpleFactory;


public class SimpleFactoryTest {
 
    @Test
   public void testCreateClient() {
        // Test valid user creation
        User user = SimpleFactory.createUser("Client", "C001", "Alice", "alice@email.com", "password123");

        assertNotNull(user); // Ensure object is created
        assertTrue(user instanceof Client); // Ensure the object is of type Client
        assertEquals("C001", user.getUserId());
        assertEquals("Alice", user.getName());
        assertEquals("alice@email.com", user.getEmail());
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testCreateNailTechnician() {
        // Test valid user creation for NailTechnician
        User user = SimpleFactory.createUser("NailTechnician", "T001", "Bob", "bob@email.com", "password456");

        assertNotNull(user); // Ensure object is created
        assertTrue(user instanceof NailTechnician); // Ensure the object is of type NailTechnician
        assertEquals("T001", user.getUserId());
        assertEquals("Bob", user.getName());
        assertEquals("bob@email.com", user.getEmail());
        assertEquals("password456", user.getPassword());
    }

    @Test
    public void testCreateSalonOwner() {
        // Test valid user creation for SalonOwner
        User user = SimpleFactory.createUser("SalonOwner", "S001", "Sarah", "sarah@email.com", "password789");

        assertNotNull(user); // Ensure object is created
        assertTrue(user instanceof SalonOwner); // Ensure the object is of type SalonOwner
        assertEquals("S001", user.getUserId());
        assertEquals("Sarah", user.getName());
        assertEquals("sarah@email.com", user.getEmail());
        assertEquals("password789", user.getPassword());
    }

    @Test
    public void testCreateITAdministrator() {
        // Test valid user creation for ITAdministrator
        User user = SimpleFactory.createUser("ITAdministrator", "I001", "John", "john@email.com", "adminpassword");

        assertNotNull(user); // Ensure object is created
        assertTrue(user instanceof ITAdministrator); // Ensure the object is of type ITAdministrator
        assertEquals("I001", user.getUserId());
        assertEquals("John", user.getName());
        assertEquals("john@email.com", user.getEmail());
        assertEquals("adminpassword", user.getPassword());
    }

    @Test
   public void testCreateUserWithInvalidType() {
        // Test invalid user creation (unknown user type)
        User user = SimpleFactory.createUser("InvalidType", "X001", "Invalid", "invalid@email.com", "password");
        assertNull(user); // Expect null as the user type is invalid
    }

    @Test
    public void testCreateUserWithNullValues() {
        // Test null values for user attributes
        User user = SimpleFactory.createUser("Client", null, null, null, null);
        
        assertNotNull(user); // Object should still be created
        assertNull(user.getUserId()); // Ensure userId is null
        assertNull(user.getName()); // Ensure name is null
        assertNull(user.getEmail()); // Ensure email is null
        assertNull(user.getPassword()); // Ensure password is null
    }

    @Test
    public void testCreateUserWithEmptyValues() {
        // Test empty string values for user attributes
        User user = SimpleFactory.createUser("Client", "", "", "", "");
        
        assertNotNull(user); // Object should still be created
        assertEquals("", user.getUserId()); // Ensure userId is an empty string
        assertEquals("", user.getName()); // Ensure name is an empty string
        assertEquals("", user.getEmail()); // Ensure email is an empty string
        assertEquals("", user.getPassword()); // Ensure password is an empty string
    }
}
   

