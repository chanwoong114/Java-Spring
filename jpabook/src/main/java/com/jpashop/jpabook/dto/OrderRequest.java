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
public class OrderRequest {

    private Member member;
    private List<OrderItem> orderItems = new ArrayList<>();
    private Delivery delivery;
    private LocalDateTime orderDate;
    private OrderStatus status;

    public Order toOrder() {
        return Order.builder()
                .member(this.member)
                .orderItems(this.orderItems)
                .delivery(this.delivery)
                .orderDate(this.orderDate)
                .status(this.status).build();
    }

}
