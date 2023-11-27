package com.ficticiusclean.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ExpenseParametersInfo
{

    @Schema(name = "fuelPrice",
            description = "Preço do Combustível",
            example = "2.54")
    @NotNull(message = "Campo [fuelPrice] não pode ser nulo")
    @NotEmpty(message = "Campo [fuelPrice] não pode ser vazio")
    public BigDecimal fuelPrice;

    @Schema(name = "totalCityDistance",
            description = "Total de km que será percorrido dentro da cidade",
            example = "200")
    @NotNull(message = "Campo [totalCityDistance] não pode ser nulo")
    @NotEmpty(message = "Campo [totalCityDistance] não pode ser vazio")
    public BigDecimal totalCityDistance;

    @Schema(name= "totalRoadDistance",
            description = "Total de km que será percorrido na rodovia",
            example = "200")
    @NotNull(message = "Campo [totalRoadDistance] não pode ser nulo")
    @NotEmpty(message = "Campo [totalRoadDistance] não pode ser vazio")
    public BigDecimal totalRoadDistance;
}
