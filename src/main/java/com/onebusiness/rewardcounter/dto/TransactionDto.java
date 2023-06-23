package com.onebusiness.rewardcounter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class TransactionDto {

    private String customerName;
    private LocalDate date;
    private double amount;
}
