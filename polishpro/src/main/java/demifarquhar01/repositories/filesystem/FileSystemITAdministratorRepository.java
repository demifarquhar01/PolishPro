package demifarquhar01.repositories.filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import demifarquhar01.ITAdministrator;
import demifarquhar01.repositories.ITAdministratorRepository;


    public class FileSystemITAdministratorRepository implements ITAdministratorRepository {
        public FileSystemITAdministratorRepository(String filePath) {
            // Future: Load IT administrators from JSON file
        }
    
        @Override
        public void save(ITAdministrator itAdministrator) {
            // Future: write to JSON
        }
    
        @Override
        public Optional<ITAdministrator> findById(String id) {
            return Optional.empty();
        }
    
        @Override
        public List<ITAdministrator> findAll() {
            return new ArrayList<>();
        }
    
        @Override
        public void delete(String id) {
            // Future: delete from JSON
        }
    }
    
    

