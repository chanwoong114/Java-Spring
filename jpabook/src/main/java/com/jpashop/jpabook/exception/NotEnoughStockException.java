package com.jpashop.jpabook.exception;

public class NotEnoughStockException extends RuntimeException {

    public NotEnoughStockException(){
        super("재고가 부족합니다.");
    }

}
