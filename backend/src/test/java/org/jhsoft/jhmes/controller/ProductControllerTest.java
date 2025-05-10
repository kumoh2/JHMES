// src/test/java/org/jhsoft/jhmes/controller/ProductControllerTest.java
package org.jhsoft.jhmes.controller;

import org.jhsoft.jhmes.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired MockMvc mvc;
    @Autowired ObjectMapper om;

    @Test
    void fullCrudFlow() throws Exception {
        Product p = new Product();
        p.setProductId("P-100");
        p.setProductName("MockMvc 제품");
        p.setUnit("EA");
        p.setIsActive(true);

        // 1. 생성
        mvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(p)))
           .andExpect(status().isCreated())
           .andExpect(jsonPath("$.productName").value("MockMvc 제품"));

        // 2. 단건 조회
        mvc.perform(get("/api/products/P-100"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.productId").value("P-100"));

        // 3. 수정
        p.setProductName("수정 이름");
        mvc.perform(put("/api/products/P-100")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(p)))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.productName").value("수정 이름"));

        // 4. 삭제
        mvc.perform(delete("/api/products/P-100"))
           .andExpect(status().isNoContent());
    }
}
