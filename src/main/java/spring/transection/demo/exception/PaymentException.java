package spring.transection.demo.exception;

public class PaymentException extends RuntimeException{
    public PaymentException(String message){
        super(message);
    }
}
