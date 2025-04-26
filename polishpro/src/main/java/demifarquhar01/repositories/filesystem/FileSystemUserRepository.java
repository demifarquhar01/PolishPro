package demifarquhar01.repositories.filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import demifarquhar01.User;
import demifarquhar01.repositories.UserRepository;




public class FileSystemUserRepository implements UserRepository {
    public FileSystemUserRepository(String filePath) {
        // Future: Load users from JSON file
    }

    @Override
    public void save(User user) {
        // Future: write to JSON
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void delete(String id) {
        // Future: delete from JSON
    }
}
 
    

