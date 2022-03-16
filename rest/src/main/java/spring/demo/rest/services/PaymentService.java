package spring.demo.rest.services;


import org.springframework.stereotype.Service;
import spring.demo.rest.exceptions.NotEnoughMoneyException;
import spring.demo.rest.models.PaymentDetails;

@Service
public class PaymentService {


    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException("bad request");
    }
}
