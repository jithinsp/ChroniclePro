package com.corner.chronicle.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Cash extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private LocalDateTime date;
    private String enteredBy;
    private String remarks;
    private boolean isVerified;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="members")
    private Members members;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="accountType")
    private AccountType accountType;
}
