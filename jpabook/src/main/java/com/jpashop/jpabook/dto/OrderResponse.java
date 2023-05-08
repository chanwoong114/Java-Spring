package com.jpashop.jpabook.dto;

import com.jpashop.jpabook.domain.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderResponse {
    private Long id;
    private Member member;
    private List<OrderItem> orderItems = new ArrayList<>();
    private Delivery delivery;
    private LocalDateTime orderDate;
    private OrderStatus status;

    public OrderResponse(Order order) {
        this.id = order.getId();
        this.member = order.getMember();
        this.orderItems = order.getOrderItems();
        this.delivery = order.getDelivery();
        this.orderDate = order.getOrderDate();
        this.status = order.getStatus();
    }

}
