package com.ficticiusclean.service;

import com.ficticiusclean.entity.ExpenseInfo;
import com.ficticiusclean.entity.ExpenseParametersInfo;
import com.ficticiusclean.entity.VehicleInfo;
import com.ficticiusclean.repository.VehicleRepository;
import com.ficticiusclean.utils.ExpensesCalc;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final VehicleRepository vehicleRepository;

    public ExpenseServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<ExpenseInfo> analizeExpenses(ExpenseParametersInfo expenseParamInfo) {
        List<ExpenseInfo> expenseInfoList = getExpenseInfoList(expenseParamInfo);
        return expenseInfoList.stream().sorted().toList();
    }

    @Override
    public List<ExpenseInfo> getLessExpensiveVehicle(ExpenseParametersInfo expenseParamInfo) {
        List<ExpenseInfo> expenseInfoList = getExpenseInfoList(expenseParamInfo);
        ExpenseInfo lessExpensive = expenseInfoList.stream().sorted().toList().get(0);
        return expenseInfoList.stream().filter(info -> info.totalFuelExpense.equals(lessExpensive.totalFuelExpense)).toList();
    }

    public List<ExpenseInfo> getMostExpensiveVehicle(ExpenseParametersInfo expenseParamInfo) {
        List<ExpenseInfo> expenseInfoList = getExpenseInfoList(expenseParamInfo);
        Collections.sort(expenseInfoList, Comparator.comparing(ExpenseInfo::getTotalFuelExpense));
        ExpenseInfo mostExpensive = expenseInfoList.stream().sorted().toList().get(0);
        return expenseInfoList.stream().filter(info -> info.totalFuelExpense.equals(mostExpensive.totalFuelExpense)).toList();
    }

    private List<ExpenseInfo> getExpenseInfoList(ExpenseParametersInfo expenseParamInfo) {
        validateParams(expenseParamInfo);

        List<ExpenseInfo> expenseInfoList = new ArrayList<>();
        BigDecimal totalConsumption = BigDecimal.ZERO;

        for(VehicleInfo vehicleInfo : vehicleRepository.findAll()) {
            ExpenseInfo expenseInfo = new ExpenseInfo();
            expenseInfo.brand = vehicleInfo.brand;
            expenseInfo.name = vehicleInfo.name;
            expenseInfo.model = vehicleInfo.model;
            expenseInfo.yearModel = vehicleInfo.fabricationDate.getYear();
            totalConsumption = ExpensesCalc.getTotalFuelConsumption(expenseParamInfo.totalCityDistance,vehicleInfo.cityConsumption);
            totalConsumption.add(ExpensesCalc.getTotalFuelConsumption(expenseParamInfo.totalRoadDistance,vehicleInfo.roadConsumption));
            expenseInfo.totalFuelQuantity =  totalConsumption;
            expenseInfo.totalFuelExpense = ExpensesCalc.getTotalPrice(totalConsumption, expenseParamInfo.fuelPrice);
            expenseInfoList.add(expenseInfo);
        }

        return expenseInfoList;
    }

    public void validateParams(ExpenseParametersInfo expenseParamInfo) {
        Assert.notNull(expenseParamInfo.fuelPrice, "Campo [fuelPrice] não pode ser nulo");
        Assert.notEmpty(Collections.singleton(expenseParamInfo.fuelPrice), "Campo [fuelPrice] vazio");
        Assert.notNull(expenseParamInfo.totalCityDistance, "Campo [totalCityDistance] não pode ser nulo");
        Assert.notEmpty(Collections.singleton(expenseParamInfo.totalCityDistance), "Campo [totalCityDistance] vazio");
        Assert.notNull(expenseParamInfo.totalRoadDistance, "Campo [totalRoadDistance] não pode ser nulo");
        Assert.notEmpty(Collections.singleton(expenseParamInfo.totalRoadDistance), "Campo [totalRoadDistance] vazio");
    }

}
