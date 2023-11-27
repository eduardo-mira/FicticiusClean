package com.ficticiusclean.controller;

import com.ficticiusclean.entity.ExpenseInfo;
import com.ficticiusclean.entity.ExpenseParametersInfo;
import com.ficticiusclean.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {

    private final ExpenseService expenseService;

    @GetMapping("/analisys")
    List<ExpenseInfo> expenseAnalisys(@RequestBody ExpenseParametersInfo expenseParamInfo) {
        return expenseService.analizeExpenses(expenseParamInfo);
    }


}
