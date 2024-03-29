package com.corner.chronicle.service.impl;

import com.corner.chronicle.entity.Family;
import com.corner.chronicle.service.MembersService;
import com.corner.chronicle.dto.CreateMemberRequest;
import com.corner.chronicle.entity.Members;
import com.corner.chronicle.repository.FamilyRepository;
import com.corner.chronicle.repository.MembersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembersServiceImpl implements MembersService {
    @Autowired
    MembersRepository membersRepository;
    @Autowired
    FamilyRepository familyRepository;

    public List<Members> getAllMembers() {
        return membersRepository.findAll();
    }

    public Members getMemberById(Long id) {
        return membersRepository.findById(id).orElseThrow();
    }

    public Members createMember(CreateMemberRequest createMemberRequest) {
        Members members = new Members();
        BeanUtils.copyProperties(createMemberRequest, members);
        Members createdMember = membersRepository.save(members);
        members.setId(createdMember.getId());
//        Family family = familyRepository.findById(members.getFamily().getId()).orElseThrow();
//        CreateMemberRequestForAccounts createMemberRequestForAccounts =
//                new CreateMemberRequestForAccounts(members.getId(), members.getName(),
//                        members.getFamily().getId(),family.getHouseName());
//        feignAccounts.createMember(createMemberRequestForAccounts);
        return members;
    }

    public void deleteMemberById(Long id) {
        membersRepository.deleteById(id);
    }

    public List<Members> getMembersByFamily(Family family) {
        return membersRepository.findByFamily(family);
    }

    public Members updateMember(Members existingMember, CreateMemberRequest createMemberRequest) {
        existingMember.setAlias(createMemberRequest.getAlias());
        existingMember.setEmail(createMemberRequest.getEmail());
        existingMember.setEducation(createMemberRequest.getEducation());
        existingMember.setName(createMemberRequest.getName());
        existingMember.setSex(createMemberRequest.getSex());
        existingMember.setRelationWithHouseHolder(createMemberRequest.getRelationWithHouseHolder());
        existingMember.setPhone(createMemberRequest.getPhone());
        existingMember.setDateOfBirth(createMemberRequest.getDateOfBirth());
        existingMember.setDateOfBaptism(createMemberRequest.getDateOfBaptism());
        existingMember.setDateOfHolyCommunion(createMemberRequest.getDateOfHolyCommunion());
        existingMember.setDateOfJoin(createMemberRequest.getDateOfJoin());
        existingMember.setReasonOfJoin(createMemberRequest.getReasonOfJoin());
        existingMember.setDateOfLeaving(createMemberRequest.getDateOfLeaving());
        existingMember.setReasonOfLeaving(createMemberRequest.getReasonOfLeaving());
//        existingMember.setParentFamily(createMemberRequest.getParentFamily());
        return membersRepository.save(existingMember);
    }
}
