package demifarquhar01.repositories.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import demifarquhar01.User;
import demifarquhar01.repositories.UserRepository;

public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> userStorage = new HashMap<>();

    @Override
    public void save(User user) {
        userStorage.put(user.getUserId(), user);
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(userStorage.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userStorage.values());
    }

    @Override
    public void delete(String id) {
        userStorage.remove(id);
    }
}
   

