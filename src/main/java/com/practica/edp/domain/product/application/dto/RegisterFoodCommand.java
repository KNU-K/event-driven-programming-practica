package com.practica.edp.domain.product.application.dto;

import com.practica.edp.domain.common.Money;
import com.practica.edp.domain.product.domain.ProductTag;
import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterFoodCommand {
    private ProductTag tag;
    private String name;
    private Money price;
    private Integer quantity;

    public static RegisterFoodCommand of(ProductTag tag,
                                         String name,
                                         Money price,
                                         Integer quantity) {
        return RegisterFoodCommand.builder()
                .tag(tag)
                .name(name)
                .price(price)
                .quantity(quantity)
                .build();
    }
}
