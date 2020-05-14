package org.example.repository;

import org.example.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {
    List<User> findAllBySurnameStartingWithAndNameStartingWithAndPatronymicStartingWithAndPhoneStartingWithAndMailStartingWith(
            String surname, String name, String patronymic, String phone, String mail);
}
