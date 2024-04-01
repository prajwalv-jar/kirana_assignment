package com.example.Kirana.Interceptor;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
@Component
public class TokenBucket {
    private final AtomicInteger tokens = new AtomicInteger(0);
    private long lastRefillTimestamp = System.currentTimeMillis();

    public boolean tryConsume(int capacity, int refillTokens, int refillPeriodInSeconds) {
        refill(capacity, refillTokens, refillPeriodInSeconds);

        if (tokens.get() > 0) {
            tokens.decrementAndGet();
            return true;
        }

        return false;
    }

    private void refill(int capacity, int refillTokens, int refillPeriodInSeconds) {
        long currentTime = System.currentTimeMillis();
        long elapsedTimeInSeconds = (currentTime - lastRefillTimestamp) / 1000;

        if (elapsedTimeInSeconds > refillPeriodInSeconds) {
            int newTokens = (int) Math.min(capacity, tokens.get() + elapsedTimeInSeconds * refillTokens);
            tokens.set(newTokens);
            lastRefillTimestamp = currentTime;
        }
    }
}
