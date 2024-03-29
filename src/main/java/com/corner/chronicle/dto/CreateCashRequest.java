package com.corner.chronicle.dto;

import com.corner.chronicle.entity.AccountType;
import com.corner.chronicle.entity.Members;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class CreateCashRequest {
    private double amount;
    private Members members;
    private String remarks;
    private LocalDateTime date;
    private AccountType accountType;

}
