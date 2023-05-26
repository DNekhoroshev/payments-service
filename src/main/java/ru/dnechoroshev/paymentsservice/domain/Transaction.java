package ru.dnechoroshev.paymentsservice.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Transaction {

    private String fromUser;

    private String toUser;

    private BigDecimal amount;

}
