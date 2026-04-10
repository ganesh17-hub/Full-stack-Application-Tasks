package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class FactorialService {
    
    public long calculate(int n) {
        if (n < 0) throw new IllegalArgumentException("Number must be positive");
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}