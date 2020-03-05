package org.example.service;

import org.example.util.HttpRequestType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class HttpElasticService {
    @Value("elasticsearch.url")
    private String url;

    public HttpElasticService() {
    }

    public String sendRequest(HttpRequestType requestType, String index, String document, String id, String endpoint, String searchQuery) throws IOException {
        HttpURLConnection connection = createHttpConnection(url, index, document, id, endpoint);
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

    private HttpURLConnection createHttpConnection(String url, String index, String document, String id, String endpoint) throws IOException {
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
        if (id == null) {
            id = "";
        } else {
            id += "/";
        }
        if (endpoint == null) {
            endpoint = "";
        }

        URL uri = new URL(url + index + document + id + endpoint);

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
