package hello.core.service;

import hello.core.order.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemname, int itemPrice);






}
