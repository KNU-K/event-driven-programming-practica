package com.practica.edp.domain.coupon.application;

import com.practica.edp.domain.coupon.application.dto.IssueCouponCommand;
import com.practica.edp.domain.coupon.domain.AssignedCoupon;
import com.practica.edp.domain.coupon.domain.Coupon;
import com.practica.edp.domain.coupon.infrastructure.AssignedCouponRepository;
import com.practica.edp.domain.coupon.infrastructure.CouponRepository;
import com.practica.edp.domain.coupon.presentation.dto.CouponAssignedEvent;
import com.practica.edp.domain.customer.application.CustomerService;
import com.practica.edp.domain.customer.domain.Customer;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;
    private final AssignedCouponRepository assignedCouponRepository;
    private final CustomerService customerService;

    public Coupon issue(IssueCouponCommand command){
        final String name = command.getName();
        final BigDecimal discountRate = command.getDiscountRate();
        final LocalDate startDate = command.getStartDate();
        final LocalDate endDate = command.getEndDate();

        Coupon newCoupon = Coupon.issue(name, discountRate, startDate, endDate);
        return couponRepository.save(newCoupon);
    }

    @Async("asyncExecutor")
    @Transactional
    public void assignToUser(CouponAssignedEvent event) {
        final UUID serialNumber = event.getCouponSerialNumber();
        final Long customerId = event.getCustomerId();

        Coupon coupon = findCouponBySerialNumber(serialNumber);
        Customer customer = customerService.findByUserId(customerId);

        AssignedCoupon assignedCoupon = AssignedCoupon.of(customer, coupon);

        AssignedCoupon savedAssignedCoupon =  assignedCouponRepository.save(assignedCoupon);
        log.info(savedAssignedCoupon.toString());
    }


    public Coupon findCouponBySerialNumber(UUID serialNumber){
        return couponRepository.findBySerialNumber(serialNumber)
                .orElseThrow();
    }
}
