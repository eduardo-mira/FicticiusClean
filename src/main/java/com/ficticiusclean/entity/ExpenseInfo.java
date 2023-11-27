package com.ficticiusclean.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ExpenseInfo implements Comparable
{

    public String name;

    public String brand;

    public String model;

    public int yearModel;

    public BigDecimal totalFuelQuantity;

    public BigDecimal totalFuelExpense;

    @Override
    public int compareTo(Object expense) {
       return this.totalFuelExpense.compareTo(((ExpenseInfo)expense).totalFuelExpense);
    }
}
