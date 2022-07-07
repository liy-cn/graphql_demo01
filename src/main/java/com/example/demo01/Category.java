package com.example.demo01;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {
    private String categoryId;
    private String categoryName;
    private String parentCategoryId;
}
