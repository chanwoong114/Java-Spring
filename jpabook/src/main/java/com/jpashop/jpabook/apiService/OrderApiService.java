package com.jpashop.jpabook.apiService;

import com.jpashop.jpabook.domain.Order;
import com.jpashop.jpabook.dto.OrderRequest;
import com.jpashop.jpabook.dto.OrderResponse;
import com.jpashop.jpabook.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderApiService {

    private final OrderRepo orderRepo;

    @Transactional
    public OrderResponse join(OrderRequest orderRequest) {
        Order save = orderRepo.save(orderRequest.toOrder());

        return new OrderResponse(save);
    }

    public OrderResponse orderDetail(Long id) {
        return new OrderResponse(orderRepo.findById(id).orElseThrow());
    }
}
