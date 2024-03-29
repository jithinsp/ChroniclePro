package com.corner.chronicle.entity.mongodb;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Family extends BaseEntity {

    private Integer familyNumber;
    private String houseName;
    private String alias;
    private String area;
    private String aliasArea;
    private String place;
    private String district;
    private String state;
    private String postCode;

}
