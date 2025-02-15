package com.practica.edp.domain.customer.application.dto;

import com.practica.edp.domain.common.Money;
import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateCustomerCommand {
    private Money ownedAmount;

    public static CreateCustomerCommand of(Money ownedAmount){
        return CreateCustomerCommand.builder()
                .ownedAmount(ownedAmount)
                .build();
    }
}
