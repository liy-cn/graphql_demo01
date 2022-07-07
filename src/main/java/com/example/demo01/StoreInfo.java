package com.example.demo01;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoreInfo {
    private Integer storeId;
    private String storeName;
    private String outerId;
}
