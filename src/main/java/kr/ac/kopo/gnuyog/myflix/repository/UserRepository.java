package kr.ac.kopo.gnuyog.myflix.repository;

import kr.ac.kopo.gnuyog.myflix.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository
{
    Optional<User> findByUsername(String username);
    User save(User user);
    boolean existsByUsername(String username);

    // 관리자용 추가
    List<User> findAll();
    void deleteById(Long id);
}