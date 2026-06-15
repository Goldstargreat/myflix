package kr.ac.kopo.gnuyog.myflix.service;

import kr.ac.kopo.gnuyog.myflix.model.User;
import kr.ac.kopo.gnuyog.myflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean register(String username, String password) {
        if (userRepository.existsByUsername(username)) return false;
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return true;
    }
}