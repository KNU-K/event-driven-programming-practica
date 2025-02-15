package com.practica.edp.domain.product.domain;

import com.practica.edp.domain.common.Money;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name="products")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Money price;

    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private ProductTag productTag;

    public static Product registerChineseFood(String name, Money price, Integer quantity){
        return Product.builder()
                .name(name)
                .quantity(quantity)
                .price(price)
                .productTag(ProductTag.CHINESE)
                .build();
    }

    public static Product registerWesternFood(String name, Money price, Integer quantity){
        return Product.builder()
                .name(name)
                .price(price)
                .quantity(quantity)
                .productTag(ProductTag.WESTERN)
                .build();
    }
}
