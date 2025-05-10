// src/main/java/org/jhsoft/jhmes/service/impl/ProductServiceImpl.java
package org.jhsoft.jhmes.service.impl;

import java.util.List;

import org.jhsoft.jhmes.domain.Product;
import org.jhsoft.jhmes.mapper.ProductMapper;
import org.jhsoft.jhmes.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper mapper;

    @Override
    @Transactional
    public Product create(Product p) {
        mapper.insert(p);
        return mapper.findById(p.getProductId());
    }

    @Override
    @Transactional(readOnly = true)
    public Product get(String id) {
        return mapper.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return mapper.findAll();
    }

    @Override
    @Transactional
    public Product update(Product p) {
        mapper.update(p);
        return mapper.findById(p.getProductId());
    }

    @Override
    @Transactional
    public void delete(String id) {
        mapper.delete(id);
    }
}
