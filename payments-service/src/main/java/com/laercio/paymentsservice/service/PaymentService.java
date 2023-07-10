package com.laercio.paymentsservice.service;

import com.laercio.paymentsservice.model.Payment;

public interface PaymentService {
    void sendPayment(Payment payment);
}
