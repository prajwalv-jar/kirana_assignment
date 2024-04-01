package com.example.Kirana.Interceptor;
import com.example.Kirana.Configuration.RateLimitConfig;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;
@Component
public class RateLimitInterceptor {
    @Autowired
    private RateLimitConfig rateLimitConfig;

    @Autowired
    private TokenBucket tokenBucket;

    public boolean allowRequest(HttpServletRequest request) {
        int capacity = rateLimitConfig.getCapacity();
        int refillTokens = rateLimitConfig.getRefillTokens();
        int refillPeriodInSeconds = rateLimitConfig.getRefillPeriodInSeconds();

        return tokenBucket.tryConsume(capacity, refillTokens, refillPeriodInSeconds);
    }
}
