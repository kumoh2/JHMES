// src/main/java/org/jhsoft/jhmes/service/ProductService.java
package org.jhsoft.jhmes.service;

import java.util.List;

import org.jhsoft.jhmes.domain.Product;

public interface ProductService {
    Product create(Product product);
    Product get(String productId);
    List<Product> getAll();
    Product update(Product product);
    void delete(String productId);
}
