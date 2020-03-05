package org.example.repository;

import org.example.service.HttpElasticService;
import org.example.util.HttpRequestType;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class ElasticRepository { //TODO: Refactoring

    private HttpElasticService service;

    public ElasticRepository(HttpElasticService service) {
        this.service = service;
    }

    public String updateAccountById(int id) {
        return "";
    }

    public String addAccountById(int id) {
        return "";
    }

    public boolean removeAccountById(int id) {
        return true;
    }

    public String getAccountsBy(String param, String reqString, double cutoff_frequency) throws IOException {
        String query = "{\n" +
                "    \"query\": {\n" +
                "        \"match\": {\n" + param +
                "            : {\n" +
                "                \"query\": \"" + reqString + "\",\n" +
                "                \"cutoff_frequency\":" + cutoff_frequency + "\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";

        return service.sendRequest(HttpRequestType.POST, "dvd", "_doc", null, "_search", query);
    }

    public String getAllAccounts() throws IOException {
        String query = "{\n" +
                "    \"size\": 10000, " +
                "    \"query\": {\n" +
                "        \"match_all\": {}\n" +
                "    }\n" +
                "}";
        return service.sendRequest(HttpRequestType.GET, "dvd", "user", null, "_search", query);
    }

}
