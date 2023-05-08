package com.jpashop.jpabook.web;

import com.jpashop.jpabook.apiService.OrderApiService;
import com.jpashop.jpabook.dto.OrderRequest;
import com.jpashop.jpabook.dto.OrderResponse;
import com.jpashop.jpabook.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderRestController {

    private OrderApiService orderApiService;
    private final OrderRepo orderRepo;

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderResponse> detail(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(orderApiService.orderDetail(id));
    }

    @PostMapping("/join/order")
    public ResponseEntity<OrderResponse> joinMember(@RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok().body(orderApiService.join(orderRequest));
    }
}
