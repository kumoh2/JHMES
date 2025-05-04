// src/main/java/org/jhsoft/jhmes/mapper/ProductMapper.java
package org.jhsoft.jhmes.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.jhsoft.jhmes.domain.Product;

@Mapper
public interface ProductMapper {
    int insert(Product product);
    Product findById(String productId);
    List<Product> findAll();
    int update(Product product);
    int delete(String productId);
}
