package com.ficticiusclean.controller;

import com.ficticiusclean.entity.ExpenseInfo;
import com.ficticiusclean.entity.ExpenseParametersInfo;
import com.ficticiusclean.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping(value ="/analisys")
    List<ExpenseInfo> expenseAnalisys(@RequestBody ExpenseParametersInfo expenseParamInfo) {
        return expenseService.analizeExpenses(expenseParamInfo);
    }


}
