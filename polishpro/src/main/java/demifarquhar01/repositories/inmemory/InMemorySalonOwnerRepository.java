package demifarquhar01.repositories.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import demifarquhar01.SalonOwner;
import demifarquhar01.repositories.SalonOwnerRepository;


    public class InMemorySalonOwnerRepository implements SalonOwnerRepository {
        private final Map<String, SalonOwner> salonOwnerStore = new HashMap<>();
    
        @Override
        public void save(SalonOwner salonOwner) {
            salonOwnerStore.put(salonOwner.getUserId(), salonOwner);
        }
    
        @Override
        public Optional<SalonOwner> findById(String salonOwnerId) {
            return Optional.ofNullable(salonOwnerStore.get(salonOwnerId));
        }
    
        @Override
        public void delete(String salonOwnerId) {
            salonOwnerStore.remove(salonOwnerId);
        }
    
        @Override
        public List<SalonOwner> findAll() {
            return new ArrayList<>(salonOwnerStore.values());
        }
    }
    
