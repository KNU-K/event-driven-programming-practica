package com.practica.edp.global.initializer;

import com.practica.edp.domain.common.Money;
import com.practica.edp.domain.coupon.application.CouponService;
import com.practica.edp.domain.coupon.application.dto.IssueCouponCommand;
import com.practica.edp.domain.coupon.domain.Coupon;
import com.practica.edp.domain.customer.application.CustomerService;
import com.practica.edp.domain.customer.application.dto.CreateCustomerCommand;
import com.practica.edp.domain.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class ApplicationInitializer implements ApplicationRunner {
    private final CouponService couponService;
    private final CustomerService customerService;
    private final List<Customer> customerList = new ArrayList<>();
    private final List<Coupon> couponList = new ArrayList<>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initializeCoupon();
        initializeCustomer();
        initializeCouponAssignment();
    }

    void initializeCoupon(){
        log.info("===initialize coupon===");

        IssueCouponCommand command = IssueCouponCommand.of(
                "쿠폰1",
                BigDecimal.valueOf(0.155),
                LocalDate.of(2025,2,16),
                LocalDate.of(2025,3,20));

        Coupon coupon = couponService.issue(command);
        couponList.add(coupon);
        log.info(coupon.toString());
    }
    void initializeCustomer(){
        log.info("===initialize customer===");
        Money ownedMoney = Money.of(30000);
        CreateCustomerCommand command = CreateCustomerCommand.of(ownedMoney);

        Customer customer = customerService.create(command);
        customerList.add(customer);
        log.info(customer.toString());
    }


    private void initializeCouponAssignment() {
        log.info("===initialize coupon assignment===");
        final Long customerId = customerList.get(0).getId();
        final UUID serialNumber = couponList.get(0).getSerialNumber();
        long startTime = System.nanoTime();
        customerService.assignCoupon(customerId, serialNumber);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;
        log.info("=== initialize coupon assignment END ({} ms) ===", duration);
    }
}
