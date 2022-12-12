package com.example.bank.repository;

import com.example.bank.model.Beneficiary;
import com.example.bank.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class BankRepositoryImplTest {

    @Autowired
    private BankRepository bankRepository;

    @Test
    public void createCustomerTest() {
        Customer customer = Customer.builder()
                .customerId(2)
                .customerPass("1234")
                .customerName("Dinesh")
                .address("harnadha puram")
                .email("mypatidinesh@234")
                .phNo(45612378)
                .balance(100000)
                .build();
        int count = bankRepository.createCustomer(customer);
        assertEquals(1, count);
    }

    @Test
    public void retrieveCustomerDetailsTest() {
        List<Customer> customerList = bankRepository.retrieveCustomerDetails();
        assertNotNull(customerList);
        assertEquals(14, customerList.size());
    }

    @Test
    public void deleteCustomerTest() {
        int count = bankRepository.deleteCustomer(14);
        assertNotNull(count);
        assertEquals(1, count);
    }

    @Test
    public void updateCustomerTest() {
        Customer customer = Customer.builder()
                .customerId(14)
                .customerName("RAVI")
                .customerPass("123")
                .address("harnadhra puram")
                .email("Ravi@321")
                .balance(1000000)
                .phNo(98465217)
                .build();
        int count = bankRepository.updateCustomer(customer);
        assertNotNull(count);
        assertEquals("RAVI", customer.getCustomerName());
    }

    @Test
    public void checkBalanceOfCustomerTest() {
        Customer customer = bankRepository.checkBalanceOfCustomer(1);
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
        int count = bankRepository.addBeneficiary(beneficiary);
        assertNotNull(count);
        assertEquals(1, count);
    }

    @Test
    public void deleteBeneficiaryTest() {
        int count = bankRepository.deleteCustomer(1);
        assertNotNull(count);
        assertEquals(0, count);
    }

    @Test
    public void updateBeneficiaryTest() {
        Beneficiary beneficiary = Beneficiary.builder()
                .beneficiaryId(1)
                .beneficiaryName("Dinesh")
                .address("harnadha puram")
                .email("dinesh@123")
                .balance(10000000)
                .phNo(123456789)
                .build();
        int count = bankRepository.updateBeneficiary(beneficiary);
        assertNotNull(count);
        assertEquals("Dinesh",beneficiary.getBeneficiaryName());
    }

    @Test
    public void retrieveBeneficiaryDetailsTest() {
        List<Beneficiary> beneficiaryList = bankRepository.retrieveBeneficiaryDetails();
        assertNotNull(beneficiaryList);
        assertEquals(15, beneficiaryList.size());
    }

    @Test
    public void checkBeneficiaryDetailsTest() {
        Beneficiary beneficiary = bankRepository.checkBeneficiaryDetails(1);
        assertNotNull(beneficiary);
        assertEquals("Dinesh", beneficiary.getBeneficiaryName());
    }
}
