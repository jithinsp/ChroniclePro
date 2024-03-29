package com.corner.chronicle.repository.mongorepository;


import com.corner.chronicle.entity.mongodb.Family;
import com.corner.chronicle.entity.mongodb.Members;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MembersRepository extends MongoRepository<Members,String> {
    List<Members> findByFamily(Family family);
}
