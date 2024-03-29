package com.corner.chronicle.entity.mongodb;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Users extends BaseEntity {
    private String name;
    private String password;
    private String email;
    private Role role;
}
