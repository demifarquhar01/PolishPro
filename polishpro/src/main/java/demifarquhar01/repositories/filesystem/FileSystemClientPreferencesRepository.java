package demifarquhar01.repositories.filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import demifarquhar01.ClientPreference;
import demifarquhar01.repositories.ClientPreferenceRepository;


    
    public class FileSystemClientPreferencesRepository implements ClientPreferenceRepository {
        public FileSystemClientPreferencesRepository(String filePath) {
            // Future: Load client preferences from JSON file
        }
    
        @Override
        public void save(ClientPreference preferences) {
            // Future: write to JSON
        }
    
        @Override
        public Optional<ClientPreference> findById(String clientId) {
            return Optional.empty();
        }
    
        @Override
        public List<ClientPreference> findAll() {
            return new ArrayList<>();
        }
    
        @Override
        public void delete(String clientId) {
            // Future: delete from JSON
        }
    }
       
    

