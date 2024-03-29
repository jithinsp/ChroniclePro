package com.corner.chronicle.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AccountType extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @Column(nullable = true)
    private String alias;//for malayalam name
    @Column(nullable = true)
    private String description;
}