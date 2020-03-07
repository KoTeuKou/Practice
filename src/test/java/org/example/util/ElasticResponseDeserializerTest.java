package org.example.util;

import org.junit.jupiter.api.Test;

class ElasticResponseDeserializerTest {

    @Test
    void getFieldAsString() {
        String json =
                "{\n" +
                        "    \"_index\": \"test\",\n" +
                        "    \"_type\": \"_doc\",\n" +
                        "    \"_id\": \"someId\",\n" +
                        "    \"_version\": 1,\n" +
                        "    \"result\": \"created\",\n" +
                        "    \"_shards\": {\n" +
                        "        \"total\": 2,\n" +
                        "        \"successful\": 1,\n" +
                        "        \"failed\": 0\n" +
                        "    },\n" +
                        "    \"_seq_no\": 11,\n" +
                        "    \"_primary_term\": 5\n" +
                        "}";

        String result = ElasticResponseDeserializer.getFieldAsString(json, "_id");

        System.out.println(result);
    }
}