package com.corner.chronicle.controller;

import com.corner.chronicle.dto.CreateFamilyRequest;
import com.corner.chronicle.entity.Family;
import com.corner.chronicle.entity.Members;
import com.corner.chronicle.service.FamilyService;
import com.corner.chronicle.service.MembersService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("register/family")
public class FamilyController {

    @Autowired
    FamilyService familyService;

    @GetMapping("getFamilies")
    public ResponseEntity<?> getFamilies(){
        try {
            List<Family> familyList = familyService.getAllFamily();
            return ResponseEntity.ok(familyList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("getFamily")
    public ResponseEntity<?> getFamily(@RequestBody Map<String, Integer> requestBody) {
        Integer id = requestBody.get("id");
        try {
            Family family = familyService.getFamilyByFamilyNumber(id);
            return ResponseEntity.ok(family);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such family found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("getFamilyForEdit")
    public ResponseEntity<?> getFamilyForEdit(@RequestBody Map<String, Long> requestBody) {
        Long id = requestBody.get("id");
        try {
            Family family = familyService.getFamilyById(id);
            return ResponseEntity.ok(family);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such family found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping("createFamily")
    public ResponseEntity<?> createFamily(@RequestBody CreateFamilyRequest createFamilyRequest){
        try{
            Family family = familyService.createFamily(createFamilyRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(family);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create family");
        }
    }

    @DeleteMapping("deleteFamily/{id}")
    public ResponseEntity<String> deleteFamily(@PathVariable Long id){
        try{
            familyService.deleteUserById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such family found");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/editFamily/{id}")
    public ResponseEntity<?> editFamily(@PathVariable Long id,
                                        @RequestBody CreateFamilyRequest createFamilyRequest) {
        try {
            Family existingFamily = familyService.getFamilyById(id);
            if (existingFamily == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Family not found");
            }
            Family updatedFamily = familyService.updateFamily(existingFamily,createFamilyRequest);
            return ResponseEntity.ok(updatedFamily);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update family");
        }
    }


}
