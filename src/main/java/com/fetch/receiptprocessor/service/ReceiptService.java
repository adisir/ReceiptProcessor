package com.fetch.receiptprocessor.service;

import com.fetch.receiptprocessor.model.Item;
import com.fetch.receiptprocessor.model.Receipt;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;

@Service
@Getter
@Setter
public class ReceiptService {
    private HashMap<String, Integer> pointsTracker = new HashMap<>();

    public String processReceipt(Receipt receipt) {
        String id = UUID.randomUUID().toString();
        Integer points = assignPoints(receipt);
        pointsTracker.put(id, points);
        return id;
    }
    public Integer getPoints(String id){
        return pointsTracker.get(id);
    }
    private int assignPoints(Receipt receipt) {
        int points = 0;
        //One point for every alphanumeric character in the retailer name.
        for (int i = 0; i < receipt.getRetailer().length(); i++) {
            char ch = receipt.getRetailer().charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                points++;
            }
        }
        double total = Double.parseDouble(receipt.getTotal());
        //50 points if the total is a round dollar amount with no cents.
        if (total % 1 == 0) points += 50;
        //25 points if the total is a multiple of 0.25.
        if (total % 0.25 == 0) points += 25;
        //5 points for every two items on the receipt.
        points += (receipt.getItems().size() / 2) * 5;
        //If the trimmed length of the item description is a multiple of 3, multiply the price by 0.2 and round up to the nearest integer.
        for (Item item : receipt.getItems()) {
            if (item.getShortDescription().trim().length() % 3 == 0) {
                double price = Double.parseDouble(item.getPrice());
                points += Math.ceil(price * 0.2);
            }
        }
        //6 points if the day in the purchase date is odd.
        LocalDate date = LocalDate.parse(receipt.getPurchaseDate());
        if (date.getDayOfMonth() % 2 == 1) points += 6; // Odd day
        //10 points if the time of purchase is after 2:00pm and before 4:00pm.
        LocalTime time = LocalTime.parse(receipt.getPurchaseTime(), DateTimeFormatter.ofPattern("HH:mm"));
        if (time.isAfter(LocalTime.of(14, 0)) && time.isBefore(LocalTime.of(16, 0))) {
            points += 10;
        }
        return points;
    }
}
