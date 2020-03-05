package org.example.service;

import org.example.repository.ElasticRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ElasticService {
    private ElasticRepository elasticRepository;
    
    public ElasticService(ElasticRepository elasticRepository){
        this.elasticRepository = elasticRepository;
    }

    public String getAccountsBy(String param, String reqString, double cutoff_frequency) throws IOException {
        return elasticRepository.getAccountsBy(param, reqString, cutoff_frequency);
    }

    public String getAllAccounts() throws IOException {
        return elasticRepository.getAllAccounts();
    }
}
