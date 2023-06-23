package com.onebusiness.rewardcounter.mock;

import com.onebusiness.rewardcounter.dto.TransactionDto;
import com.onebusiness.rewardcounter.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Configuration
public class DataSet {

    @Autowired
    private RewardService rewardService;

    List<LocalDate> dates = List.of("2023-02-23", "2023-01-14",
                    "2023-03-16", "2023-02-03", "2023-01-04", "2023-03-06",
                    "2023-02-17", "2023-01-27", "2023-03-16", "2023-02-03",
                    "2023-01-30", "2023-03-22", "2023-02-11", "2023-01-10",
                    "2023-03-08", "2023-02-23", "2023-01-29", "2023-03-18",
                    "2023-02-15", "2023-01-23", "2023-03-14", "2023-02-03",
                    "2023-01-23", "2023-03-25")
            .stream()
            .map(val -> LocalDate.parse(val))
            .toList();

    List<String> customerName = List.of(
            "John Smith", "Emma Johnson", "Michael Williams",
            "Olivia Brown", "William Jones", "Ava Garcia", "James Miller",
            "Sophia Davis", "Benjamin Rodriguez", "Isabella Martinez",
            "Jacob Wilson", "Mia Anderson", "Ethan Taylor", "Charlotte Thomas",
            "Alexander Hernandez", "Amelia Moore", "Daniel Jackson",
            "Harper Thompson", "Matthew White", "Evelyn Lopez"
    );

    public static <T> T getRandomElement(List<T> list) {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    @Bean
    List<TransactionDto> getMockTransactionDtoList() {
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 400; i++) {
            transactionDtoList.add(new TransactionDto(getRandomElement(customerName), getRandomElement(dates), random.nextInt(1000)));
        }
        return transactionDtoList;
    }

    @Bean
    HashMap<String, HashMap<String, List<Double>>> getMap(){
        return this.rewardService.categorizeTransactionByCustomername(this.rewardService.formatDateToYearMonth(this.getMockTransactionDtoList()));
    }
}
