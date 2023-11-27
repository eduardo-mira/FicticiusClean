package com.ficticiusclean.entity;

import lombok.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ExpenseParametersInfo
{

    @NotNull(message = "Valor não pode ser nulo!")
    @Positive
    public BigDecimal fuelPrice;

    @NotNull
    @Positive
    public BigDecimal totalCityDistance;

    @NotNull
    @Positive
    public BigDecimal totalRoadDistance;
}
