package com.example.Kirana.Repository;

import com.example.Kirana.Model.TransactionModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<TransactionModel,Integer>{
    List<TransactionModel> findByTimeStampBetween(LocalDateTime startDate, LocalDateTime endDate);

}