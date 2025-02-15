package com.practica.edp.domain.coupon.presentation;

import com.practica.edp.domain.coupon.application.CouponService;
import com.practica.edp.domain.coupon.presentation.dto.CouponAssignedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class CouponEventListener {
    private final CouponService couponService;
    @EventListener
    public void onAssignCoupon(CouponAssignedEvent event){
        couponService.assignToUser(event);
    }
}
