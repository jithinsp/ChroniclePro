package com.corner.chronicle.service.impl;

import com.corner.chronicle.service.FamilyService;
import com.corner.chronicle.dto.CreateFamilyRequest;
import com.corner.chronicle.entity.Family;
import com.corner.chronicle.repository.FamilyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyServiceImpl implements FamilyService {
    @Autowired
    FamilyRepository familyRepository;

    public List<Family> getAllFamily() {
        return familyRepository.findAll();
    }

    public Family getFamilyById(Long id) {
        return familyRepository.findById(id).orElseThrow();
    }

    public Family createFamily(CreateFamilyRequest createFamilyRequest) {
        Family family = new Family();
        BeanUtils.copyProperties(createFamilyRequest, family);
        Family createdFamily = familyRepository.save(family);
        family.setId(createdFamily.getId());
        return family;
    }

    public void deleteUserById(Long id) {
        familyRepository.deleteById(id);
    }

    public Family updateFamily(Family existingFamily, CreateFamilyRequest createFamilyRequest) {
        existingFamily.setHouseName(createFamilyRequest.getHouseName());
        existingFamily.setArea(createFamilyRequest.getArea());
        existingFamily.setPlace(createFamilyRequest.getPlace());
        existingFamily.setDistrict(createFamilyRequest.getDistrict());
        existingFamily.setState(createFamilyRequest.getState());
        existingFamily.setPostCode(createFamilyRequest.getPostCode());
        return familyRepository.save(existingFamily);
    }

    public Family getFamilyByFamilyNumber(Integer id) {
        return familyRepository.getFamilyByFamilyNumber(id);
    }
}
