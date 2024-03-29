package com.corner.chronicle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateFamilyRequest {
    private Integer familyNumber;
    private String houseName;
    private String alias;//for malayalam name
    private String area;
    private String aliasArea;//for malayalam name
    private String place;
    private String district;
    private String state;
    private String postCode;
}
