package org.example.repository;

import org.example.domain.User;
import org.example.service.HttpElasticService;
import org.example.util.BulkToJsonParser;
import org.example.util.ElasticResponseDeserializer;
import org.example.util.HttpRequestType;
import org.example.util.UserSerialization;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class UserElasticRepository { //TODO: Refactoring
    @Value("${elasticsearch.index}")
    private String index;

    @Value("${elasticsearch.document}")
    private String document;

    private HttpElasticService service;

    public UserElasticRepository(HttpElasticService service) {
        this.service = service;
    }

    public User save(User user) throws IOException {
        String query = UserSerialization.toJson(user);

        service.sendRequest(HttpRequestType.POST, index, document, user.getId(), null, query);

        return user;
    }

    public boolean remove(String id) throws IOException {
        String response = service.sendRequest(HttpRequestType.DELETE, index, document, id, null, null);

        String status = ElasticResponseDeserializer.getFieldAsString(response, "result");

        return status.equals("deleted");
    }

    public List<User> getAccountsBy(String param, String reqString, double cutoff_frequency) throws IOException, JSONException {
        String query = "{\n" +
                "    \"query\": {\n" +
                "        \"match\": {\n \"" + param +
                "           \": {\n" +
                "                \"query\": \"" + reqString + "\",\n" +
                "                \"cutoff_frequency\":" + cutoff_frequency + "\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";

        String response = service.sendRequest(HttpRequestType.POST, index, document, null, "_search", query);
        return UserSerialization.fromJson(BulkToJsonParser.parse(response));
    }

    public List<User> getAllAccounts() throws IOException, JSONException {
        String query = "{\n" +
                "    \"size\": 10000, " +
                "    \"query\": {\n" +
                "        \"match_all\": {}\n" +
                "    }\n" +
                "}";
        String response = service.sendRequest(HttpRequestType.GET, index, document, null, "_search", query);
        return UserSerialization.fromJson(BulkToJsonParser.parse(response));
    }
}
