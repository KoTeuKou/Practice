package org.example.elastic;

import org.example.util.HttpRequestType;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Repository
public class ElasticRepository { //TODO: Refactoring

    public String get() {
        return "";
    }

    public String getAccountByEmail(String email) throws IOException {
        String query = "{\n" +
                "    \"query\": {\n" +
                "        \"match\": {\n" +
                "            \"mail\": {\n" +
                "                \"query\": \"" + email + "\",\n" +
                "                \"cutoff_frequency\": 0.01\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";

        return sendRequest(HttpRequestType.POST, "dvd", "_doc", "_search", query);
    }

    public String getAccountByPhone(String phone) {
        return "";
    }

    public String getAccountByFullName(String fullName) {
        return "";
    }

    public boolean removeAccountById(int id) {
        return true;
    }


    public String sendRequest(HttpRequestType requestType, String index, String document, String endpoint, String searchQuery) throws IOException {
        HttpURLConnection connection = createHttpConnection("http://localhost:9200/", index, document, endpoint);
        connection.setRequestMethod(requestType.toString());

        if (searchQuery != null) {
            setJsonQuery(searchQuery, connection);
        }

        String responseResult;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            responseResult = response.toString();
        }

        return responseResult;
    }


    private HttpURLConnection createHttpConnection(String url, String index, String document, String endpoint) throws IOException {
        if (index == null) {
            index = "";
        } else {
            index += "/";
        }
        if (document == null) {
            document = "";
        } else {
            document += "/";
        }

        if (endpoint == null) {
            endpoint = "";
        }

        URL uri = new URL(url + index + document + endpoint);

        return (HttpURLConnection) uri.openConnection();
    }

    private void setJsonQuery(String query, HttpURLConnection connection) {
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = query.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
