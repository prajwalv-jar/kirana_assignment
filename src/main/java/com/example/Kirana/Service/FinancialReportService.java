package com.example.Kirana.Service;
import com.example.Kirana.Model.FinancialReportModel;
import com.example.Kirana.Model.TransactionModel;

import com.example.Kirana.Repository.FinancialRepository;
import com.example.Kirana.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
public class FinancialReportService {
    @Autowired
    private TransactionRepository transactionrepo;

    @Autowired
    private FinancialRepository finrepo;
    public FinancialReportModel createFinancialReport(FinancialReportModel financialReport) {
        // You can perform any additional business logic or validation here before saving the financial report
        return finrepo.save(financialReport);
    }
//    public FinancialReportModel generateWeeklyReport(LocalDate startDate, LocalDate endDate) {
//        List<TransactionModel> transactions = transactionrepo.findByTimeStampBetween(
//                startDate.atStartOfDay(),
//                endDate.atTime(23, 59, 59)
//        );
//        return generateReport(transactions);
//    }

    public FinancialReportModel generateWeeklyReport() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneWeekAgo = now.minusDays(7);
        System.out.println("inside week");
        List<TransactionModel> result = transactionrepo.findByTimeStampBetween(oneWeekAgo,now);
        return generateReport(result);
    }

//    public FinancialReportModel generateMonthlyReport(int month, int year) {
//        LocalDate startOfMonth = LocalDate.of(year, month, 1);
//        LocalDate endOfMonth = startOfMonth.with(TemporalAdjusters.lastDayOfMonth());
//        List<TransactionModel> transactions = transactionrepo.findByTimeStampBetween(
//                startOfMonth.atStartOfDay(),
//                endOfMonth.atTime(23, 59, 59)
//        );
//        return generateReport(transactions);
//    }


   // @Override
    public  FinancialReportModel getMonthlyTransaction() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneMonthAgo = now.minusMonths(1);
        List<TransactionModel> result = transactionrepo.findByTimeStampBetween(oneMonthAgo, now);
        return generateReport(result);
    }

//    public FinancialReportModel generateYearlyReport(int year) {
//        LocalDate startOfYear = LocalDate.of(year, 1, 1);
//        LocalDate endOfYear = startOfYear.with(TemporalAdjusters.lastDayOfYear());
//        List<TransactionModel> transactions = transactionrepo.findByTimeStampBetween(
//                startOfYear.atStartOfDay(),
//                endOfYear.atTime(23, 59, 59)
//        );
//        return generateReport(transactions);
//    }

    //@Override
    public FinancialReportModel getYearlyTransaction() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneYearAgo = now.minusYears(1);
        List<TransactionModel> result = transactionrepo.findByTimeStampBetween(oneYearAgo, now);
        return generateReport(result);
    }

//    private FinancialReportModel generateReport(List<TransactionModel> transactions) {
//        BigDecimal totalCredits = BigDecimal.ZERO;
//        BigDecimal totalDebits = BigDecimal.ZERO;
//
//        for (TransactionModel transaction : transactions) {
//            if (transaction.getAmount().compareTo(BigDecimal.ZERO) >= 0) {
//                totalCredits = totalCredits.add(transaction.getAmount());
//            } else {
//                totalDebits = totalDebits.add(transaction.getAmount().negate());
//            }
//        }
//
//        BigDecimal netFlow = totalCredits.subtract(totalDebits);
//
//        return new FinancialReportModel(
//
//                totalCredits,
//                totalDebits,
//                netFlow
//        );
//}
private FinancialReportModel generateReport(List<TransactionModel> transactions) {
    BigDecimal totalCredits = BigDecimal.ZERO;
    BigDecimal totalDebits = BigDecimal.ZERO;

    for (TransactionModel transaction : transactions) {
        if (transaction.getType().equals("credit")) {
            totalCredits = totalCredits.add(transaction.getAmount());
        } else {
            totalDebits = totalDebits.add(transaction.getAmount());
        }
    }

    BigDecimal netFlow = totalCredits.subtract(totalDebits);

    return new FinancialReportModel(

            totalCredits,
            totalDebits,
            netFlow
    );
}
}
