package kr.ac.kopo.gnuyog.myflix.repository;

import kr.ac.kopo.gnuyog.myflix.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository
{
    private List<User> users = new ArrayList<>();
    private Long nextId = 3L;

    public UserRepositoryImpl()
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        users.add(new User(1L, "admin", encoder.encode("admin123"), "ROLE_ADMIN"));
        users.add(new User(2L, "user", encoder.encode("user123"), "ROLE_USER"));
    }
    @Override
    public Optional<User> findByUsername(String username)
    {
        return users.stream().filter(u -> u.getUsername().equals(username)).findFirst();
    }
    @Override
    public User save(User user)
    {
        if (user.getId() == null)
        {
            user.setId(nextId++);
            users.add(user);
        }
        return user;
    }

    @Override
    public boolean existsByUsername(String username)
    {
        return users.stream().anyMatch(u -> u.getUsername().equals(username));
    }
}
