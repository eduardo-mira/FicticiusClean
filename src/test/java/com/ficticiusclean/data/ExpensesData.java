package com.ficticiusclean.data;

import com.ficticiusclean.entity.ExpenseParametersInfo;

import java.math.BigDecimal;

public class ExpensesData {

    public static ExpenseParametersInfo getExpenseParam() {
        ExpenseParametersInfo expenseParametersInfo = new ExpenseParametersInfo();
        expenseParametersInfo.fuelPrice = new BigDecimal("5.59");
        expenseParametersInfo.totalRoadDistance = new BigDecimal("79.5");
        expenseParametersInfo.totalCityDistance = new BigDecimal("50");
        return expenseParametersInfo;
    }
}
