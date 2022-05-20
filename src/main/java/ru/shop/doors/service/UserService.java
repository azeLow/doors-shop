package ru.shop.doors.service;

import org.springframework.stereotype.Service;
import ru.shop.doors.model.User;
import ru.shop.doors.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User userFromClient){
        User user = new User();
        user.setFirstName(userFromClient.getFirstName());
        user.setLastName(userFromClient.getLastName());
        user.setEmail(userFromClient.getEmail());
        user.setDeleted(false);
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        User user = userRepository.getById(id);
        return user;
    }

    public void deleteUser(Long id){
        User user = userRepository.getById(id);
        user.setDeleted(true);
        userRepository.save(user);
    }
}
