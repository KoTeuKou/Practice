package org.example.service;

import org.example.domain.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository elasticRepository) {
        this.userRepository = elasticRepository;
    }

    public List<User> getAccountsBy(String surname, String name, String patronymic, String phone, String mail) {
        return userRepository.findAllBySurnameStartingWithAndNameStartingWithAndPatronymicStartingWithAndPhoneStartingWithAndMailStartingWith(
                surname, name, patronymic, phone, mail);
    }

    public List<User> getAllAccounts() {
        AggregatedPageImpl<User> all = (AggregatedPageImpl<User>) userRepository.findAll();
        return all.getContent();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void remove(String id) {
        userRepository.deleteById(id);
    }
}
