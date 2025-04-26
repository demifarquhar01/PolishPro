package demifarquhar01.repositories.inmemory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import demifarquhar01.Client;
import demifarquhar01.repositories.ClientRepository;

    
    public class InMemoryClientRepository implements ClientRepository {
        private final Map<String, Client> storage = new HashMap<>();
    
        @Override
        public void save(Client client) {
            storage.put(client.getUserId(), client);
        }
    
        @Override
        public Optional<Client> findById(String id) {
            return Optional.ofNullable(storage.get(id));
        }
    
        @Override
        public List<Client> findAll() {
            return new ArrayList<>(storage.values());
        }
    
        @Override
        public void delete(String id) {
            storage.remove(id);
        }
    }
      
