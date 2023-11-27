package com.ficticiusclean;

import com.ficticiusclean.data.ExpensesParamsData;
import com.ficticiusclean.data.VehiclesData;
import com.ficticiusclean.entity.ExpenseInfo;
import com.ficticiusclean.entity.ExpenseParametersInfo;
import com.ficticiusclean.repository.VehicleRepository;
import com.ficticiusclean.service.ExpenseServiceImpl;
import com.ficticiusclean.service.VehicleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class ExpenseSericeTests {

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @InjectMocks
    private ExpenseServiceImpl expenseService;

    @Mock
    private VehicleRepository vehicleRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.vehicleService = new VehicleServiceImpl(this.vehicleRepository);
        this.expenseService = new ExpenseServiceImpl(this.vehicleRepository);
    }

    @Test
    void listVehicles() {
        doReturn(VehiclesData.getVehiclesList()).when(vehicleRepository).findAll();
        List<ExpenseInfo> expenseInfoList = expenseService.analizeExpenses(ExpensesParamsData.getDefaultExpenseParam());
        assertEquals(expenseInfoList.size(), 4);
    }

    @Test
    void getLessExpensive() {
        doReturn(VehiclesData.getVehiclesList()).when(vehicleRepository).findAll();
        List<ExpenseInfo> lessExpensiveVehicleList = expenseService.getLessExpensiveVehicle(ExpensesParamsData.getDefaultExpenseParam());
        assertEquals(lessExpensiveVehicleList.get(0).name, "Uno");
        assertEquals(lessExpensiveVehicleList.get(0).yearModel, 2010);
        assertEquals(lessExpensiveVehicleList.get(0).totalFuelQuantity, new BigDecimal("7.69"));
        assertEquals(lessExpensiveVehicleList.get(0).totalFuelExpense, new BigDecimal("40.37"));
    }

    @Test
    void getMostExpensive() {
        doReturn(VehiclesData.getVehiclesListV8()).when(vehicleRepository).findAll();
        List<ExpenseInfo> expenseInfoList = expenseService.analizeExpenses(ExpensesParamsData.getDefaultExpenseParam());
        assertEquals(expenseInfoList.get(expenseInfoList.size()-1).name, "Corvette");
    }

    @Test
    void withoutFuelPrice() {
        doReturn(VehiclesData.getVehiclesList()).when(vehicleRepository).findAll();
        ExpenseParametersInfo expenseParametersInfo = ExpensesParamsData.getDefaultExpenseParam();
        expenseParametersInfo.fuelPrice = null;
        assertThrows(IllegalArgumentException.class, () -> expenseService.getLessExpensiveVehicle(expenseParametersInfo));
    }
}
