package demifarquhar01;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import demifarquhar01.creational_pattern.AbstractFactory.*;
import org.junit.Test;

public class AbstractFactoryTest {

    @Test
    public void testCreateClient() {
        UserFactory factory = new ConcreteUserFactory();
        User client = factory.createClient("C001", "Jane Doe", "jane@example.com", "password123");

        assertNotNull(client);
        assertTrue(client instanceof Client);
        assertEquals("C001", client.getUserId());
        assertEquals("Jane Doe", client.getName());
        assertEquals("jane@example.com", client.getEmail());
        assertEquals("password123", client.getPassword());
    }

    @Test
    public void testCreateNailTechnician() {
        UserFactory factory = new ConcreteUserFactory();
        User tech = factory.createNailTechnician("T001", "Tom Nails", "tom@example.com", "pass456");

        assertNotNull(tech);
        assertTrue(tech instanceof NailTechnician);
        assertEquals("T001", tech.getUserId());
        assertEquals("Tom Nails", tech.getName());
        assertEquals("tom@example.com", tech.getEmail());
    }

    @Test
    public void testCreateSalonOwner() {
        UserFactory factory = new ConcreteUserFactory();
        User owner = factory.createSalonOwner("S001", "Sarah Style", "sarah@example.com", "salon789");

        assertNotNull(owner);
        assertTrue(owner instanceof SalonOwner);
        assertEquals("S001", owner.getUserId());
        assertEquals("Sarah Style", owner.getName());
    }

    @Test
    public void testCreateITAdministrator() {
        UserFactory factory = new ConcreteUserFactory();
        User admin = factory.createITAdministrator("A001", "Alex Admin", "admin@example.com", "secure999");

        assertNotNull(admin);
        assertTrue(admin instanceof ITAdministrator);
        assertEquals("A001", admin.getUserId());
        assertEquals("Alex Admin", admin.getName());
    }

    @Test
    public void testEdgeCaseEmptyEmail() {
        UserFactory factory = new ConcreteUserFactory();
        User client = factory.createClient("C002", "No Email", "", "noEmail123");

        assertEquals("", client.getEmail()); // in real-world you’d validate or throw error
    }

    @Test
    public void testEdgeCaseNullPassword() {
        UserFactory factory = new ConcreteUserFactory();
        User tech = factory.createNailTechnician("T002", "Null Pass", "nullpass@example.com", null);

        assertNull(tech.getPassword()); // in production you'd prevent this
    }
}

