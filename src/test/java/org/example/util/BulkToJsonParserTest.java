package org.example.util;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

class BulkToJsonParserTest {

    @Test
    void parse() {
        String s = null;
        try {
            s = BulkToJsonParser.parse("{\n" +
                    "  \"took\": 63,\n" +
                    "  \"timed_out\": false,\n" +
                    "  \"_shards\": {\n" +
                    "    \"total\": 1,\n" +
                    "    \"successful\": 1,\n" +
                    "    \"skipped\": 0,\n" +
                    "    \"failed\": 0\n" +
                    "  },\n" +
                    "  \"hits\": {\n" +
                    "    \"total\": {\n" +
                    "      \"value\": 239,\n" +
                    "      \"relation\": \"eq\"\n" +
                    "    },\n" +
                    "    \"max_score\": 5.077259,\n" +
                    "    \"hits\": [\n" +
                    "      {\n" +
                    "        \"_index\": \"dvd\",\n" +
                    "        \"_type\": \"user\",\n" +
                    "        \"_id\": \"6\",\n" +
                    "        \"_score\": 5.077259,\n" +
                    "        \"_source\": {\n" +
                    "          \"full_name\": \"Ломоносова Ольга Владиленовна\",\n" +
                    "          \"phone\": \"89885005076\",\n" +
                    "          \"mail\": \"Abaxybe@mail.ru\"\n" +
                    "        }\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"_index\": \"dvd\",\n" +
                    "        \"_type\": \"user\",\n" +
                    "        \"_id\": \"1\",\n" +
                    "        \"_score\": 0.0020855062,\n" +
                    "        \"_source\": {\n" +
                    "          \"full_name\": \"Цыганова Анфиса Антониновна\",\n" +
                    "          \"phone\": \"89359722212\",\n" +
                    "          \"mail\": \"Ije@mail.ru\"\n" +
                    "        }\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"_index\": \"dvd\",\n" +
                    "        \"_type\": \"user\",\n" +
                    "        \"_id\": \"2\",\n" +
                    "        \"_score\": 0.0020855062,\n" +
                    "        \"_source\": {\n" +
                    "          \"full_name\": \"Изотов Артур Пахомович\",\n" +
                    "          \"phone\": \"89553841185\",\n" +
                    "          \"mail\": \"Yfanyzo@mail.ru\"\n" +
                    "        }\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"_index\": \"dvd\",\n" +
                    "        \"_type\": \"user\",\n" +
                    "        \"_id\": \"3\",\n" +
                    "        \"_score\": 0.0020855062,\n" +
                    "        \"_source\": {\n" +
                    "          \"full_name\": \"Яговкин Фома Капитонович\",\n" +
                    "          \"phone\": \"89052190718\",\n" +
                    "          \"mail\": \"Bykezaj@mail.ru\"\n" +
                    "        }\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"_index\": \"dvd\",\n" +
                    "        \"_type\": \"user\",\n" +
                    "        \"_id\": \"4\",\n" +
                    "        \"_score\": 0.0020855062,\n" +
                    "        \"_source\": {\n" +
                    "          \"full_name\": \"Яблокова Любава Давидовна\",\n" +
                    "          \"phone\": \"89611683814\",\n" +
                    "          \"mail\": \"Cusyv@mail.ru\"\n" +
                    "        }\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"_index\": \"dvd\",\n" +
                    "        \"_type\": \"user\",\n" +
                    "        \"_id\": \"5\",\n" +
                    "        \"_score\": 0.0020855062,\n" +
                    "        \"_source\": {\n" +
                    "          \"full_name\": \"Вергунов Виталий Проклович\",\n" +
                    "          \"phone\": \"89005489507\",\n" +
                    "          \"mail\": \"Usytexata@mail.ru\"\n" +
                    "        }\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"_index\": \"dvd\",\n" +
                    "        \"_type\": \"user\",\n" +
                    "        \"_id\": \"7\",\n" +
                    "        \"_score\": 0.0020855062,\n" +
                    "        \"_source\": {\n" +
                    "          \"full_name\": \"Распутина Марианна Давидовна\",\n" +
                    "          \"phone\": \"89229398770\",\n" +
                    "          \"mail\": \"Mejiv@mail.ru\"\n" +
                    "        }\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"_index\": \"dvd\",\n" +
                    "        \"_type\": \"user\",\n" +
                    "        \"_id\": \"8\",\n" +
                    "        \"_score\": 0.0020855062,\n" +
                    "        \"_source\": {\n" +
                    "          \"full_name\": \"Бабинова Светлана Игоревна\",\n" +
                    "          \"phone\": \"89802341391\",\n" +
                    "          \"mail\": \"Ihybe@mail.ru\"\n" +
                    "        }\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"_index\": \"dvd\",\n" +
                    "        \"_type\": \"user\",\n" +
                    "        \"_id\": \"9\",\n" +
                    "        \"_score\": 0.0020855062,\n" +
                    "        \"_source\": {\n" +
                    "          \"full_name\": \"Валюхова Василиса Василиевна\",\n" +
                    "          \"phone\": \"89099500017\",\n" +
                    "          \"mail\": \"Umedyki@mail.ru\"\n" +
                    "        }\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"_index\": \"dvd\",\n" +
                    "        \"_type\": \"user\",\n" +
                    "        \"_id\": \"10\",\n" +
                    "        \"_score\": 0.0020855062,\n" +
                    "        \"_source\": {\n" +
                    "          \"full_name\": \"Сазонова Ефросинья Станиславовна\",\n" +
                    "          \"phone\": \"89900949817\",\n" +
                    "          \"mail\": \"Gyvyxel@mail.ru\"\n" +
                    "        }\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  }\n" +
                    "}");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}