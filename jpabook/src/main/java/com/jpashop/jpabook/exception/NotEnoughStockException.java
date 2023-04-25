package com.jpashop.jpabook.exception;

public class NotEnoughStockException extends RuntimeException {

    public NotEnoughStockException(){
        super("재고가 부족합니다.");
    }

    public NotEnoughStockException(String message) {
        super(message);
    }

    public NotEnoughStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughStockException(Throwable cause) {
        super(cause);
    }
}
