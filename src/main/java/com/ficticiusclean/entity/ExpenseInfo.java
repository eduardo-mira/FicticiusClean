package com.ficticiusclean.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ExpenseInfo implements Comparable
{

    @Schema(name = "name",
            description = "Nome",
            example = "Civic",
            required = true)
    public String name;

    @Schema(name = "brand",
            description = "Marca",
            example = "Honda",
            required = true)
    public String brand;

    @Schema(name = "model",
            description = "Modelo",
            example = "Honda Civic LXR",
            required = true)
    public String model;

    @Schema(name = "yearModel",
            description = "Ano de fabricação",
            example = "2016",
            required = true)
    public int yearModel;

    @Schema(name = "totalFuelQuantity",
            description = "Quantidade de combustível gasto",
            example = "122",
            required = true)
    public BigDecimal totalFuelQuantity;

    @Schema(name = "totalFuelExpense",
            description = "Valor total gasto com combustível",
            example = "256.26",
            required = true)
    public BigDecimal totalFuelExpense;

    @Override
    public int compareTo(Object expense) {
       return this.totalFuelExpense.compareTo(((ExpenseInfo)expense).totalFuelExpense);
    }
}
