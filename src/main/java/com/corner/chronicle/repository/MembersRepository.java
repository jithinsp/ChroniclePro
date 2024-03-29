package com.corner.chronicle.repository;

import com.corner.chronicle.entity.Family;
import com.corner.chronicle.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembersRepository extends JpaRepository<Members,Long> {
    List<Members> findByFamily(Family family);
}
