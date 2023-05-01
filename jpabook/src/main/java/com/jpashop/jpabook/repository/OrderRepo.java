package com.jpashop.jpabook.repository;


import com.jpashop.jpabook.domain.Order;
import com.jpashop.jpabook.domain.OrderSearch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {

    List<Order> findAllByOrderSearch(OrderSearch orderSearch);
}
