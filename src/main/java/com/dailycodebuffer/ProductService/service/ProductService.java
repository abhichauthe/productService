package com.dailycodebuffer.ProductService.service;

import com.dailycodebuffer.ProductService.model.ProductRequest;
import com.dailycodebuffer.ProductService.model.ProductResponse;

public interface ProductService {
      ProductResponse getProductId(long productId);

    long addProduct(ProductRequest productRequest);

    void reduceQuantity(long productId, long quantity);
}
