package com.example.bank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Beneficiary {
    private int beneficiaryId;
    private String beneficiaryName;
    private String address;
    private String email;
    private long phNo;
    private long balance;
}
