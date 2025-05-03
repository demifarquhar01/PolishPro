package demifarquhar01.services;

import demifarquhar01.ClientPreference;
import demifarquhar01.NailTechnician;
import demifarquhar01.User;
import demifarquhar01.repositories.ClientPreferenceRepository;

public class PreferenceService {

    private final ClientPreferenceRepository preferenceRepository;

    public PreferenceService(ClientPreferenceRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
    }

    public void updatePreferences(User user, String clientId, ClientPreference preference) {
        if (!(user instanceof NailTechnician)) {
            throw new SecurityException("Unauthorized access");
        }

        preferenceRepository.save(preference);
    }

    public ClientPreference viewPreferences(User user, String clientId) {
        if (!(user instanceof NailTechnician)) {
            throw new SecurityException("Unauthorized access");
        }

        return preferenceRepository.findById(clientId)
                .orElseThrow(() -> new IllegalStateException("Client preferences not found"));
    }
}
