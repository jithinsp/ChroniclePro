package com.corner.chronicle.repository.mongorepository;

import com.corner.chronicle.entity.mongodb.AccountType;
import com.corner.chronicle.entity.mongodb.Cash;
import com.corner.chronicle.entity.mongodb.Members;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface CashRepository extends MongoRepository<Cash,String> {
    List<Cash> findByAccountType(AccountType type);

    @Query("{ 'accountType' : ?0, 'date' : { $gte: ?1, $lte: ?2 } }")
    List<Cash> findByAccountTypeAndDateBetween(AccountType type, LocalDateTime startOfMonth, LocalDateTime endOfMonth);

    @Query("{ 'date' : { $gte: ?0, $lte: ?1 } }")
    List<Cash> findByDateBetween(LocalDateTime startOfMonth, LocalDateTime endOfMonth);

    List<Cash> findByMembers(Members member);

    @Query("{ 'members' : ?0, 'date' : { $gte: ?1, $lte: ?2 } }")
    List<Cash> findByMembersAndDateBetween(Members member, LocalDateTime startOfMonth, LocalDateTime endOfMonth);
}
