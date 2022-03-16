package controllers;

import models.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import proxy.PaymentsProxy;

import java.util.UUID;

@RestController
public class PaymentController {
    private final PaymentsProxy proxy;

    public PaymentController(PaymentsProxy proxy) {
        this.proxy = proxy;
    }
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {
        System.out.println("haha");
        String requestId = UUID.randomUUID().toString();
        return proxy.createPayment(requestId, payment);
    }
}
