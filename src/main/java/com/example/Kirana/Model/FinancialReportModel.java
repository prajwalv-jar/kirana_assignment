package com.example.Kirana.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;



@Data
@Document
public class FinancialReportModel {
    //private LocalDate startDate;
   // private LocalDate endDate;
//    private int year;
//    private int month;


    private BigDecimal totalCredits;
    private BigDecimal totalDebits;
    private BigDecimal netFlow;

    public FinancialReportModel() {
    }

    public FinancialReportModel(BigDecimal totalCredits, BigDecimal totalDebits, BigDecimal netFlow) {
        this.totalCredits = totalCredits;
        this.totalDebits = totalDebits;
        this.netFlow = netFlow;
    }

    //    public void setTotalCredits(BigDecimal totalCredits) {
//        this.totalCredits = totalCredits;
//    }
//
//    // Getter for totalCredits
//    public BigDecimal getTotalCredits() {
//        return totalCredits;
//    }
//
//    // Setter for totalDebits
//    public void setTotalDebits(BigDecimal totalDebits) {
//        this.totalDebits = totalDebits;
//    }
//
//    // Getter for totalDebits
//    public BigDecimal getTotalDebits() {
//        return totalDebits;
//    }
//
//    // Setter for netFlow
//    public void setNetFlow(BigDecimal netFlow) {
//        this.netFlow = netFlow;
//    }
//
//    // Getter for netFlow
//    public BigDecimal getNetFlow() {
//        return netFlow;
//    }
}
