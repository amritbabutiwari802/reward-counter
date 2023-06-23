package com.onebusiness.rewardcounter.models;

import lombok.Data;

import java.time.YearMonth;

@Data
public class FormatedTransaction {
    private String customerName;
    private YearMonth date;
    private double amount;
}
