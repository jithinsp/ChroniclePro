package com.corner.chronicle.dto;
import com.corner.chronicle.entity.Family;
import com.corner.chronicle.entity.Image;
import com.corner.chronicle.entity.Relationship;
import com.corner.chronicle.entity.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CreateMemberRequest {
    private String name;
    private String alias;//for malayalam name
    private Sex sex;
    private Relationship relationWithHouseHolder;
    private String phone;
    private String email;
    private LocalDateTime dateOfBirth;
    private LocalDateTime dateOfBaptism;
    private LocalDateTime dateOfHolyCommunion;
    private LocalDateTime dateOfJoin;
    private String reasonOfJoin;
    private String education;
    private LocalDateTime dateOfLeaving;
    private String  reasonOfLeaving;
    private Image image;
    private Family family;
    private Family parentFamily;
}
