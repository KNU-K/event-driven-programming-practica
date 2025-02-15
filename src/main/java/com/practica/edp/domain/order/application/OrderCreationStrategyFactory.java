package com.practica.edp.domain.order.application;

import com.practica.edp.domain.order.application.dto.OrderType;
import com.practica.edp.domain.order.application.strategy.KioskOrderCreationStrategy;
import com.practica.edp.domain.order.application.strategy.MobileOrderCreationStrategy;
import com.practica.edp.domain.order.application.strategy.OrderCreationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCreationStrategyFactory {

    private final KioskOrderCreationStrategy kioskOrderCreationStrategy;
    private final MobileOrderCreationStrategy mobileOrderCreationStrategy;


    public OrderCreationStrategy getStrategy(OrderType type) {
        return switch (type) {
            case KIOSK -> kioskOrderCreationStrategy;
            case MOBILE -> mobileOrderCreationStrategy;
        };
    }
}

