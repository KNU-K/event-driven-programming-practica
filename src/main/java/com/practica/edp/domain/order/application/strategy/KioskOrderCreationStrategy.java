package com.practica.edp.domain.order.application.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KioskOrderCreationStrategy implements OrderCreationStrategy{
    private final ApplicationEventPublisher publisher;
    @Override
    public void createOrder() {
    }
}
