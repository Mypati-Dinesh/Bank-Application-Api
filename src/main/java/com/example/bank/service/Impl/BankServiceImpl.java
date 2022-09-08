package com.example.bank.service.Impl;

import com.example.bank.model.Beneficiary;
import com.example.bank.model.Customer;
import com.example.bank.repository.BankRepository;
import com.example.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    BankRepository bankRepositoryImpl;

    @Override
    public int createCustomer(Customer customer) {
        return bankRepositoryImpl.createCustomer(customer);
    }

    @Override
    public List<Customer> retrieveCustomerDetails() {
        return bankRepositoryImpl.retrieveCustomerDetails();
    }

    @Override
    public int  deleteCustomer(int customerId) {
        return bankRepositoryImpl.deleteCustomer(customerId);
    }

    @Override
    public int updateCustomer(Customer customer) {

        return bankRepositoryImpl.updateCustomer(customer);
    }

    @Override
    public Customer  checkBalanceOfCustomer(int customerId) {
        return bankRepositoryImpl.checkBalanceOfCustomer(customerId);
    }

    @Override
    public int addBeneficiary(Beneficiary beneficiary) {
        return bankRepositoryImpl.addBeneficiary(beneficiary);
    }

    @Override
    public int deleteBeneficiary(int beneficiaryId) {
        return bankRepositoryImpl.deleteBeneficiary(beneficiaryId);
    }

    @Override
    public int updateBeneficiary(Beneficiary beneficiary) {
        return bankRepositoryImpl.updateBeneficiary(beneficiary);
    }

    @Override
    public List<Beneficiary> retrieveBeneficiaryDetails() {
        return bankRepositoryImpl.retrieveBeneficiaryDetails();
    }

    @Override
    public Beneficiary checkBeneficiaryDetails(int beneficiaryId) {
        return bankRepositoryImpl.checkBeneficiaryDetails(beneficiaryId);
    }

    @Override
    public String transferAmountToBeneficiary(int beneficiaryId,int customerId,long balance) {
        String status="failed";
        Customer customer = bankRepositoryImpl.checkBalanceOfCustomer(customerId);
        Beneficiary beneficiary=bankRepositoryImpl.checkBeneficiaryDetails(beneficiaryId);
        if (customer.getBalance()>balance){
            customer.setBalance(customer.getBalance()-balance);
            beneficiary.setBalance(beneficiary.getBalance()+balance);
            status="SUCCESS";
            bankRepositoryImpl.updateCustomer(customer);
            bankRepositoryImpl.updateBeneficiary(beneficiary);
        }
        return status;
    }
}
