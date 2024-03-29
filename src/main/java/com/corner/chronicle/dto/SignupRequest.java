package com.corner.chronicle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupRequest {

    private String email;
    private String name;
    private String password;
}
