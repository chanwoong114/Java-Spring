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
public class CategoryResponse {

    private Long id;
    private String name;
    private List<Item> items;
    private Category parent;
    private List<Category> child;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.items = category.getItems();
        this.parent = category.getParent();
        this.child = category.getChild();
    }

}
