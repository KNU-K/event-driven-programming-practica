package com.practica.edp.domain.customer.application;

import com.practica.edp.domain.common.Money;
import com.practica.edp.domain.coupon.presentation.dto.CouponAssignedEvent;
import com.practica.edp.domain.customer.application.dto.CreateCustomerCommand;
import com.practica.edp.domain.customer.domain.Customer;
import com.practica.edp.domain.customer.infrastructure.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ApplicationEventPublisher eventPublisher;
    public Customer create(CreateCustomerCommand command){
        final Money ownedAmount = command.getOwnedAmount();

        Customer newCustomer = Customer.create(ownedAmount);

        return customerRepository.save(newCustomer);
    }

    @Transactional
    public void assignCoupon(Long id, UUID couponSerialNumber){
        eventPublisher.publishEvent(CouponAssignedEvent.of(this, id, couponSerialNumber));
    }

    public Customer findByUserId(Long id){
        return customerRepository.findById(id)
                .orElseThrow();
    }
}
