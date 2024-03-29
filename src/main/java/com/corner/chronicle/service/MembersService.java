package com.corner.chronicle.service;


import com.corner.chronicle.dto.CreateMemberRequest;
import com.corner.chronicle.entity.Family;
import com.corner.chronicle.entity.Members;

import java.util.List;

public interface MembersService {
    List<Members> getAllMembers();

    Members getMemberById(Long id);

    Members createMember(CreateMemberRequest createMemberRequest);

    void deleteMemberById(Long id);

    List<Members> getMembersByFamily(Family family);

    Members updateMember(Members existingMember, CreateMemberRequest createMemberRequest);
}
