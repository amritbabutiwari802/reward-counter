package com.onebusiness.rewardcounter.controller;

import com.onebusiness.rewardcounter.dto.TransactionDto;
import com.onebusiness.rewardcounter.models.Reward;
import com.onebusiness.rewardcounter.service.RewardService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RewardControllerTest {

    @Autowired
    private  RewardService rewardService;


    @Autowired
    private  List<TransactionDto> transactionDtoList;

    @Autowired
    private RewardController rewardController;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRewards() {
        HashMap<String, Reward> expectedResult = this.rewardService.getRewards(transactionDtoList);
        HashMap<String, Reward> actualResult = this.rewardController.getRewards(transactionDtoList);
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void getRewardByCustomer() {
        String customerName = this.transactionDtoList.get(0).getCustomerName();
        Reward expectedResult = this.rewardService.getRewardByCustomername(customerName, transactionDtoList);
        Reward actualResult = this.rewardController.getRewardByCustomer(customerName, transactionDtoList);
        assertEquals(expectedResult, actualResult);
    }
}