package com.ficticiusclean.controller;

import com.ficticiusclean.entity.ExpenseInfo;
import com.ficticiusclean.entity.ExpenseParametersInfo;
import com.ficticiusclean.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Operation(summary = "Informações de consumo dos veículos", description = "Retorna todas as informações de consumo dos veículos cadastrados")
    @GetMapping(value ="/analisys")
    List<ExpenseInfo> expenseAnalisys(@RequestBody ExpenseParametersInfo expenseParamInfo,
                                      @RequestParam(value = "page", defaultValue = "0" , required = false) String page,
                                      @RequestParam(value = "pageSize", defaultValue =  "0", required = false) String pageSize) {
        return expenseService.analizeExpenses(expenseParamInfo, Integer.parseInt(page), Integer.parseInt(pageSize));
    }

    @Operation(summary = "Menor custo de combustível", description = "Retorna as informações do veículo com menor gasto de combustível")
    @GetMapping(value ="/lessExpensive")
    List<ExpenseInfo> lessExpensive(@RequestBody ExpenseParametersInfo expenseParamInfo) {
        return expenseService.getLessExpensiveVehicle(expenseParamInfo);
    }

    @Operation(summary = "Maior custo de combustível", description = "Retorna as informações do veículo com maior gasto de combustível")
    @GetMapping(value ="/mostExpensive")
    List<ExpenseInfo> mostExpensive(@RequestBody ExpenseParametersInfo expenseParamInfo) {
        return expenseService.getMostExpensiveVehicle(expenseParamInfo);
    }


}
