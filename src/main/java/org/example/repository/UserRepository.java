package org.example.repository;

import org.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

@Repository
public class UserRepository {

    @Qualifier("template")
    @Autowired
    protected ElasticsearchTemplate elasticsearchTemplate;

    @Value("${elasticsearch.index}")
    private String index;

    @Value("${elasticsearch.document}")
    private String document;


    public UserRepository(ElasticsearchTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    public User save(User user) {
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(user.getId())
                .withIndexName(index).withObject(user)
                .withType(document).build();

        elasticsearchTemplate.index(indexQuery);
        return user;
    }

    public boolean remove(String id) {
        String delete = elasticsearchTemplate.delete(index, document, id);
        return delete.equals(id);
    }

    public List<User> getAllAccounts() {
        return elasticsearchTemplate.queryForList(new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery()).build(), User.class);
    }

    public List<User> getAccountsBy(HashMap<String, String> params) {
        return elasticsearchTemplate.queryForList(new CriteriaQuery(
                new Criteria("name").startsWith(params.get("NAME")).and("surname").startsWith(params.get("SURNAME"))
                        .and("patronymic").startsWith(params.get("PATRONYMIC")).and("phone").startsWith(params.get("PHONE"))
                        .and("mail").startsWith(params.get("MAIL"))), User.class);
    }

}
