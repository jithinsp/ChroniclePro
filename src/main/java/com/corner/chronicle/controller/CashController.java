package com.corner.chronicle.controller;

import com.corner.chronicle.dto.CreateAccountTypeRequest;
import com.corner.chronicle.dto.CreateCashRequest;
import com.corner.chronicle.entity.AccountType;
import com.corner.chronicle.entity.Cash;
import com.corner.chronicle.entity.Members;
import com.corner.chronicle.service.AccountTypeService;
import com.corner.chronicle.service.CashService;
import com.corner.chronicle.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("accounts/cash")
public class CashController {
    @Autowired
    CashService cashService;
    @Autowired
    AccountTypeService accountTypeService;
    @Autowired
    MembersService membersService;

    @GetMapping("getAllCash")
    public ResponseEntity<?> getAllCash(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month){
        try {
            List<Cash> cash;
            if (year != null && month != null) {
                cash = cashService.getAllCashByMonthYear(year, month);
            } else {
                cash = cashService.getAllCash();
            }
            return ResponseEntity.ok(cash);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("getCashByType/{id}")
    public ResponseEntity<?> getCashByType(
            @PathVariable Long id,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month){
        try{
            AccountType type = accountTypeService.getAccountTypeById(id);
            List<Cash> cash;
            if (year != null && month != null) {
                cash = cashService.getCashByAccountTypeAndMonthYear(type, year, month);
            } else {
                cash = cashService.getCashByAccountType(type);
            }
            return ResponseEntity.ok(cash);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such type found");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("getCashByMember/{id}")
    public ResponseEntity<?> getCashByMember(
            @PathVariable Long id,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month){
        try{
            Members member = membersService.getMemberById(id);
            List<Cash> cash;
            if (year != null && month != null) {
                cash = cashService.getCashByMemberAndMonthYear(member, year, month);
            } else {
                cash = cashService.getCashByMember(member);
            }
            return ResponseEntity.ok(cash);
        } catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such member found");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("getCash")
    public ResponseEntity<?> getCash(@RequestBody Map<String, Long> requestBody) {
        Long id = requestBody.get("id");
        try {
            Cash cash = cashService.getCashById(id);
            return ResponseEntity.ok(cash);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such cash found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping("createCash")
    public ResponseEntity<?> createCash(@RequestBody CreateCashRequest createCashRequest){
        try{
            Cash cash = cashService.createCash(createCashRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(cash);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create cash");
        }
    }


    @DeleteMapping("deleteCash/{id}")
    public ResponseEntity<String> deleteCash(@PathVariable Long id){
        try{
            cashService.deleteCashById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such cash found");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/editCash/{id}")
    public ResponseEntity<?> editCash(@PathVariable Long id,
                                      @RequestBody CreateCashRequest createCashRequest) {
        System.out.println(createCashRequest);
        try {
            Cash existingCash = cashService.getCashById(id);
            if (existingCash == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cash not found");
            }
            Cash updatedCash = cashService.updateCash(existingCash,
                    createCashRequest);
            return ResponseEntity.ok(updatedCash);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update Cash");
        }
    }
}
