package com.corner.chronicle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateAccountTypeRequest {
    private String type;
    private String alias;//for malayalam name
    private String description;
}