package com.ficticiusclean.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExpensesCalc {
    public static BigDecimal getTotalFuelConsumption(BigDecimal distance, BigDecimal vehicleConsumption) {
         return BigDecimal.valueOf(distance.doubleValue()/vehicleConsumption.doubleValue()).setScale(2,RoundingMode.HALF_EVEN);
    }

    public static BigDecimal getTotalPrice(BigDecimal totalFuel, BigDecimal fuelPrice) {
        return BigDecimal.valueOf(totalFuel.doubleValue()*fuelPrice.doubleValue()).setScale(2,RoundingMode.HALF_EVEN);
    }
}
