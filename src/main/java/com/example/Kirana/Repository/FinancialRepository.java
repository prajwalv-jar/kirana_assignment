package com.example.Kirana.Repository;

import com.example.Kirana.Model.FinancialReportModel;
import com.example.Kirana.Model.TransactionModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FinancialRepository extends MongoRepository<FinancialReportModel,Integer> {
    //List<FinancialReportModel> findByTimeStampBetween(LocalDateTime startDate, LocalDateTime endDate);

}
