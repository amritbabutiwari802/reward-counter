package com.onebusiness.rewardcounter.service;

import com.onebusiness.rewardcounter.dto.RewardResponseDto;
import com.onebusiness.rewardcounter.dto.TransactionDto;
import com.onebusiness.rewardcounter.models.FormatedTransaction;
import com.onebusiness.rewardcounter.models.Reward;
import com.onebusiness.rewardcounter.models.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RewardService {
    public   HashMap<String, Reward>  getRewards(List<TransactionDto> transactionDtoList) {
        List<FormatedTransaction> formatedTransactions = formatDateToYearMonth(transactionDtoList);
        HashMap<String, HashMap<String, List<Double>>> categorizedTransaction = categorizeTransactionByCustomername(formatedTransactions);
        HashMap<String, Reward> rewardMap = generateRewardForAllCustomer(categorizedTransaction);
        return rewardMap;
    }

    public Reward getRewardByCustomername(String customername,List<TransactionDto> transactionDtoList){
        HashMap<String, Reward> rewardHashMap = this.getRewards(transactionDtoList);
        if(!rewardHashMap.containsKey(customername)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"customer name not found");
        }

        return rewardHashMap.get(customername);
    }

    //format LocalDate to YearMonth
   public List<FormatedTransaction> formatDateToYearMonth(List<TransactionDto> transactionDtoList){
        List<FormatedTransaction> formatedTransactions = transactionDtoList.stream().map((transaction -> {
            YearMonth yearMonth = YearMonth.of(transaction.getDate().getYear(), transaction.getDate().getMonth());
            FormatedTransaction transaction1 = new FormatedTransaction();
            transaction1.setCustomerName(transaction.getCustomerName());
            transaction1.setAmount(transaction.getAmount());
            transaction1.setDate(yearMonth);
            return transaction1;
        })).toList();
        return formatedTransactions;
    }

    //categorize transactions by Customer name
   public HashMap<String, HashMap<String, List<Double>>> categorizeTransactionByCustomername(List<FormatedTransaction> formatedTransactions) {
        HashMap<String, HashMap<String, List<Double>>> customerMap = new HashMap<>();
        formatedTransactions.forEach(transaction -> {
            HashMap<String, List<Double>> transactionMap;
            List<Double> transactionAmountList;
            if (customerMap.containsKey(transaction.getCustomerName())) {
                transactionMap = customerMap.get(transaction.getCustomerName());
            } else {
                transactionMap = new HashMap<>();
            }
            if (transactionMap.containsKey(transaction.getDate().toString())) {
                transactionAmountList = transactionMap.get(transaction.getDate().toString());
            } else {
                transactionAmountList = new ArrayList<>();
            }
            transactionAmountList.add(transaction.getAmount());
            transactionMap.put(transaction.getDate().toString(), transactionAmountList);
            customerMap.put(transaction.getCustomerName(), transactionMap);

        });
        return customerMap;
    }

  public   HashMap<String, Reward> generateRewardForAllCustomer(HashMap<String, HashMap<String, List<Double>>>  transactionMap){
        RewardResponseDto rewardResponseDto = new RewardResponseDto();
        HashMap<String, Reward> customerMap = new HashMap<>();
        for(Map.Entry<String, HashMap<String, List<Double>>> entry: transactionMap.entrySet()){
            String customerName = entry.getKey();
            Reward reward = new Reward();
            long totalReward = 0;
            HashMap<YearMonth, Long> rewardPerMonth = new HashMap<YearMonth, Long>();
            for(Map.Entry<String, List<Double>> entry1: entry.getValue().entrySet() ){
                YearMonth yearMonth =YearMonth.parse(entry1.getKey());
                Double rewardCalculated = entry1.getValue().stream().reduce((double)(0), (acc, current) ->{
                    return acc + calculateRewardAmount(current);
                });
                rewardPerMonth.put(yearMonth, (long)(double)(rewardCalculated));
                totalReward += rewardCalculated;
            }
            reward.setTotalReward(totalReward);
            reward.setRewardPerMonth(rewardPerMonth);
            customerMap.put(customerName,reward);
        }
        rewardResponseDto.setCustomerMap(customerMap);
        return customerMap;
    }

    Long calculateRewardAmount(double money){
        if(money<=50){
            return  (long)(0);
        } else if (money<=100) {
            return (long)(50);

        }else{
            long reward = (long) (50 + ((long) (money-100))*2);
            return (long)( reward);
        }
    }

}

