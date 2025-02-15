package com.practica.edp.domain.coupon.domain;

import com.practica.edp.domain.customer.domain.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "coupons")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private UUID serialNumber;
    private String name;
    private BigDecimal discountRate;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany
    @Builder.Default
    private List<AssignedCoupon> assignedCoupons = new ArrayList<>();

    public static Coupon issue(String name, BigDecimal discountRate, LocalDate startDate, LocalDate endDate){
        return Coupon.builder()
                .serialNumber(generateSerialNumber())
                .name(name)
                .discountRate(discountRate)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
    private static UUID generateSerialNumber(){
        return UUID.randomUUID();
    }

    public void assignToUser(AssignedCoupon assignedCoupon) {
        assignedCoupons.add(assignedCoupon);
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "serialNumber=" + serialNumber +
                ", name='" + name + '\'' +
                ", discountRate=" + discountRate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
