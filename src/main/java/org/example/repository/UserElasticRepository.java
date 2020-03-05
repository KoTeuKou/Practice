package org.example.repository;

import org.example.domain.User;
import org.example.service.HttpService;
import org.example.util.HttpRequestType;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class UserElasticRepository { //TODO: Refactoring

    private HttpService service;

    public UserElasticRepository(HttpService service){
        this.service = service;
    }

    public User updateAccountById(int id){
        return null;
    }

    public User addAccountById(int id){
        return null;
    }

    public boolean removeAccountById(int id) {
        return true;
    }

    public List<User> getAccountsBy(String param, String reqString, double cutoff_frequency) throws IOException {
        String query = "{\n" +
                "    \"query\": {\n" +
                "        \"match\": {\n" + param +
                "            : {\n" +
                "                \"query\": \"" + reqString + "\",\n" +
                "                \"cutoff_frequency\":" + cutoff_frequency+ "\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";

        service.sendRequest(HttpRequestType.POST, "dvd", "_doc", "_search", query);
        return null;
    }

    public List<User> getAllAccounts() throws IOException {
        String query = "{\n" +
                "    \"size\": 10000, " +
                "    \"query\": {\n" +
                "        \"match_all\": {}\n" +
                "    }\n" +
                "}";
        service.sendRequest(HttpRequestType.GET, "dvd", "user", "_search", query);
        return null;
    }

}
