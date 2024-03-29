package com.corner.chronicle.repository.mongorepository;


import com.corner.chronicle.entity.mongodb.Family;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface FamilyRepository extends MongoRepository<Family,String> {
    @Query("{ 'familyNumber' : ?0 }")
    Family getFamilyByFamilyNumber(Integer familyNumber);
}
