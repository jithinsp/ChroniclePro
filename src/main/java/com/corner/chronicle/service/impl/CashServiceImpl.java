package com.corner.chronicle.service.impl;

import com.corner.chronicle.dto.CreateCashRequest;
import com.corner.chronicle.entity.AccountType;
import com.corner.chronicle.entity.Cash;
import com.corner.chronicle.entity.Members;
import com.corner.chronicle.repository.AccountTypeRepository;
import com.corner.chronicle.repository.CashRepository;
import com.corner.chronicle.repository.MembersRepository;
import com.corner.chronicle.service.AuthService;
import com.corner.chronicle.service.CashService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CashServiceImpl implements CashService {
    @Autowired
    CashRepository cashRepository;
    @Autowired
    MembersRepository membersRepository;
    @Autowired
    AuthService authService;

    public List<Cash> getAllCash() {
        return cashRepository.findAll();
    }

    public Cash getCashById(Long id) {
        return cashRepository.findById(id).orElseThrow();
    }

    public Cash createCash(CreateCashRequest createCashRequest) {
        Cash cash = new Cash();
        BeanUtils.copyProperties(createCashRequest,cash);
        cash.setEnteredBy(authService.getCurrentLoggedInUser());
        cash.setVerified(false);
        Cash createdCash = cashRepository.save(cash);
        cash.setId(createdCash.getId());
        return cash;
    }

    public void deleteCashById(Long id) {
        cashRepository.deleteById(id);
    }

    public List<Cash> getCashByAccountType(AccountType type) {
        return cashRepository.findByAccountType(type);
    }

    public Cash updateCash(Cash existingCash, CreateCashRequest createCashRequest) {
        existingCash.setAmount(createCashRequest.getAmount());
        existingCash.setRemarks(createCashRequest.getRemarks());
        Members existingMember =
                membersRepository.findById(createCashRequest.getMembers().getId()).orElseThrow();
        existingCash.setMembers(existingMember);
//        AccountType accountType =
//                accountTypeRepository.findById(createCashRequest.getAccountType().getId()).orElseThrow();
//        existingCash.setAccountType(accountType);
        return cashRepository.save(existingCash);
    }

    public List<Cash> getCashByAccountTypeAndMonthYear(AccountType type, Integer year,
                                                       Integer month) {
        // Assuming cashRepository.findByAccountTypeAndCreatedDateBetween method exists
        LocalDateTime startOfMonth = LocalDateTime.of(year, month, 1, 0, 0, 0);
        LocalDateTime endOfMonth = startOfMonth.plusMonths(1).minusSeconds(1);
        return cashRepository.findByAccountTypeAndDateBetween(type, startOfMonth, endOfMonth);
    }

    public List<Cash> getAllCashByMonthYear(Integer year, Integer month) {
        LocalDateTime startOfMonth = LocalDateTime.of(year, month, 1, 0, 0, 0);
        LocalDateTime endOfMonth = startOfMonth.plusMonths(1).minusSeconds(1);
        return cashRepository.findByDateBetween(startOfMonth, endOfMonth);
    }

    public List<Cash> getCashByMember(Members member) {
        return cashRepository.findByMembers(member);
    }

    public List<Cash> getCashByMemberAndMonthYear(Members member, Integer year, Integer month) {
        LocalDateTime startOfMonth = LocalDateTime.of(year, month, 1, 0, 0, 0);
        LocalDateTime endOfMonth = startOfMonth.plusMonths(1).minusSeconds(1);
        return cashRepository.findByMembersAndDateBetween(member,startOfMonth, endOfMonth);
    }

}
