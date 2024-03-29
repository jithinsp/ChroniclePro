package com.corner.chronicle.repository;

import com.corner.chronicle.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family,Long> {
    Family getFamilyByFamilyNumber(Integer id);
}
