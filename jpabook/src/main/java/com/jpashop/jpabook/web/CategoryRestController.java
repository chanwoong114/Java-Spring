package com.jpashop.jpabook.web;

import com.jpashop.jpabook.apiService.CategoryApiService;
import com.jpashop.jpabook.dto.CategoryRequest;
import com.jpashop.jpabook.dto.CategoryResponse;
import com.jpashop.jpabook.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CategoryRestController {

    private final CategoryApiService categoryApiService;
    private final CategoryRepo categoryRepo;

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryResponse> detail(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(categoryApiService.categoryDetail(id));
    }

    @PostMapping("/joincategory")
    public ResponseEntity<CategoryResponse> joinCategory(@RequestBody CategoryRequest categoryRequest) {
        return ResponseEntity.ok().body(categoryApiService.join(categoryRequest));
    }
}
