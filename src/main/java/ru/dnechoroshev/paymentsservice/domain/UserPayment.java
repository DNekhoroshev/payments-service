package ru.dnechoroshev.paymentsservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class UserPayment implements Comparable<UserPayment> {

    private String userName;

    private BigDecimal amount;

    public void addAmount(BigDecimal newAmount) {
        amount = amount.add(newAmount);
    }

    @Override
    public int compareTo(UserPayment anotherPayment) {
        return amount.compareTo(anotherPayment.amount);
    }
}
