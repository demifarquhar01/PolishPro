package demifarquhar01.repositories.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import demifarquhar01.Cancel;
import demifarquhar01.repositories.CancelRepository;

    
    public class InMemoryCancelRepository implements CancelRepository {
        private final Map<String, Cancel> cancelStore = new HashMap<>();
    
        @Override
        public void save(Cancel cancel) {
            cancelStore.put(cancel.getCancelId(), cancel);
        }
    
          @Override
        public Optional<Cancel> findById(String appointmentId) {
            return Optional.ofNullable(cancelStore.get(appointmentId));
        }
    
        @Override
        public void delete(String cancelId) {
            cancelStore.remove(cancelId);
        }
    
        @Override
        public List<Cancel> findAll() {
            return new ArrayList<>(cancelStore.values());
        }
    }
      

