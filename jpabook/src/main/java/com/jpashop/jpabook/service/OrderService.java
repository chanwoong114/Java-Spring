package com.jpashop.jpabook.service;

import com.jpashop.jpabook.domain.*;
import com.jpashop.jpabook.domain.item.Item;
import com.jpashop.jpabook.repository.ItemRepo;
import com.jpashop.jpabook.repository.MemberRepo;
import com.jpashop.jpabook.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final MemberRepo memberRepo;
    private final OrderRepo orderRepo;
    private final ItemRepo itemRepo;

    // 주문 //
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {

        // 엔티티 조회
        Member member = memberRepo.findById(memberId).orElseThrow();
        Item item = itemRepo.findById(itemId).orElseThrow();

        // 배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);

        // 주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        // 주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        // 주문 저장
        orderRepo.save(order);
        return order.getId();
    }

    // 주문 취소 //
    @Transactional
    public void cancelOrder(Long orderId){

        // 주문 엔티티 조회
        Order order = orderRepo.findById(orderId).orElseThrow();

        // 주문 취소
        order.cancel();
    }
}
