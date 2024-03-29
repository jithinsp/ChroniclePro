package com.corner.chronicle.service;


import com.corner.chronicle.dto.CreateFamilyRequest;
import com.corner.chronicle.entity.Family;

import java.util.List;

public interface FamilyService {
    List<Family> getAllFamily();

    Family getFamilyById(Long id);

    Family createFamily(CreateFamilyRequest createFamilyRequest);

    void deleteUserById(Long id);

    Family updateFamily(Family existingFamily, CreateFamilyRequest createFamilyRequest);

    Family getFamilyByFamilyNumber(Integer id);
}
