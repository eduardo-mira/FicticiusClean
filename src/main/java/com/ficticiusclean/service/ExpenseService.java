package com.ficticiusclean.service;

import com.ficticiusclean.entity.ExpenseInfo;
import com.ficticiusclean.entity.ExpenseParametersInfo;

import java.util.List;

public interface ExpenseService {

    List<ExpenseInfo> analizeExpenses(ExpenseParametersInfo expenseParamInfo, int page, int pageSize);

    List<ExpenseInfo> getLessExpensiveVehicle(ExpenseParametersInfo expenseParamInfo);

    List<ExpenseInfo> getMostExpensiveVehicle(ExpenseParametersInfo expenseParamInfo);
}
