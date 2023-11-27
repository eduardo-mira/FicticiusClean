package com.ficticiusclean.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Positive;
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
            example = "2.54",
            required = true)
    public BigDecimal fuelPrice;

    //@NotNull
    //@Positive
    @Schema(name = "totalCityDistance",
            description = "Total de km que será percorrido dentro da cidade",
            example = "200",
            required = true)
    public BigDecimal totalCityDistance;

    //@NotNull
    //@Positive
    @Schema(name= "totalRoadDistance",
            description = "Total de km que será percorrido na rodovia",
            example = "200",
            required = true)
    public BigDecimal totalRoadDistance;
}
