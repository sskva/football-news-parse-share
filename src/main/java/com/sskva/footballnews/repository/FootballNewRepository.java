package com.sskva.footballnews.repository;

import com.sskva.footballnews.domain.FootballNew;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface FootballNewRepository extends MongoRepository<FootballNew, String> {

    boolean existsByText(String s);
}
