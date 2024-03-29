package com.corner.chronicle.service;


import com.corner.chronicle.dto.CreateCashRequest;
import com.corner.chronicle.entity.AccountType;
import com.corner.chronicle.entity.Cash;
import com.corner.chronicle.entity.Members;

import java.util.List;

public interface CashService {
    List<Cash> getAllCash();

    Cash getCashById(Long id);

    Cash createCash(CreateCashRequest createCashRequest);

    void deleteCashById(Long id);

    List<Cash> getCashByAccountType(AccountType type);

    Cash updateCash(Cash existingCash, CreateCashRequest createCashRequest);

    List<Cash> getCashByAccountTypeAndMonthYear(AccountType type, Integer year, Integer month);

    List<Cash> getAllCashByMonthYear(Integer year, Integer month);

    List<Cash> getCashByMember(Members member);

    List<Cash> getCashByMemberAndMonthYear(Members member, Integer year, Integer month);
}
