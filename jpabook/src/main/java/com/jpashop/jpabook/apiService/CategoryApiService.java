package com.jpashop.jpabook.apiService;

import com.jpashop.jpabook.domain.Category;
import com.jpashop.jpabook.dto.CategoryRequest;
import com.jpashop.jpabook.dto.CategoryResponse;
import com.jpashop.jpabook.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryApiService {

    private final CategoryRepo categoryRepo;

    @Transactional
    public CategoryResponse join(CategoryRequest categoryRequest) {
        Category save = categoryRepo.save(categoryRequest.toCategory());
        return new CategoryResponse(save);
    }

    public CategoryResponse categoryDetail(Long id) {
        return new CategoryResponse(categoryRepo.findById(id).orElseThrow());
    }
}
