package com.jpashop.jpabook.dto;

import com.jpashop.jpabook.domain.Address;
import com.jpashop.jpabook.domain.Member;
import com.jpashop.jpabook.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberRequest {

    private String name;

    private Address address;

    private List<Order> orders = new ArrayList<>();

    public Member toMember() {
        return Member.builder()
                .name(this.name)
                .address(this.address)
                .orders(this.orders)
                .build();
    }
}
