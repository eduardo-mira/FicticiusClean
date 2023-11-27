package com.ficticiusclean.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ExpenseInfo implements Comparable
{

    @Schema(name = "name",
            description = "Nome",
            example = "Civic")
    @NotNull(message = "Campo [name] não pode ser nulo")
    @NotEmpty(message = "Campo [name] não pode ser vazio")
    public String name;

    @Schema(name = "brand",
            description = "Marca",
            example = "Honda")
    @NotNull(message = "Campo [brand] não pode ser nulo")
    @NotEmpty(message = "Campo [brand] não pode ser vazio")
    public String brand;

    @Schema(name = "model",
            description = "Modelo",
            example = "Honda Civic LXR")
    @NotNull(message = "Campo [model] não pode ser nulo")
    @NotEmpty(message = "Campo [model] não pode ser vazio")
    public String model;

    @Schema(name = "yearModel",
            description = "Ano de fabricação",
            example = "2016")
    @NotNull(message = "Campo [yearModel] não pode ser nulo")
    @NotEmpty(message = "Campo [yearModel] não pode ser vazio")
    public int yearModel;

    @Schema(name = "totalFuelQuantity",
            description = "Quantidade de combustível gasto",
            example = "122")
    @NotNull(message = "Campo [totalFuelQuantity] não pode ser nulo")
    @NotEmpty(message = "Campo [totalFuelQuantity] não pode ser vazio")
    public BigDecimal totalFuelQuantity;

    @Schema(name = "totalFuelExpense",
            description = "Valor total gasto com combustível",
            example = "256.26")
    @NotNull(message = "Campo [totalFuelExpense] não pode ser nulo")
    @NotEmpty(message = "Campo [totalFuelExpense] não pode ser vazio")
    public BigDecimal totalFuelExpense;

    @Override
    public int compareTo(Object expense) {
       return this.totalFuelExpense.compareTo(((ExpenseInfo)expense).totalFuelExpense);
    }
}
