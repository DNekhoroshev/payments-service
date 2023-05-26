package ru.dnechoroshev.paymentsservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dnechoroshev.paymentsservice.domain.Transaction;
import ru.dnechoroshev.paymentsservice.domain.UserPayment;
import ru.dnechoroshev.paymentsservice.store.PaymentStore;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentCalculationService {
    private final PaymentStore paymentStore;

    public List<Transaction> calculateTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        Map<String, UserPayment> userPayments = paymentStore.getPayments();

        Deque<UserPayment> upDeq = userPayments
                .values()
                .stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayDeque::new));

        return transactions;
    }

}
