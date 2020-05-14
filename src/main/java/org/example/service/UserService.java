package org.example.service;

import org.example.domain.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository elasticRepository) {
        this.userRepository = elasticRepository;
    }

    public List<User> getAccountsBy(HashMap<String, String> params) {
        return userRepository.getAccountsBy(params);
    }

    public List<User> getAllAccounts() {
        return userRepository.getAllAccounts();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean remove(String id) {
        return userRepository.remove(id);
    }
}
