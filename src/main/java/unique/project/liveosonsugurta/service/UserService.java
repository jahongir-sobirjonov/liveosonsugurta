package unique.project.liveosonsugurta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unique.project.liveosonsugurta.entity.User;
import unique.project.liveosonsugurta.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
