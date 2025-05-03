package demifarquhar01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import demifarquhar01.repositories.inmemory.InMemoryClientPreferenceRepository;
import demifarquhar01.services.PreferenceService;

public class PreferenceServiceTest {

    private PreferenceService preferenceService;
    private InMemoryClientPreferenceRepository clientPreferenceRepository;
    private NailTechnician technician;
    private ClientPreference preference;

    @BeforeEach
    public void setUp() {
        // Create in-memory repository and service
        clientPreferenceRepository = new InMemoryClientPreferenceRepository();
        preferenceService = new PreferenceService(clientPreferenceRepository);

        // Set up test data
        technician = new NailTechnician("1", "Technician A", "tech@salon.com", "securepass");
        preference = new ClientPreference("1", "Gel nails", "Prefers light colors");
    }

    @Test
    public void testUpdatePreferences_Authorized() {
        preferenceService.updatePreferences(technician, "1", preference);

        ClientPreference saved = clientPreferenceRepository.findById("1").orElse(null);
        assertNotNull(saved);
        assertEquals("Gel nails", saved.getPreferences());
        assertEquals("Prefers light colors", saved.getNotes());
    }

    @Test
    public void testUpdatePreferences_Unauthorized() {
        User unauthorizedUser = new User("2", "Random User", "user@salon.com", "weakpass");

        SecurityException exception = assertThrows(SecurityException.class, () ->
            preferenceService.updatePreferences(unauthorizedUser, "1", preference)
        );

        assertEquals("Unauthorized access", exception.getMessage());
    }

    @Test
    public void testViewPreferences_Authorized() {
        clientPreferenceRepository.save(preference);

        ClientPreference result = preferenceService.viewPreferences(technician, "1");

        assertNotNull(result);
        assertEquals("Gel nails", result.getPreferences());
        assertEquals("Prefers light colors", result.getNotes());
    }

    @Test
    public void testViewPreferences_Unauthorized() {
        clientPreferenceRepository.save(preference);
        User unauthorizedUser = new User("2", "Random User", "user@salon.com", "weakpass");

        SecurityException exception = assertThrows(SecurityException.class, () ->
            preferenceService.viewPreferences(unauthorizedUser, "1")
        );

        assertEquals("Unauthorized access", exception.getMessage());
    }

    @Test
    public void testViewPreferences_ClientNotFound() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () ->
            preferenceService.viewPreferences(technician, "999")
        );

        assertEquals("Client preferences not found", exception.getMessage());
    }
}
