package com.jpashop.jpabook.repository;


import com.jpashop.jpabook.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item, Long> {


}
