package com.onebusiness.rewardcounter.service;

import com.onebusiness.rewardcounter.dto.TransactionDto;
import com.onebusiness.rewardcounter.models.FormatedTransaction;
import com.onebusiness.rewardcounter.models.Reward;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RewardServiceTest {

    @Autowired
    RewardService rewardService;

    @Autowired
    List<TransactionDto> transactionDtoList;

    @Autowired
    HashMap<String, HashMap<String, List<Double>>> formattedTransactionMap;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRewards() {
    }

    @Test
    void getRewardByCustomername() {
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        boolean functionCorrectness = true;
        transactionDtoList.add(new TransactionDto("Hari Prasad", LocalDate.parse("2023-03-15"),100));
        transactionDtoList.add(new TransactionDto("Hari Prasad", LocalDate.parse("2023-02-15"),134));
        transactionDtoList.add(new TransactionDto("Hari Prasad", LocalDate.parse("2023-03-10"),110));
        transactionDtoList.add(new TransactionDto("Kirtan Nepal", LocalDate.parse("2023-03-04"),170));
        transactionDtoList.add(new TransactionDto("Kirtan Nepal", LocalDate.parse("2023-03-07"),120));
        transactionDtoList.add(new TransactionDto("Kirtan Nepal", LocalDate.parse("2023-02-22"),100));
        String customerName = "Hari Prasad";
        Reward result = this.rewardService.getRewardByCustomername(customerName, transactionDtoList);
        HashMap<YearMonth, Long> rewardhashMap = result.getRewardPerMonth();
        YearMonth yearMonth1 = YearMonth.of(LocalDate.parse("2023-03-15").getYear(),
                LocalDate.parse("2023-03-15").getMonth());
        YearMonth yearMonth2 = YearMonth.of(LocalDate.parse("2023-02-15").getYear(),
                LocalDate.parse("2023-02-15").getMonth());
        long rewardAmount1 = rewardhashMap.get(yearMonth1);
        long rewardAmount2 = rewardhashMap.get(yearMonth2);
        assertEquals(rewardAmount1, 50+50+10*2);
        assertEquals(rewardAmount2, 50 + 34*2);
    }

    @Test
    void formatDateToYearMonth() {
        List<LocalDate> localDateList = this.transactionDtoList.stream().map(transactionDto -> transactionDto.getDate()).toList();
        List<YearMonth> EXPECTED_RESULT = localDateList.stream().map(date -> YearMonth.of(date.getYear(), date.getMonth())).toList();
        List<FormatedTransaction> formatedTransactionList = this.rewardService.formatDateToYearMonth(this.transactionDtoList);
        List<YearMonth> actualResult = formatedTransactionList.stream().map(transaction -> transaction.getDate()).toList();
        assertEquals(EXPECTED_RESULT,actualResult);
    }

    @Test
    void categorizeTransactionByCustomername() {
        AtomicInteger correctlyCategorizedTransactions = new AtomicInteger();
        int TOTAL_TRANSACTION_SIZE = this.transactionDtoList.size();
        HashMap<String, HashMap<String, List<Double>>> transactionMap = this.rewardService
                .categorizeTransactionByCustomername(
                        this.rewardService.formatDateToYearMonth(this.transactionDtoList)
                );
        this.transactionDtoList.forEach(transaction ->{
            if(transactionMap.containsKey(transaction.getCustomerName())){
                HashMap<String,List<Double>> hashMap = transactionMap.get(transaction.getCustomerName());
                YearMonth yearMonth = YearMonth.of(transaction.getDate().getYear(), transaction.getDate().getMonth());
                if(hashMap.containsKey(yearMonth.toString())){
                    List<Double> transactionAmountList = hashMap.get(yearMonth.toString());
                    if(transactionAmountList.contains(transaction.getAmount())){
                        int numOfTransactionWithSameAmount = countOccurrences(transactionAmountList, transaction.getAmount());
                        List<TransactionDto> repeatingTransaction = this.transactionDtoList.stream().filter(transaction1 ->
                                transaction1.getCustomerName().equals(transaction.getCustomerName()) &&
                                        transaction1.getAmount()==transaction.getAmount() &&
                                        transaction1.getDate().equals(transaction.getDate())
                        ).toList();
                        int numOfSameTransactionInOriginalList = repeatingTransaction.size();
                        if(numOfSameTransactionInOriginalList == numOfTransactionWithSameAmount){
                            correctlyCategorizedTransactions.incrementAndGet();
                        }
                    }
                }
            }
        } );
      //  this.transactionDtoList.forEach(transaction->{System.out.println(transaction);});
        assertEquals(correctlyCategorizedTransactions.get(), TOTAL_TRANSACTION_SIZE);
    }

    @Test
    void generateRewardForAllCustomer() {
        boolean functionCorrectness = true;
        boolean EXPECTED_RESULT = true;
        HashMap<String, Reward> rewardHashMap = this.rewardService.generateRewardForAllCustomer(this.formattedTransactionMap);

        for(Map.Entry<String, Reward> entry: rewardHashMap.entrySet()){
            String customerName = entry.getKey();
            Reward reward = entry.getValue();
            HashMap<YearMonth,Long> rewardCalculatedPerMonth = reward.getRewardPerMonth();
            for(Map.Entry<YearMonth, Long> entry1 : rewardCalculatedPerMonth.entrySet()){
                YearMonth yearMonth = entry1.getKey();
                Long rewards = entry1.getValue();
                long expectedReward = (long) (double)this.formattedTransactionMap
                        .get(customerName)
                        .get(yearMonth.toString())
                        .stream().reduce((double) 0 , (acc,current) -> acc+this.calculateRewardAmount(current));
                if(rewards!= expectedReward){
                    functionCorrectness=false;
                }

            }

        }

        assertEquals(functionCorrectness, EXPECTED_RESULT);
    }

    @Test
    void calculateRewardAmount() {
        double money = 170.5;
        long DESIRED_REWARD = 190;
        long actualReward = this.rewardService.calculateRewardAmount(money);
        assertEquals(actualReward, DESIRED_REWARD);

    }

    public static <T> int countOccurrences(List<T> list, T value) {
        int count = 0;
        for (T element : list) {
            if (element.equals(value)) {
                count++;
            }
        }
        return count;
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