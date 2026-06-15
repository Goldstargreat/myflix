package kr.ac.kopo.gnuyog.myflix.repository;

import kr.ac.kopo.gnuyog.myflix.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository // Spring이 이 클래스를 자동으로 Bean으로 등록
public class UserRepositoryImpl implements UserRepository
{
    private List<User> users = new ArrayList<>();
    // 사용자들을 저장하는 리스트 (DB 대신 메모리)
    private Long nextId = 3L;
    // 새로 추가될 사용자 ID 시작값 (1, 2 이미 있어서 3부터 시작)

    public UserRepositoryImpl() // 생성자 (객체 만들 때 자동 실행)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // 비밀번호 암호화 객체 생성
        users.add(new User(1L, "admin", encoder.encode("admin123"), "ROLE_ADMIN"));
        // admin 사용자 추가 (비밀번호 암호화해서 저장)
        users.add(new User(2L, "user", encoder.encode("user123"), "ROLE_USER"));
        // 일반 user 계정 추가
    }

    // 사용자 조회
    @Override // 인터페이스 메서드를 구현한다는 표시
    public Optional<User> findByUsername(String username)  // username으로 유저 찾는 함수
    {
        for (int i = 0; i < users.size(); i++)
        {
            User u = users.get(i);
            if (u.getUsername().equals(username))  // users 리스트를 스트림으로 변환
            {
                return Optional.of(u); // 찾으면 해당 User 반환 (null 방지용 Optional)
            }
        }
        return Optional.empty(); // 끝까지 못 찾으면 비어있는 값 반환
    }

    // 사용자 저장
    @Override
    public User save(User user)
    {
        if (user.getId() == null) // id가 없으면
        {
            user.setId(nextId++); // id 자동부여
            users.add(user); // 리스트에 사용자 추가
        }
        return user; // 저장된 사용자 반환
    }

    // 사용자 존재 여부 확인
    @Override
    public boolean existsByUsername(String username) // username이 이미 존재하는지 확인
    {
        for (int i = 0; i < users.size(); i++)
        {
            User u = users.get(i);
            if (u.getUsername().equals(username)) // 같은 username이 있으면
            {
                return true; // 이미 존재함
            }
        }
        return false; // 끝까지 없으면 없음
    }
}