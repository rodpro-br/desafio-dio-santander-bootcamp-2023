package rod.pro.service.impl;

import org.springframework.stereotype.Service;
import rod.pro.domain.model.User;
import rod.pro.domain.repository.UserRepository;
import rod.pro.service.UserService;


import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {

        if (userRepository.findById(userToCreate.getId()).isPresent()) {
            throw new IllegalArgumentException("This user already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
