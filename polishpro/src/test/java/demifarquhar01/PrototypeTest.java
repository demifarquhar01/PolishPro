package demifarquhar01;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import demifarquhar01.creational_pattern.Prototype;
import demifarquhar01.creational_pattern.Prototype.Service;

public class PrototypeTest {

    @Test
    public void testServicePrototypeClone() throws CloneNotSupportedException {
        // Arrange
        Service original = new Prototype().new Service("S01", "Gel Polish", "Long-lasting gel polish", 35.0);

        // Act
        Service cloned = (Service) original.clone();

        // Assert
        assertNotNull(cloned);
        assertNotSame(original, cloned);  // Different instances
        assertEquals(original.getServiceId(), cloned.getServiceId());
        assertEquals(original.getName(), cloned.getName());
        assertEquals(original.getDescription(), cloned.getDescription());
        assertEquals(original.getPrice(), cloned.getPrice(), 0.001);
    }

    @Test
    public void testServiceCloneEdgeCase() {
        try {
            Service service = new Prototype().new Service(null, "", "", -10.0);
            Service cloned = (Service) service.clone();

            assertEquals(null, cloned.getServiceId());
            assertEquals("", cloned.getName());
            assertEquals("", cloned.getDescription());
            assertEquals(-10.0, cloned.getPrice(), 0.001);
        } catch (CloneNotSupportedException e) {
            fail("Clone should be supported: " + e.getMessage());
        }
    }
}

       
    

