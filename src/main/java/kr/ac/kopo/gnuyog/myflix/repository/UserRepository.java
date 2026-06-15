package kr.ac.kopo.gnuyog.myflix.repository;

import kr.ac.kopo.gnuyog.myflix.model.User;
import java.util.Optional;

public interface UserRepository
{
    // UserRepository 만드려면 아래와 같은 기능들을 반드시 구현하라
    Optional<User> findByUsername(String username);
    // username으로 사용자 찾기 있으면 User 반환, 없으면 비어있는 Optional 반환
    User save(User user); // 유저 정보 저장
    boolean existsByUsername(String username); // 아이디 존재 여부 확인
}
