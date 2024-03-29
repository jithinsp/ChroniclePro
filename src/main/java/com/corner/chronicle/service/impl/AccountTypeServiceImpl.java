package com.corner.chronicle.service.impl;

import com.corner.chronicle.dto.CreateAccountTypeRequest;
import com.corner.chronicle.entity.AccountType;
import com.corner.chronicle.repository.AccountTypeRepository;
import com.corner.chronicle.service.AccountTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeServiceImpl implements AccountTypeService {
    @Autowired
    AccountTypeRepository accountTypeRepository;

    public List<AccountType> getAllAccountTypes() {
        return accountTypeRepository.findAll();
    }

    public AccountType getAccountTypeById(Long id) {
        return accountTypeRepository.findById(id).orElseThrow();
    }

    public AccountType createAccountType(CreateAccountTypeRequest createAccountTypeRequest) {
        AccountType accountType = new AccountType();
        BeanUtils.copyProperties(createAccountTypeRequest,accountType);
        AccountType createdAccountType = accountTypeRepository.save(accountType);
        accountType.setId(createdAccountType.getId());
        return accountType;
    }

    public void deleteAccountTypeById(Long id) {
        accountTypeRepository.deleteById(id);
    }

    public AccountType updateType(AccountType existingType,
                                  CreateAccountTypeRequest createAccountTypeRequest) {
        existingType.setType(createAccountTypeRequest.getType());
        existingType.setDescription(createAccountTypeRequest.getDescription());
        existingType.setAlias(createAccountTypeRequest.getAlias());
        return accountTypeRepository.save(existingType);
    }
}
