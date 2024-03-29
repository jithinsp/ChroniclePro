package com.corner.chronicle.controller;

import com.corner.chronicle.dto.CreateFamilyRequest;
import com.corner.chronicle.dto.CreateMemberRequest;
import com.corner.chronicle.entity.Family;
import com.corner.chronicle.entity.Members;
import com.corner.chronicle.service.FamilyService;
import com.corner.chronicle.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("register/members")
public class MembersController {
    @Autowired
    MembersService membersService;
    @Autowired
    FamilyService familyService;

    //API tested in postman and working
    @GetMapping("getMembers")
    public ResponseEntity<?> getMembers(){
        try {
            List<Members> memberList = membersService.getAllMembers();
            return ResponseEntity.ok(memberList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //API tested in postman and working
    @GetMapping("getMembersByFamily/{id}")
    public ResponseEntity<?> getMembers(@PathVariable Long id){
//        Long id = requestBody.get("id");
        try{
            Family family = familyService.getFamilyById(id);
            List<Members> members = membersService.getMembersByFamily(family);
            return ResponseEntity.ok(members);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //API tested in postman and working
    @PostMapping("getMember")
    public ResponseEntity<?> getMember(@RequestBody Map<String, Long> requestBody) {
        Long id = requestBody.get("id");
        try {
            Members member = membersService.getMemberById(id);
            return ResponseEntity.ok(member);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such member found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //API tested in postman and working
    @PostMapping("createMember")
    public ResponseEntity<?> createFamily(@RequestBody CreateMemberRequest createMemberRequest){
        try{
            System.out.println(createMemberRequest);
            Members member = membersService.createMember(createMemberRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(member);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create member");
        }
    }

    //API tested in postman and working
    @DeleteMapping("deleteMember/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id){
        try{
            System.out.println("Delete id: "+id);
            membersService.deleteMemberById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such member found");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/editMember/{id}")
    public ResponseEntity<?> editMember(@PathVariable Long id,
                                        @RequestBody CreateMemberRequest createMemberRequest) {
        System.out.println(createMemberRequest);
        try {
            Members existingMember = membersService.getMemberById(id);
            if (existingMember == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Member not found");
            }
            Members updatedMember = membersService.updateMember(existingMember,createMemberRequest);
            return ResponseEntity.ok(updatedMember);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update member");
        }
    }
}
