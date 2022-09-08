package com.example.bank.repository.Impl;

import com.example.bank.model.Beneficiary;
import com.example.bank.model.Customer;
import com.example.bank.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankRepositoryImpl implements BankRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int createCustomer(Customer customer) {
        String sql = "INSERT INTO Customer(CUSTOMER_ID,CUSTOMER_PASS,CUSTOMER_NAME,CUSTOMER_ADDRESS,EMAIL,PHONE_NO,BALANCE) values (?,?,?,?,?,?,?)";
        Object[] customerDetails = {
                customer.getCustomerId(),
                customer.getCustomerPass(),
                customer.getCustomerName(),
                customer.getAddress(),
                customer.getEmail(),
                customer.getPhNo(),
                customer.getBalance()
        };
        return jdbcTemplate.update(sql, customerDetails);
    }

    @Override
    public List<Customer> retrieveCustomerDetails() {
        String sql = "SELECT * FROM Customer";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                Customer.builder()
                        .customerId(rs.getInt("CUSTOMER_ID"))
                        .customerPass(rs.getInt("CUSTOMER_PASS"))
                        .customerName(rs.getString("CUSTOMER_NAME"))
                        .address(rs.getString("CUSTOMER_ADDRESS"))
                        .email(rs.getString("EMAIL"))
                        .phNo(rs.getLong("PHONE_NO"))
                        .balance(rs.getLong("BALANCE"))
                        .build()
        );
    }

    @Override
    public int deleteCustomer(int customerId) {
        String sql = "DELETE Customer WHERE CUSTOMER_ID=?";
        Object[] DeleteCustomer = {
                customerId
        };
        return jdbcTemplate.update(sql, DeleteCustomer);
    }

    @Override
    public int updateCustomer(Customer customer) {
        String sql = "UPDATE Customer set PHONE_NO=?,CUSTOMER_NAME=?,CUSTOMER_ADDRESS=?,EMAIL=?,BALANCE=?,CUSTOMER_PASS=? WHERE CUSTOMER_ID=?;";
        Object[] updateCustomer = {
                customer.getPhNo(),
                customer.getCustomerName(),
                customer.getAddress(),
                customer.getEmail(),
                customer.getBalance(),
                customer.getCustomerPass(),
                customer.getCustomerId()
        };
        return jdbcTemplate.update(sql, updateCustomer);
    }

    @Override
    public  Customer checkBalanceOfCustomer(int customerId) {
        String sql = "SELECT CUSTOMER_ID,CUSTOMER_NAME,BALANCE,PHONE_NO,CUSTOMER_ADDRESS,EMAIL,CUSTOMER_PASS FROM Customer WHERE CUSTOMER_ID=:customerId";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("customerId", customerId);
        List<Customer> customerList = namedParameterJdbcTemplate.query(sql, mapSqlParameterSource, ((rs, rowNum) ->
                Customer.builder()
                        .customerId(rs.getInt("CUSTOMER_ID"))
                        .customerName(rs.getString("CUSTOMER_NAME"))
                        .balance(rs.getLong("BALANCE"))
                        .phNo(rs.getLong("PHONE_NO"))
                        .address(rs.getString("CUSTOMER_ADDRESS"))
                        .email(rs.getString("EMAIL"))
                        .customerPass(rs.getInt("CUSTOMER_PASS"))
                        .build()
        ));
        return customerList.isEmpty() ? null: customerList.get(0);
    }

    @Override
    public int addBeneficiary(Beneficiary beneficiary) {
        String sql = "INSERT INTO Beneficiary(BENEFICIARY_ID,BENEFICIARY_NAME,BENEFICIARY_ADDRESS,EMAIL,PHONE_NO,BALANCE) VALUES(?,?,?,?,?,?)";
        Object[] addBeneficiary = {
                beneficiary.getBeneficiaryId(),
                beneficiary.getBeneficiaryName(),
                beneficiary.getAddress(),
                beneficiary.getEmail(),
                beneficiary.getPhNo(),
                beneficiary.getBalance()
        };
        return jdbcTemplate.update(sql, addBeneficiary);
    }

    @Override
    public int deleteBeneficiary(int beneficiaryId) {
        String sql = "DELETE Beneficiary where BENEFICIARY_ID=?";
        Object[] deletedBeneficiary = {
                beneficiaryId
        };
        return jdbcTemplate.update(sql, deletedBeneficiary);
    }

    @Override
    public int updateBeneficiary(Beneficiary beneficiary) {
        String sql = "UPDATE Beneficiary SET BENEFICIARY_NAME=?,BENEFICIARY_ADDRESS=?,EMAIL=?,PHONE_NO=?,BALANCE=?  WHERE BENEFICIARY_ID=?";
        Object[] updatedBeneficiary = {
                beneficiary.getBeneficiaryName(),
                beneficiary.getAddress(),
                beneficiary.getEmail(),
                beneficiary.getPhNo(),
                beneficiary.getBalance(),
                beneficiary.getBeneficiaryId()
        };
        return jdbcTemplate.update(sql, updatedBeneficiary);
    }

    @Override
    public List<Beneficiary> retrieveBeneficiaryDetails() {
        String sql = "SELECT * From  Beneficiary";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                Beneficiary.builder()
                        .beneficiaryId(rs.getInt("BENEFICIARY_ID"))
                        .beneficiaryName(rs.getString("BENEFICIARY_NAME"))
                        .address(rs.getString("BENEFICIARY_ADDRESS"))
                        .email(rs.getString("EMAIL"))
                        .phNo(rs.getLong("PHONE_NO"))
                        .balance(rs.getLong("BALANCE"))
                        .build()
        );
    }

    @Override
    public  Beneficiary checkBeneficiaryDetails(int beneficiaryId) {
        String sql = "SELECT BENEFICIARY_ID,BENEFICIARY_NAME,BENEFICIARY_ADDRESS,EMAIL,BALANCE,PHONE_NO FROM Beneficiary WHERE BENEFICIARY_ID=:beneficiaryId";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("beneficiaryId", beneficiaryId);
        List<Beneficiary>beneficiaryList=namedParameterJdbcTemplate.query(sql, mapSqlParameterSource, ((rs, rowNum) ->
                Beneficiary.builder()
                        .beneficiaryId(rs.getInt("BENEFICIARY_ID"))
                        .beneficiaryName(rs.getString("BENEFICIARY_NAME"))
                        .address(rs.getString("BENEFICIARY_ADDRESS"))
                        .email(rs.getString("EMAIL"))
                        .balance(rs.getLong("BALANCE"))
                        .phNo(rs.getLong("PHONE_NO"))
                        .build()
        ));
        return beneficiaryList.isEmpty()? null:beneficiaryList.get(0);
    }

}
