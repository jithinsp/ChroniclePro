package com.corner.chronicle.entity.mongodb;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Members extends BaseEntity {

    private String name;
    private String alias;
    private String sex;
    private String relationWithHouseHolder;
    private String phone;
    private String email;
    private LocalDateTime dateOfBirth;
    private LocalDateTime dateOfBaptism;
    private LocalDateTime dateOfHolyCommunion;
    private LocalDateTime dateOfJoin;
    private String reasonOfJoin;
    private String education;
    private LocalDateTime dateOfLeaving;
    private String reasonOfLeaving;
    private String image; // Assuming image is stored as a string path

    // Instead of OneToOne and ManyToOne relationships, embed or reference as needed
    private Family family;
    private Family parentFamily;

}
