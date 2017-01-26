package com.ilya.shusterman.repository;

import com.ilya.shusterman.beans.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by ilya on 26/01/2017.
 */
public interface UserRepository extends MongoRepository<User, String> {

    public User findByUserName(String userName);
    public List<User> findByType(String type);
}
