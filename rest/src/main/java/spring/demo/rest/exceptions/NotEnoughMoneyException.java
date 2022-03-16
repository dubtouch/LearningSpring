package spring.demo.rest.exceptions;

public class NotEnoughMoneyException extends RuntimeException{
    public NotEnoughMoneyException(String bad_request) {
        super(bad_request);
    }
}
