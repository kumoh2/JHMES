// src/main/java/org/jhsoft/jhmes/domain/Product.java
package org.jhsoft.jhmes.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Product {
    private String productId;
    private String productName;
    private String unit;
    private String description;
    private Boolean isActive;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
}
