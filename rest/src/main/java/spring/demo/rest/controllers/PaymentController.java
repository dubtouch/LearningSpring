package spring.demo.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.demo.rest.exceptions.NotEnoughMoneyException;
import spring.demo.rest.models.ErrorDetails;
import spring.demo.rest.models.PaymentDetails;
import spring.demo.rest.services.PaymentService;

import java.util.logging.Logger;

@RestController
public class PaymentController {

    private static Logger logger = Logger.getLogger(PaymentController.class.getName());

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment(@RequestBody PaymentDetails paymentDetails) {
        logger.info("Received amount " + paymentDetails.getAmount());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetails);
    }
}
