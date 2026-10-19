package repository;

import entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserRepoImpl implements UserRepository {
    private final List<User> users;

    public UserRepoImpl() {
        this.users = new ArrayList<>();
    }

    public UserRepoImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public Optional<User> findById(String id) {
        return users.stream()
                .filter(user -> Objects.equals(user.getId(), id))
                .findFirst();
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }
}
