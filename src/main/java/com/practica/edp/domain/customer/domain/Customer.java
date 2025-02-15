package com.practica.edp.domain.customer.domain;

import com.practica.edp.domain.common.Money;
import com.practica.edp.domain.coupon.domain.AssignedCoupon;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "customers")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Embedded
    private Money ownedAmount;

    @OneToMany
    private List<AssignedCoupon> assignedCoupon;

    public static Customer create(Money ownedAmount){
        return Customer.builder()
                .ownedAmount(ownedAmount)
                .build();
    }

    public void assignCoupon(AssignedCoupon assignedCoupon) {
        this.assignedCoupon.add(assignedCoupon);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ownedAmount=" + ownedAmount +
                '}';
    }
}
