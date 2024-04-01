package com.example.Kirana.Service;

import com.example.Kirana.Exception.RateLimitExceededException;
import com.example.Kirana.Interceptor.RateLimitInterceptor;
import com.example.Kirana.Model.TransactionModel;
import com.example.Kirana.Repository.TransactionRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {


    @Autowired
    private final TransactionRepository transactionRepository;


    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionModel> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<TransactionModel> getTransactionById(String id) {
        return transactionRepository.findById(Integer.valueOf(id));
    }

    public TransactionModel createTransaction(TransactionModel transaction) {


        return transactionRepository.save(transaction);
    }

//    public void updateTransaction(Integer id, TransactionModel transaction) {
//        transaction.setId(id);
//        transactionRepository.save(transaction);
//    }

    public void deleteTransaction(String id) {
        transactionRepository.deleteById(Integer.valueOf(id));
    }
}

