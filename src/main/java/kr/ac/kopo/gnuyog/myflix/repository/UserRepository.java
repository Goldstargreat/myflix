package kr.ac.kopo.gnuyog.myflix.repository;

import kr.ac.kopo.gnuyog.myflix.model.User;
import java.util.Optional;

public interface UserRepository
{
    Optional<User> findByUsername(String username);
    User save(User user);
    boolean existsByUsername(String username);
}
