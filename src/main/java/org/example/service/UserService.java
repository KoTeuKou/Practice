package org.example.service;

import org.example.domain.User;
import org.example.repository.UserElasticRepository;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    private final UserElasticRepository elasticRepository;

    public UserService(UserElasticRepository elasticRepository) {
        this.elasticRepository = elasticRepository;
    }

    public List<User> getAccountsBy(String param, String reqString, double cutoff_frequency) throws IOException, JSONException {
        return elasticRepository.getAccountsBy(param, reqString, cutoff_frequency);
    }
    public List<User> getAllAccounts() throws IOException, JSONException {
        return elasticRepository.getAllAccounts();
    }

    public User save(User user) throws IOException {
        return elasticRepository.save(user);
    }
}
