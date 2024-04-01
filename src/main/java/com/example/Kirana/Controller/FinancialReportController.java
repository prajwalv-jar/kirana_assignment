package com.example.Kirana.Controller;
import com.example.Kirana.Model.FinancialReportModel;
import com.example.Kirana.Model.TransactionModel;
import com.example.Kirana.Repository.TransactionRepository;
import com.example.Kirana.Service.FinancialReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/financialreportcontroller")
public class FinancialReportController {
    @Autowired
    private FinancialReportService financialReportService;
    @PostMapping("/create")
    public ResponseEntity<FinancialReportModel> createFinancialReport(@RequestBody FinancialReportModel financialReport) {
        FinancialReportModel createdReport = financialReportService.createFinancialReport(financialReport);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReport);
    }

//    @GetMapping("/weekly/{startDate}/{endDate}")
//    public FinancialReportModel generateWeeklyReport(
//            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
//            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
//        return financialReportService.generateWeeklyReport(startDate, endDate);
//    }


    @GetMapping("/weekly")
    public ResponseEntity<FinancialReportModel> getWeeklyReport() {
        System.out.println("inside weekly report");
        return new ResponseEntity<FinancialReportModel>(financialReportService.generateWeeklyReport(), HttpStatus.CREATED);
    }
//    @GetMapping("/monthly/{month}/{year}")
//    public FinancialReportModel generateMonthlyReport(
//            @RequestParam("month") int month,
//            @RequestParam("year") int year) {
//        return financialReportService.generateMonthlyReport(month, year);
//    }

    @GetMapping("/monthly")

    public ResponseEntity<FinancialReportModel> getMonthlyReport() {
        return new ResponseEntity<FinancialReportModel>(financialReportService.getMonthlyTransaction(), HttpStatus.CREATED);
    }



//    @GetMapping("/yearly/{year}")
//    public FinancialReportModel generateYearlyReport(
//            @RequestParam("year") int year) {
//        return financialReportService.generateYearlyReport(year);
//    }


    @GetMapping("/yearly")

    public ResponseEntity<FinancialReportModel> getYearlyReport() {
        return new ResponseEntity<FinancialReportModel>(financialReportService.getYearlyTransaction(), HttpStatus.CREATED);
    }
}
