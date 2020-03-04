package org.example.util;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BulkToJsonParser {
    static public JSONArray parse(String indexedData){
        String normalizedJSON = indexedData.replaceAll(".*\\[", "").replaceAll("\\{\"_index\\S*", "")
                .replaceAll("}}", "}").replaceFirst("\\{", "[{").replace("}]}", "}]");
        JSONArray data = new JSONArray();
        try {
            JSONParser parser = new JSONParser();
            data = (JSONArray) parser.parse(normalizedJSON);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }
}
