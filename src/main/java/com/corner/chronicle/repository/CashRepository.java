package com.corner.chronicle.repository;


import com.corner.chronicle.entity.AccountType;
import com.corner.chronicle.entity.Cash;
import com.corner.chronicle.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CashRepository extends JpaRepository<Cash,Long> {
    List<Cash> findByAccountType(AccountType type);

    List<Cash> findByAccountTypeAndDateBetween(AccountType type, LocalDateTime startOfMonth, LocalDateTime endOfMonth);

    List<Cash> findByDateBetween(LocalDateTime startOfMonth, LocalDateTime endOfMonth);

    List<Cash> findByMembers(Members member);

    List<Cash> findByMembersAndDateBetween(Members member, LocalDateTime startOfMonth, LocalDateTime endOfMonth);
}
