package org.example.util;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BulkToJsonParser {
    static public String parse(String indexedData) throws JSONException {
//        String normalizedJSON = indexedData.replaceAll(".*\\[", "").replaceAll("\\{\"_index\\S*", "")
//                .replaceAll("}}", "}").replaceFirst("\\{", "[{").replace("}]}", "}]");
//        JSONArray data = new JSONArray();
//        try {
//            JSONParser parser = new JSONParser();
//            data = (JSONArray) parser.parse(normalizedJSON);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        JSONArray result = new JSONArray();
        JSONObject jsonObject = new JSONObject(indexedData);
        JSONObject hitsObject = jsonObject.getJSONObject("hits");
        JSONArray hits = hitsObject.getJSONArray("hits");
        for (int i = 0; i < hits.length(); i++) {
            JSONObject hit = (JSONObject) hits.get(i);
            result.put(hit.getJSONObject("_source"));
        }
        return result.toString();


    }
}
