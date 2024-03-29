package com.corner.chronicle.entity.mongodb;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class AccountType extends BaseEntity {
    private String type;
    private String alias;//for malayalam name
    private String description;
}