package com.corner.chronicle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Image extends BaseEntity {

    private String imagePath;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Members member;

}
