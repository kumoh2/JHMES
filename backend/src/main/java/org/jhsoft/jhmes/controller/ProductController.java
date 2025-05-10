// src/main/java/org/jhsoft/jhmes/controller/ProductController.java
package org.jhsoft.jhmes.controller;

import java.util.List;

import org.jhsoft.jhmes.domain.Product;
import org.jhsoft.jhmes.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /** 목록 조회 */
    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    /** 단건 조회 */
    @GetMapping("/{code}")
    public Product get(@PathVariable String code) {
        return productService.get(code);
    }

    /** 등록 */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    /** 수정 */
    @PutMapping("/{code}")
    public Product update(@PathVariable String code,
                          @RequestBody Product product) {
        product.setProductId(code);
        return productService.update(product);
    }

    /** 삭제 */
    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String code) {
        productService.delete(code);
    }
}
