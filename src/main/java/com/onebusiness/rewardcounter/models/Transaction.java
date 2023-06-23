package com.onebusiness.rewardcounter.models;

import lombok.Data;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Data
public class Transaction {
    private YearMonth date;
    private List<Double> transactionList;
}
