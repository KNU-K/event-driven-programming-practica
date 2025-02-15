package com.practica.edp.domain.coupon.domain;

import com.practica.edp.domain.customer.domain.Customer;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "customer_coupon_rel")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class AssignedCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    public static AssignedCoupon of(Customer customer, Coupon coupon){
        AssignedCoupon assignedCoupon = AssignedCoupon.builder()
                .customer(customer)
                .coupon(coupon)
                .build();

        assignedCoupon.assign();
        return assignedCoupon;
    }

    private void assign(){
        customer.assignCoupon(this);
        coupon.assignToUser(this);
    }

    @Override
    public String toString() {
        return "AssignedCoupon{" +
                "customer=" + customer +
                ", coupon=" + coupon +
                '}';
    }
}
