package com.onebusiness.rewardcounter.models;

import lombok.Data;

import java.time.YearMonth;
import java.util.HashMap;

@Data
public class Reward {
    private long totalReward;
    private HashMap<YearMonth, Long> rewardPerMonth;
}
