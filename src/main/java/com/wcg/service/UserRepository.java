package com.wcg.service;

import com.wcg.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author chengangw
 * @date 4/8/2017 5:14 PM
 */
public interface UserRepository extends MongoRepository<User, Long> {
    User findByUsername(String username);
}
