package com.corner.chronicle.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class Members extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = true)
    private String alias;//for malayalam name
    private Sex sex;
    private Relationship relationWithHouseHolder;
    @Column(nullable = true)
    private String phone;
    @Column(nullable = true)
    private String email;
    @Column(nullable = true)
    private LocalDateTime dateOfBirth;
    @Column(nullable = true)
    private LocalDateTime dateOfBaptism;
    @Column(nullable = true)
    private LocalDateTime dateOfHolyCommunion;
    @Column(nullable = true)
    private LocalDateTime dateOfJoin;
    @Column(nullable = true)
    private String reasonOfJoin;
    @Column(nullable = true)
    private String education;
    @Column(nullable = true)
    private LocalDateTime dateOfLeaving;
    @Column(nullable = true)
    private String  reasonOfLeaving;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Image image;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "family")
    private Family family;

    @ManyToOne(optional = true, cascade = CascadeType.MERGE)
    @JoinColumn(name = "parent_family", nullable = true)
    private Family parentFamily;
}
