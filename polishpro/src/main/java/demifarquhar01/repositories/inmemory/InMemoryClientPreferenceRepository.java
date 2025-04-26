package demifarquhar01.repositories.inmemory;
import java.util.ArrayList;
import java.util.HashMap;
    import java.util.List;
    import java.util.Map;
import java.util.Optional;

import demifarquhar01.ClientPreference;
import demifarquhar01.repositories.ClientPreferenceRepository;

public class InMemoryClientPreferenceRepository implements ClientPreferenceRepository {

        private final Map<String, ClientPreference> preferenceStore = new HashMap<>();
    
        @Override
        public void delete(String preferenceId) {
            preferenceStore.remove(preferenceId);
        }
    
        @Override
        public List<ClientPreference> findAll() {
            return new ArrayList<>(preferenceStore.values());
        }

     @Override
        public void save(ClientPreference clientPreference) {
          preferenceStore.put(clientPreference.getPreferenceId(), clientPreference);
        }

       @Override
        public Optional<ClientPreference> findById(String appointmentId) {
            return Optional.ofNullable(preferenceStore.get(appointmentId));
        }
    }

       
