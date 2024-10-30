package com.ust.Book_Authentication.Repository;

import com.ust.Book_Authentication.Model.Userinfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserinfoRepo extends MongoRepository<Userinfo, Integer> {
    public Optional<Userinfo> findByUsername(String username);
}
