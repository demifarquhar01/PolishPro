package demifarquhar01.repositories.filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import demifarquhar01.NailTechnician;
import demifarquhar01.repositories.NailTechnicianRepository;

    public class FileSystemNailTechnicianRepository implements NailTechnicianRepository {
        public FileSystemNailTechnicianRepository(String filePath) {
            // Future: Load nail technicians from JSON file
        }
    
        @Override
        public void save(NailTechnician nailTechnician) {
            // Future: write to JSON
        }
    
        @Override
        public Optional<NailTechnician> findById(String id) {
            return Optional.empty();
        }
    
        @Override
        public List<NailTechnician> findAll() {
            return new ArrayList<>();
        }
    
        @Override
        public void delete(String id) {
            // Future: delete from JSON
        }
    }
       
    

