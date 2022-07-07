package com.example.demo01;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class ProductDatafetcher {

    private final List<Product> products = generateMockData();

    private List<Product> generateMockData() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            productList.add(Product.builder()
                    .skuId("sku" + i).name("name" + i).mobiledesc("desc" + i)
                    .category(Category.builder().categoryId("category_" + i).categoryName("category" + i).parentCategoryId("parent" + i).build())
                    .storeInfo(StoreInfo.builder().storeId(Integer.valueOf(i)).storeName("storeName" + i).outerId("outerId" + i).build())
                    .build());
        }
        return productList;
    }


    //@DgsQuery
    @DgsData(parentType = "Query")
    public List<Product> products(@InputArgument String skuIdFilter) {
        if (skuIdFilter == null) {
            return products;
        }

        return products.stream().filter(s -> s.getSkuId().contains(skuIdFilter)).collect(Collectors.toList());
    }
}

