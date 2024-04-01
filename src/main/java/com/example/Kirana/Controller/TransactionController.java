package com.example.Kirana.Controller;

import com.example.Kirana.Exception.RateLimitExceededException;
import com.example.Kirana.Interceptor.RateLimitInterceptor;
import com.example.Kirana.Model.TransactionModel;
import com.example.Kirana.Service.TransactionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private final TransactionService transactionService;
    @Autowired
    private RateLimitInterceptor rateLimitInterceptor;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //@GetMapping
    @GetMapping("/getalltranscations")
    public ResponseEntity<List<TransactionModel>> getAllTransactions( HttpServletRequest request) {
        boolean allowed = rateLimitInterceptor.allowRequest(request);
        if (!allowed) {
            throw new RateLimitExceededException("Rate limit exceeded");
        }
        List<TransactionModel> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    //@GetMapping("/{id}")
    @GetMapping("/gettransactionbyid/{id}")
    public ResponseEntity<TransactionModel> getTransactionById(@PathVariable String id, HttpServletRequest request) {
        boolean allowed = rateLimitInterceptor.allowRequest(request);
        if (!allowed) {
            throw new RateLimitExceededException("Rate limit exceeded");
        }
        Optional<TransactionModel> transaction = transactionService.getTransactionById(id);
        return transaction.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //@PostMapping
    @PostMapping("/createtransaction")
    public ResponseEntity<TransactionModel> createTransaction(@RequestBody TransactionModel transaction, HttpServletRequest request) {

       boolean allowed = rateLimitInterceptor.allowRequest(request);
        if (!allowed) {
            throw new RateLimitExceededException("Rate limit exceeded");
        }


        TransactionModel createdTransaction = transactionService.createTransaction(transaction);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }

    //@PutMapping("/{id}")
//    @PutMapping("/updatetransaction")
//    public ResponseEntity<Void> updateTransaction(@PathVariable Integer id, @RequestBody TransactionModel transaction) {
//        transactionService.updateTransaction(id, transaction);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    //@DeleteMapping("/{id}")
    @DeleteMapping("/deletetransaction/{id}")
    public ResponseEntity<HttpStatus> deleteTransaction(@PathVariable String id, HttpServletRequest request) {
        boolean allowed = rateLimitInterceptor.allowRequest(request);
        if (!allowed) {
            throw new RateLimitExceededException("Rate limit exceeded");
        }
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

