package pl.edu.agh.ztis.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.ztis.db.models.User;
import pl.edu.agh.ztis.db.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        if (!findById(user.getUserId()).isPresent()) userRepository.save(user);
    }

    public void save(List<User> users) {
        List<User> filteredTweets = users.stream()
                .filter(user -> !findById(user.getUserId()).isPresent())
                .collect(Collectors.toList());
        userRepository.save(filteredTweets);
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userRepository.findByUserId(id));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
