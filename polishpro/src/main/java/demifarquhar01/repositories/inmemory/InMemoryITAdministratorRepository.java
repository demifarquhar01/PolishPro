package demifarquhar01.repositories.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import demifarquhar01.ITAdministrator;
import demifarquhar01.repositories.ITAdministratorRepository;

public class InMemoryITAdministratorRepository implements ITAdministratorRepository  {
    private final Map<String, ITAdministrator> adminStore = new HashMap<>();
     
        @Override
        public void save(ITAdministrator iTAdministrator) {
           adminStore.put(iTAdministrator.getUserId(), iTAdministrator);
        }
     @Override
        public Optional<ITAdministrator> findById(String id) {
            return Optional.ofNullable(adminStore.get(id));
        }

        @Override
        public void delete(String userId) {
            adminStore.remove(userId);
        }
    
        @Override
        public List<ITAdministrator> findAll() {
            return new ArrayList<>(adminStore.values());
        }
    }