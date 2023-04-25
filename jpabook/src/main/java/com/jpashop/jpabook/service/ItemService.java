package com.jpashop.jpabook.service;

import com.jpashop.jpabook.domain.item.Item;
import com.jpashop.jpabook.repository.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepo itemRepo;

    @Transactional
    public void saveItem(Item item) {
        itemRepo.save(item);
    }

    public List<Item> findItems() {
        return itemRepo.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepo.findById(itemId).orElseThrow(); // 예외를 바로 체크
    }
}
