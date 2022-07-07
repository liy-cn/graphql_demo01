package com.example.demo01;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private String skuId;
    private String name;
    private Category category;
    private StoreInfo storeInfo;
    private String mobiledesc;
}
