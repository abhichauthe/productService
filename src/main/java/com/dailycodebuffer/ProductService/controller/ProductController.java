package com.dailycodebuffer.ProductService.controller;

import com.dailycodebuffer.ProductService.model.ProductRequest;
import com.dailycodebuffer.ProductService.model.ProductResponse;
import com.dailycodebuffer.ProductService.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
        log.info("Product Request : " + productRequest);
        long productId =productService.addProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductId(@PathVariable("id") long productId){
        ProductResponse productResponse
                        = productService.getProductId(productId);
        return new ResponseEntity<>(productResponse , HttpStatus.OK);
    }

    @PutMapping("/reduceQuantity/{id}")                  // ✅ mapping on method
    public ResponseEntity<Void> reduceQuantity(
            @PathVariable("id") long productId,              // ✅ @PathVariable on parameter
            @RequestParam long quantity) {                   // ✅ @RequestParam on parameter
        productService.reduceQuantity(productId, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
