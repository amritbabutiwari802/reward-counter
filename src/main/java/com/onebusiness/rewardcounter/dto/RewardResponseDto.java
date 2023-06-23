package com.onebusiness.rewardcounter.dto;

import com.onebusiness.rewardcounter.models.Reward;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class RewardResponseDto {

    HashMap<String, Reward> customerMap;


}
