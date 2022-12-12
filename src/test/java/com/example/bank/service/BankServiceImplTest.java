package com.example.bank.service;

import com.example.bank.model.Beneficiary;
import com.example.bank.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class BankServiceImplTest {

    @Autowired
    private BankService bankService;

    @Test
    public void createCustomerTest() {
        Customer customer = Customer.builder()
                .customerId(1)
                .customerName("dinesh")
                .customerPass("12345")
                .address("harnadha puram")
                .email("dinesh@123")
                .balance(1000000)
                .phNo(987456123)
                .build();
        int count = bankService.createCustomer(customer);
        assertNotNull(count);
        assertEquals(1, count);
    }

    @Test
    public void retrieveCustomerDetailsTest() {
        List<Customer> customerList = bankService.retrieveCustomerDetails();
        assertNotNull(customerList);
        assertEquals(13, customerList.size());
    }

    @Test
    public void deleteCustomerTest() {
        int count = bankService.deleteCustomer(1);
        assertNotNull(count);
        assertEquals(1, count);
    }

    @Test
    public void updateCustomerTest() {
        Customer customer = Customer.builder()
                .customerId(1)
                .customerName("dinesh")
                .customerPass("12345")
                .address("harnadha puram")
                .email("dinesh@123")
                .balance(1000000)
                .phNo(987456123)
                .build();
        int count = bankService.updateCustomer(customer);
        assertNotNull(count);
        assertEquals("dinesh", customer.getCustomerName());
    }

    @Test
    public void checkBalanceOfCustomerTest() {
        Customer customer = bankService.checkBalanceOfCustomer(1);
        assertNotNull(customer);
        assertEquals("dinesh", customer.getCustomerName());
    }

    @Test
    public void addBeneficiaryTest() {
        Beneficiary beneficiary = Beneficiary.builder()
                .beneficiaryId(1)
                .beneficiaryName("dinesh")
                .address("Harnadha puram")
                .email("dinesh@123")
                .balance(1000000)
                .phNo(98465217)
                .build();
        int count = bankService.addBeneficiary(beneficiary);
        assertNotNull(count);
        assertEquals(1, count);
    }

    @Test
    public void deleteBeneficiaryTest() {
        int count = bankService.deleteBeneficiary(1);
        assertNotNull(count);
        assertEquals(1, count);
    }

    @Test
    public void updateBeneficiaryTest() {
        Beneficiary beneficiary = Beneficiary.builder()
                .beneficiaryId(1)
                .beneficiaryName("dinesh")
                .address("Harnadha puram")
                .email("dinesh@123")
                .balance(1000000)
                .phNo(98465217)
                .build();
        int count = bankService.updateBeneficiary(beneficiary);
        assertNotNull(count);
        assertEquals("dinesh", beneficiary.getBeneficiaryName());
    }

    @Test
    public void retrieveBeneficiaryDetailsTest() {
        List<Beneficiary>beneficiaryList = bankService.retrieveBeneficiaryDetails();
        assertNotNull(beneficiaryList);
        assertEquals(15,beneficiaryList.size());
    }

    @Test
    public void checkBeneficiaryDetailsTest(){
        Beneficiary beneficiary = bankService.checkBeneficiaryDetails(1);
        assertNotNull(beneficiary);
        assertEquals("dinesh",beneficiary.getBeneficiaryName());
    }

    @Test
    public void transferAmountToBeneficiaryTest(){
        String beneficiary = bankService.transferAmountToBeneficiary(1,1,10000);
        assertNotNull(beneficiary);
        assertEquals("SUCCESS",beneficiary);
    }
}
