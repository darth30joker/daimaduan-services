package com.daimaduan.repository;

import com.daimaduan.domain.Syntax;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SyntaxRepository extends MongoRepository<Syntax, String> {
    Syntax findByKey(String key);
}
