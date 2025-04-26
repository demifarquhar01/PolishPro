package demifarquhar01.repositories.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import demifarquhar01.Reschedule;
import demifarquhar01.repositories.RescheduleRepository;


    
    public class InMemoryRescheduleRepository implements RescheduleRepository {
        private final Map<String, Reschedule> rescheduleStore = new HashMap<>();
    
        @Override
        public void save(Reschedule reschedule) {
            rescheduleStore.put(reschedule.getRescheduleId(), reschedule);
        }
    
        @Override
        public Optional<Reschedule> findById(String rescheduleId) {
            return Optional.ofNullable(rescheduleStore.get(rescheduleId));
        }
    

    
        @Override
        public void delete(String rescheduleId) {
            rescheduleStore.remove(rescheduleId);
        }
    
        @Override
        public List<Reschedule> findAll() {
            return new ArrayList<>(rescheduleStore.values());
        }
    }
   
