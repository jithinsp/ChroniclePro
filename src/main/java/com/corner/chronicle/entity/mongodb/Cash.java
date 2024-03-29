package com.corner.chronicle.entity.mongodb;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Cash extends BaseEntity {
    private double amount;
    private LocalDateTime date;
    private String enteredBy;
    private String remarks;
    private boolean isVerified;
    private Members members;
    private AccountType accountType;
}
