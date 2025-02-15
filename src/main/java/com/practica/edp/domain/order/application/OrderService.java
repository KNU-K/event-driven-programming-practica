package com.practica.edp.domain.order.application;

import com.practica.edp.domain.order.application.dto.OrderType;
import com.practica.edp.domain.order.application.strategy.OrderCreationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderCreationStrategyFactory strategyFactory;

    public void createOrder(OrderType type) {
        OrderCreationStrategy strategy = strategyFactory.getStrategy(type);
        strategy.createOrder();
    }
}
