package com.jpashop.jpabook.repository;


import com.jpashop.jpabook.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
