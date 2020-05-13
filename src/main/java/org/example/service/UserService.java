package org.example.service;

import org.example.domain.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository elasticRepository) {
        this.userRepository = elasticRepository;
    }

    public List<User> getAccountsBy(String param, String reqString, double cutoffFrequency) {
        return userRepository.getAccountsBy(param, reqString, cutoffFrequency);
    }

    public List<User> getAccountsByAllFields(String param, String reqString) {
        return userRepository.getAccountsByAllFields(param, reqString);
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
