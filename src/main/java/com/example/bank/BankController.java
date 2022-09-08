package com.example.bank;

import com.example.bank.model.Beneficiary;
import com.example.bank.model.Customer;
import com.example.bank.service.BankService;
import com.example.bank.wed.model.RetrieveAccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "app/jdbc-app")

public class BankController {

    @Autowired
    BankService bankServiceImpl;

    @PostMapping("CREATE_CUSTOMER")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        int createdCustomer = bankServiceImpl.createCustomer(customer);
        return ResponseEntity.ok().body(createdCustomer);
    }

    @GetMapping("RETRIEVE_CUSTOMER_DETAILS")
    public ResponseEntity<Object> retrieveCustomerDetails() {
        List<Customer> customerList = bankServiceImpl.retrieveCustomerDetails();
        RetrieveAccountDetails retrieveAccountDetails = RetrieveAccountDetails.builder()
                .customer(customerList)
                .build();
        return ResponseEntity.ok().body(retrieveAccountDetails);
    }

    @GetMapping("DELETE_CUSTOMER_BY_CUSTOMER_ID")
    public ResponseEntity<Object> deleteCustomer(int customerId) {
        int deletedCustomer = bankServiceImpl.deleteCustomer(customerId);
        return ResponseEntity.ok().body(deletedCustomer);
    }

    @PostMapping ("UPDATE_CUSTOMER")
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer) {
       int updatedCustomer=bankServiceImpl.updateCustomer(customer);
        return ResponseEntity.ok().body(updatedCustomer);
    }

    @GetMapping("CHECK_BALANCE_OF_CUSTOMER_BY_CUSTOMER_ID")
    public ResponseEntity<Object> checkBalanceOfCustomer(int customerId) {
        Customer customer  = bankServiceImpl.checkBalanceOfCustomer(customerId);
        return ResponseEntity.ok().body(customer);
    }
    @PostMapping("ADD_BENEFICIARY")
    public ResponseEntity<Object>addBeneficiary(@RequestBody Beneficiary beneficiary){
     int addedBeneficiary=bankServiceImpl.addBeneficiary(beneficiary);
        return ResponseEntity.ok().body(addedBeneficiary);
    }
    @PostMapping("UPDATE_BENEFICIARY")
    public ResponseEntity<Object>updateBeneficiary(@RequestBody Beneficiary beneficiary){
        int updatedBeneficiary=bankServiceImpl.updateBeneficiary(beneficiary);
        return ResponseEntity.ok().body(updatedBeneficiary);
    }
    @GetMapping("DELETE_BENEFICIARY_BY_BENEFICIARY_ID")
    public ResponseEntity<Object>deleteBeneficiary(int beneficiaryId){
     int deletedBeneficiary=bankServiceImpl.deleteBeneficiary(beneficiaryId);
        return ResponseEntity.ok().body(deletedBeneficiary);
    }
    @GetMapping("RETRIEVE_BENEFICIARY_DETAILS")
    public ResponseEntity<Object>retrieveBeneficiaryDetails(){
        List<Beneficiary>beneficiaryList=bankServiceImpl.retrieveBeneficiaryDetails();
        RetrieveAccountDetails retrieveAccountDetails= RetrieveAccountDetails.builder()
                .beneficiary(beneficiaryList)
                .build();
        return ResponseEntity.ok().body(retrieveAccountDetails);
    }
    @GetMapping("CHECK_BALANCE_OF_BENEFICIARY_BY_BENEFICIARY_ID")
    public ResponseEntity<Object>checkBeneficiaryDetails(int beneficiaryId ){
        Beneficiary beneficiary=bankServiceImpl.checkBeneficiaryDetails(beneficiaryId);
        return ResponseEntity.ok().body(beneficiary);
    }
    @GetMapping("TRANSFER_AMOUNT_TO_BENEFICIARY")
    public ResponseEntity<Object>transferAmountToBeneficiary(int beneficiaryId,int customerId,long balance){
        String status = bankServiceImpl.transferAmountToBeneficiary(beneficiaryId,customerId,balance);
        return ResponseEntity.ok().body(status);
    }

}
