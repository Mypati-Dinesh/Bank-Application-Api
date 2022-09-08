package com.example.bank.service;

import com.example.bank.model.Beneficiary;
import com.example.bank.model.Customer;

import java.util.List;

public interface BankService {

    int createCustomer(Customer customer);

    List<Customer> retrieveCustomerDetails();

    int deleteCustomer(int customerId);

    int updateCustomer(Customer customer);

    Customer checkBalanceOfCustomer(int customerId);

    int addBeneficiary(Beneficiary beneficiary);

    int deleteBeneficiary(int beneficiaryId);

    int updateBeneficiary(Beneficiary beneficiary);

    List<Beneficiary> retrieveBeneficiaryDetails();

    Beneficiary checkBeneficiaryDetails(int beneficiaryId );

  String transferAmountToBeneficiary(int beneficiaryId,int customerId,long balance);

}
