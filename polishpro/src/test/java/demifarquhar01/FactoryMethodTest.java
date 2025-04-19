package demifarquhar01;

import static org.junit.Assert.assertEquals;
    import static org.junit.Assert.assertNotNull;
    import static org.junit.Assert.assertTrue;
import org.junit.Test;

import demifarquhar01.creational_pattern.FactoryMethod.ManicureServiceFactory;
import demifarquhar01.creational_pattern.FactoryMethod.PedicureServiceFactory;
import demifarquhar01.creational_pattern.FactoryMethod.ServiceFactory;

    
    public class FactoryMethodTest {
    
        @Test
        public void testManicureServiceCreation() {
            ServiceFactory factory = new ManicureServiceFactory();
            Service service = factory.createService("Basic Manicure", "Nail shaping and polish", 30, 25.0, true);
    
            assertNotNull(service);
            assertEquals("Basic Manicure", service.getName());
            assertEquals("Nail shaping and polish", service.getDescription());
            assertEquals(30, service.getDuration());
            assertEquals(25.0, service.getPrice(), 0.001);
            assertTrue(service.isStatus());
        }
    
        @Test
        public void testPedicureServiceCreation() {
            ServiceFactory factory = new PedicureServiceFactory();
            Service service = factory.createService("Spa Pedicure", "Foot soak and massage", 45, 35.0, true);
    
            assertNotNull(service);
            assertEquals("Spa Pedicure", service.getName());
            assertEquals("Foot soak and massage", service.getDescription());
            assertEquals(45, service.getDuration());
            assertEquals(35.0, service.getPrice(), 0.001);
            assertTrue(service.isStatus());
        }
    
        @Test
        public void testModifyService() {
            ServiceFactory factory = new ManicureServiceFactory();
            Service service = factory.createService("Basic", "Short", 10, 10.0, false);
    
            service.modifyService("Deluxe", "Includes scrub", 40, 50.0, true);
    
            assertEquals("Deluxe", service.getName());
            assertEquals("Includes scrub", service.getDescription());
            assertEquals(40, service.getDuration());
            assertEquals(50.0, service.getPrice(), 0.001);
            assertTrue(service.isStatus());
        }
    
        @Test
        public void testNegativePriceEdgeCase() {
            ServiceFactory factory = new PedicureServiceFactory();
            Service service = factory.createService("Invalid", "Negative price", 30, -10.0, false);
    
            // In a real system you'd validate and reject this, but for testing we just ensure it's created
            assertEquals(-10.0, service.getPrice(), 0.001);
        }
    
        @Test
        public void testZeroDurationEdgeCase() {
            ServiceFactory factory = new ManicureServiceFactory();
            Service service = factory.createService("Zero Time", "Should be validated", 0, 15.0, true);
    
            assertEquals(0, service.getDuration());
        }
    }
       
    