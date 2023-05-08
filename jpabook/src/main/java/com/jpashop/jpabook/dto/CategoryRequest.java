package com.jpashop.jpabook.dto;

import com.jpashop.jpabook.domain.Category;
import com.jpashop.jpabook.domain.item.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CategoryRequest {

    private String name;
    private List<Item> items;
    private Category parent;
    private List<Category> child;

    public Category toCategory() {
        return Category.builder()
                .name(this.name)
                .items(this.items)
                .parent(this.parent)
                .child(this.child)
                .build();
    }
}

