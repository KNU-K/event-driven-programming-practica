package com.practica.edp.domain.product.application;

import com.practica.edp.domain.product.application.dto.RegisterFoodCommand;
import com.practica.edp.domain.common.Money;
import com.practica.edp.domain.product.domain.Product;
import com.practica.edp.domain.product.domain.ProductTag;
import com.practica.edp.domain.product.infrastructure.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product registerFood(RegisterFoodCommand command){
        final ProductTag tag = command.getTag();
        final String name = command.getName();
        final Money price = command.getPrice();
        final Integer quantity = command.getQuantity();

        return switch (tag){
            case CHINESE -> registerChineseFood(name, price, quantity);
            case WESTERN -> registerWesternFood(name, price, quantity);
        };
    }

    private Product registerChineseFood(String name, Money price, Integer quantity){
        Product chineseFood = Product.registerChineseFood(name, price, quantity);
        return productRepository.save(chineseFood);
    }
    private Product registerWesternFood(String name, Money price, Integer quantity){
        Product westernFood = Product.registerWesternFood(name, price, quantity);
        return productRepository.save(westernFood);
    }
}
