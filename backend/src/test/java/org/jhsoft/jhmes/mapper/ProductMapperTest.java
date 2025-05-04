// src/test/java/org/jhsoft/jhmes/mapper/ProductMapperTest.java
package org.jhsoft.jhmes.mapper;

import java.util.List;

import org.jhsoft.jhmes.domain.Product;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductMapperTest {

    @Autowired
    ProductMapper mapper;

    @Test
    void crudCycle() {
        // given
        Product p = new Product();
        p.setProductId("build-test-P-001");
        p.setProductName("테스트제품");
        p.setDescription("JUnit Insert");
        p.setUnit("EA");
        p.setIsActive(true);

        // 1. INSERT
        assertEquals(1, mapper.insert(p));

        // 2. SELECT ONE
        Product loaded = mapper.findById("build-test-P-001");
        assertNotNull(loaded);
        assertEquals("테스트제품", loaded.getProductName());

        // 3. UPDATE
        loaded.setProductName("수정된제품");
        mapper.update(loaded);
        assertEquals("수정된제품", mapper.findById("build-test-P-001").getProductName());

        // 4. SELECT ALL
        List<Product> all = mapper.findAll();
        assertTrue(!all.isEmpty());

        // 5. DELETE
        assertEquals(1, mapper.delete("build-test-P-001"));
        assertNull(mapper.findById("build-test-P-001"));
    }
}
