package com.example.Kirana.Configuration;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Configuration
@Setter
@Getter
@ConfigurationProperties(prefix = "rate-limiting")
public class RateLimitConfig {
        private int capacity;
        private int refillTokens;
        private int refillPeriodInSeconds;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRefillTokens() {
        return refillTokens;
    }

    public void setRefillTokens(int refillTokens) {
        this.refillTokens = refillTokens;
    }

    public int getRefillPeriodInSeconds() {
        return refillPeriodInSeconds;
    }

    public void setRefillPeriodInSeconds(int refillPeriodInSeconds) {
        this.refillPeriodInSeconds = refillPeriodInSeconds;
    }

    // Getters and setters
        //...

}
