package com.ficticiusclean.data;

import com.ficticiusclean.entity.ExpenseInfo;
import com.ficticiusclean.entity.ExpenseParametersInfo;

import java.math.BigDecimal;

public class ExpensesParamsData {

    public static ExpenseParametersInfo getDefaultExpenseParam() {
        ExpenseParametersInfo expenseParametersInfo = new ExpenseParametersInfo();
        expenseParametersInfo.fuelPrice = new BigDecimal("5.25");
        expenseParametersInfo.totalCityDistance = new BigDecimal("100");
        expenseParametersInfo.totalRoadDistance = new BigDecimal("200");
        return expenseParametersInfo;
    }
}
