package org.example.service;

import org.example.domain.User;
import org.example.repository.UserElasticRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ElasticService {
    private UserElasticRepository elasticRepository;
    
    public ElasticService(UserElasticRepository elasticRepository){
        this.elasticRepository = elasticRepository;
    }

    public List<User> getAccountsBy(String param, String reqString, double cutoff_frequency) throws IOException {
        return elasticRepository.getAccountsBy(param, reqString, cutoff_frequency);
    }
    public List<User> getAllAccounts() throws IOException {
        return elasticRepository.getAllAccounts();
    }
}
