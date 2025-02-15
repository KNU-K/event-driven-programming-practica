package com.practica.edp.domain.coupon.application.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class IssueCouponCommand {
    private String name;
    private BigDecimal discountRate;
    private LocalDate startDate;
    private LocalDate endDate;

    public static IssueCouponCommand of(
            String name,
            BigDecimal discountRate,
            LocalDate startDate,
            LocalDate endDate
    ){
        return IssueCouponCommand.builder()
                .name(name)
                .discountRate(discountRate)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
