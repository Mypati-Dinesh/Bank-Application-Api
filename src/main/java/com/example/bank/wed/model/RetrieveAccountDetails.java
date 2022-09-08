package com.example.bank.wed.model;

import com.example.bank.model.Beneficiary;
import com.example.bank.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RetrieveAccountDetails {
  List<Customer>customer;
  List<Beneficiary>beneficiary;

}
