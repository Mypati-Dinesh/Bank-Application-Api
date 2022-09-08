package com.example.bank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Customer {
    private int customerId;
    private int customerPass;
    private String customerName;
    private String address;
    private String email;
    private long phNo;
    private long balance;
}
