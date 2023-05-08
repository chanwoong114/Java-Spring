package com.jpashop.jpabook.repository;

import com.jpashop.jpabook.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepo extends JpaRepository<Category, Long> {
}
