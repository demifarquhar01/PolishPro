package demifarquhar01.repositories.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import demifarquhar01.NailTechnician;
import demifarquhar01.repositories.NailTechnicianRepository;

   
public class InMemoryNailTechnicianRepository implements NailTechnicianRepository {
        private final Map<String, NailTechnician> nailTechnicianStore = new HashMap<>();
    
        @Override
        public void save(NailTechnician nailTechnician) {
           nailTechnicianStore.put(nailTechnician.getUserId(), nailTechnician);
        }
     @Override
        public Optional<NailTechnician> findById(String id) {
            return Optional.ofNullable(nailTechnicianStore.get(id));
        }

        @Override
        public void delete(String userId) {
            nailTechnicianStore.remove(userId);
        }
    
        @Override
        public List<NailTechnician> findAll() {
            return new ArrayList<>(nailTechnicianStore.values());
        }
    }
       
    
