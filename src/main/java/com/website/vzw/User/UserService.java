package com.website.vzw.User;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public boolean update(User user, Long id) {
        Optional<User> currentUser = userRepository.findById(id);
        if (currentUser.isPresent()) {
            user.setIdUser(id);
        } else {
            return false;
        }

        userRepository.save(user);
        return true;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
