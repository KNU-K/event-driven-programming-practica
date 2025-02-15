package com.practica.edp.domain.coupon.presentation.dto;

import com.practica.edp.domain.customer.domain.Customer;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.UUID;

@Getter
public class CouponAssignedEvent extends ApplicationEvent {
    private final Long customerId;
    private final UUID couponSerialNumber;

    public CouponAssignedEvent(Object source, Long customerId, UUID couponSerialNumber) {
        super(source);
        this.customerId = customerId;
        this.couponSerialNumber = couponSerialNumber;
    }
    public static CouponAssignedEvent of(Object source, Long customerId, UUID couponSerialNumber) {
        return new CouponAssignedEvent(source, customerId, couponSerialNumber);
    }
}

