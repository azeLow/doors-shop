package ru.shop.doors.service;

import ru.shop.doors.model.User;
import ru.shop.doors.repository.UserRepository;

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

}
