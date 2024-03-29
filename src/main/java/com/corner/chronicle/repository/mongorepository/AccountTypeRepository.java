package com.corner.chronicle.repository.mongorepository;

import com.corner.chronicle.entity.mongodb.AccountType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountTypeRepository extends MongoRepository<AccountType,String> {
}
