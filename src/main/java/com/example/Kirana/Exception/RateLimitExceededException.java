package com.example.Kirana.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
public class RateLimitExceededException extends RuntimeException{
    public RateLimitExceededException() {
        super();
    }

    public RateLimitExceededException(String message) {
        super(message);
    }
}
