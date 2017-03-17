package com.daimaduan.repository;

import com.daimaduan.domain.Paste;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PasteRepository extends MongoRepository<Paste, String> {
    Paste findByHashId(String hashId);
}
