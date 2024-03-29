package com.corner.chronicle.repository.mongorepository;

import com.corner.chronicle.entity.mongodb.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role,String> {
    @Query("{ 'roleName' : ?0 }")
    Optional<Role> findRoleByName(String name);
}
