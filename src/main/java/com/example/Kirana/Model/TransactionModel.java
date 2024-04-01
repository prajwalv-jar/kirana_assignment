package com.example.Kirana.Model;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document
//@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionModel {

    @Id
    private String id;

    private String currency;
    private BigDecimal amount;
    private String type;

    private LocalDateTime timeStamp;
    private float amountToDollar;



    //private boolean credit;
    //private String date;

    //private boolean success;
    //private String creditordebit;


    public TransactionModel() {
    }

    public TransactionModel(String id, String currency, BigDecimal amount, String type, LocalDateTime timeStamp, float amountToDollar) {
        this.id = id;
        this.currency = currency;
        this.amount = amount;
        this.type = type;
        this.timeStamp = timeStamp;
        this.amountToDollar = amountToDollar;
    }

//    public LocalDateTime getTimeStamp() {
//        return timeStamp;
//    }


    @Override
    public String toString() {
        return "TransactionModel{" +
                "id='" + id + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", timeStamp=" + timeStamp +
                ", amountToDollar=" + amountToDollar +
                '}';
    }

}