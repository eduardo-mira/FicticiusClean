package com.ficticiusclean.service;

import com.ficticiusclean.entity.ExpenseInfo;
import com.ficticiusclean.entity.ExpenseParametersInfo;

import java.util.List;

public interface ExpenseService {

    List<ExpenseInfo> analizeExpenses(ExpenseParametersInfo expenseParamInfo, int page, int pageSize);

    List<ExpenseInfo> getLessExpensiveFuelVehicle(ExpenseParametersInfo expenseParamInfo);

    List<ExpenseInfo> getMostExpensiveFuelVehicle(ExpenseParametersInfo expenseParamInfo);
}
