package org.example.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ElasticResponseDeserializer {
    private static JsonParser jsonParser = new JsonParser();

    public static String getFieldAsString(String json, String field) {
        JsonObject obj = jsonParser.parse(json).getAsJsonObject();
        return obj.get(field).getAsString();
    }
}
