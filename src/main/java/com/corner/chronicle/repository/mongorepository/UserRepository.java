package com.corner.chronicle.repository.mongorepository;


import com.corner.chronicle.entity.mongodb.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<Users,String> {
    boolean existsByEmail(String email);

    Optional<Users> findByEmail(String email);
}
