package com.corner.chronicle.service;


import com.corner.chronicle.dto.CreateAccountTypeRequest;
import com.corner.chronicle.entity.AccountType;

import java.util.List;

public interface AccountTypeService {
    List<AccountType> getAllAccountTypes();

    AccountType getAccountTypeById(Long id);

    AccountType createAccountType(CreateAccountTypeRequest createAccountTypeRequest);

    void deleteAccountTypeById(Long id);

    AccountType updateType(AccountType existingType, CreateAccountTypeRequest createAccountTypeRequest);
}
