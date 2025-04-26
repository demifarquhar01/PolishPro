package demifarquhar01.repositories.filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import demifarquhar01.Client;
import demifarquhar01.repositories.ClientRepository;


    public class FileSystemClientRepository implements ClientRepository {
        public FileSystemClientRepository(String filePath) {
            // Future: Load from file
        }
    
        @Override
        public void save(Client client) {
            // Future: write to JSON file
        }
    
        @Override
        public Optional<Client> findById(String id) {
            return Optional.empty(); // Future
        }
    
        @Override
        public List<Client> findAll() {
            return new ArrayList<>(); // Future
        }
    
        @Override
        public void delete(String id) {
            // Future: delete from file
        }
    }
    
    
