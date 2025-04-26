package demifarquhar01.repositories.inmemory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import demifarquhar01.Service;
import demifarquhar01.repositories.ServiceRepository;

    
    public class InMemoryServiceRepository implements ServiceRepository {
    
        private final Map<String, Service> serviceStorage = new HashMap<>();
    
        @Override
        public void save(Service service) {
            serviceStorage.put(service.getName(), service);
        }
    
        @Override
        public Optional<Service> findById(String name) {
            return Optional.ofNullable(serviceStorage.get(name));
        }
    
        @Override
        public List<Service> findAll() {
            return new ArrayList<>(serviceStorage.values());
        }
    
        @Override
        public void delete(String name) {
            serviceStorage.remove(name);
        }
    }
    

