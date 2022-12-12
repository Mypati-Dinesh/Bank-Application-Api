package com.example.bank.wed.controller;

import com.example.bank.BankApplication;
import com.example.bank.model.Beneficiary;
import com.example.bank.wed.model.RetrieveAccountDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureWebMvc

public class BeneficiaryControllerTests extends BankApplication {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void addBeneficiaryTest() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("app/jdbc-app/add-beneficiary")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String responseString = mvcResult.getResponse().getContentAsString();
        int result = objectMapper.readValue(responseString, int.class);
        assertNotNull(result);
        assertEquals(1, result);
    }

    @Test
    public void updateBeneficiaryTest() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("app/jdbc-app/update-beneficiary")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String responseString = mvcResult.getResponse().getContentAsString();
        int result = objectMapper.readValue(responseString, int.class);
        assertNotNull(result);
        assertEquals(1, result);
    }

    @Test
    public void deleteBeneficiary() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("app/jdbc-app/delete-beneficiary")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String responseString = mvcResult.getResponse().getContentAsString();
        int result = objectMapper.readValue(responseString, int.class);
        assertNotNull(result);
        assertEquals(1, result);
    }

    @Test
    public void retrieveBeneficiaryDetails() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("app/jdbc-app/retrieve-beneficiary-details")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String responseString = mvcResult.getResponse().getContentAsString();
        RetrieveAccountDetails retrieveAccountDetails = objectMapper.readValue(responseString, RetrieveAccountDetails.class);
        assertNotNull(retrieveAccountDetails);
        assertNotNull(retrieveAccountDetails.getBeneficiary());
        assertEquals(15, retrieveAccountDetails.getBeneficiary().size());
    }

    @Test
    public void checkBeneficiaryDetails() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("app/jdbc-app/check-beneficiary-details-by-id")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String responseString = mvcResult.getResponse().getContentAsString();
        String result = objectMapper.readValue(responseString, String.class);
        assertNotNull(result);
        assertEquals("Dinesh", result);
    }
}
