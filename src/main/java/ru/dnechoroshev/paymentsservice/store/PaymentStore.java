package ru.dnechoroshev.paymentsservice.store;

import org.springframework.stereotype.Repository;
import ru.dnechoroshev.paymentsservice.domain.UserPayment;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PaymentStore {
    private Map<String, UserPayment> payments;

    public void initPaymentStore() {
        payments = new HashMap<>();
    }

    public void addOnePayment(String userName, String sum) {
        UserPayment currentUserPayment = payments.getOrDefault(userName, new UserPayment(userName, BigDecimal.ZERO));
        currentUserPayment.addAmount(new BigDecimal(sum));
        payments.putIfAbsent(userName, currentUserPayment);
    }

    public void addTotalPayments(String userName, String sum) {
        payments.put(userName, new UserPayment(userName, new BigDecimal(sum)));
    }
    public Map<String, UserPayment> getPayments() {
        return payments;
    }

}
