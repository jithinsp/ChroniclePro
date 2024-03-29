package com.corner.chronicle.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Family extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Integer familyNumber;
    private String houseName;
    @Column(nullable = true)
    private String alias;//for malayalam houseName
    private String area;
    @Column(nullable = true)
    private String aliasArea;//for malayalam name
    private String place;
    private String district;
    private String state;
    @Column(nullable = true)
    private String postCode;
}
