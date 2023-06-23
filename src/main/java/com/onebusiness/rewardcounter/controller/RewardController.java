package com.onebusiness.rewardcounter.controller;


import com.onebusiness.rewardcounter.dto.TransactionDto;
import com.onebusiness.rewardcounter.models.Reward;
import com.onebusiness.rewardcounter.service.RewardService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class RewardController {


    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }


    @PostMapping("/transaction")
    public HashMap<String, Reward> getRewards(@RequestBody() List<TransactionDto> transactionDtolist) {
        return this.rewardService.getRewards(transactionDtolist);
    }

    @PostMapping("/get-rewards-by-customer")
    public Reward getRewardByCustomer(@RequestParam("customer") String customerName, @RequestBody() List<TransactionDto> transactionDtoList) {
        return this.rewardService.getRewardByCustomername(customerName, transactionDtoList);
    }
}





