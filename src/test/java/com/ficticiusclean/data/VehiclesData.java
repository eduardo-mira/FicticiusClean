package com.ficticiusclean.data;

import com.ficticiusclean.entity.VehicleInfo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VehiclesData {

    public static List<VehicleInfo> getVehiclesList() {
        List<VehicleInfo> vehiclesList = new ArrayList<>();
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.name = "Civic";
        vehicleInfo.brand = "Honda";
        vehicleInfo.model = "Civic LXR";
        vehicleInfo.fabricationDate = LocalDate.of(2016,2,2);
        vehicleInfo.cityConsumption = new BigDecimal("9.2");
        vehicleInfo.roadConsumption = new BigDecimal("16.1");
        vehiclesList.add(vehicleInfo);

        vehicleInfo = new VehicleInfo();
        vehicleInfo.name = "Onix";
        vehicleInfo.brand = "Chevrolet";
        vehicleInfo.model = "Onix Premier";
        vehicleInfo.fabricationDate = LocalDate.of(2022,5,20);
        vehicleInfo.cityConsumption = new BigDecimal("12.2");
        vehicleInfo.roadConsumption = new BigDecimal("16.2");
        vehiclesList.add(vehicleInfo);

        vehicleInfo = new VehicleInfo();
        vehicleInfo.name = "Gol";
        vehicleInfo.brand = "Volkswagen";
        vehicleInfo.model = "Gol 1.0";
        vehicleInfo.fabricationDate = LocalDate.of(2008,5,20);
        vehicleInfo.cityConsumption = new BigDecimal("10");
        vehicleInfo.roadConsumption = new BigDecimal("14");
        vehiclesList.add(vehicleInfo);

        vehicleInfo = new VehicleInfo();
        vehicleInfo.name = "Uno";
        vehicleInfo.brand = "Fiat";
        vehicleInfo.model = "Uno Fire";
        vehicleInfo.fabricationDate = LocalDate.of(2010,5,20);
        vehicleInfo.cityConsumption = new BigDecimal("13");
        vehicleInfo.roadConsumption = new BigDecimal("16");
        vehiclesList.add(vehicleInfo);

        return vehiclesList;
    }

    public static List<VehicleInfo> getVehiclesListV8() {
        List<VehicleInfo> vehiclesList = getVehiclesList();

        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.name = "Corvette";
        vehicleInfo.brand = "Chevrolet";
        vehicleInfo.model = "Corvette Z06";
        vehicleInfo.fabricationDate = LocalDate.of(2018,2,2);
        vehicleInfo.cityConsumption = new BigDecimal("5.2");
        vehicleInfo.roadConsumption = new BigDecimal("10.1");
        vehiclesList.add(vehicleInfo);
        return vehiclesList;
    }

    public static VehicleInfo getVehicleInfo() {
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.name = "Civic";
        vehicleInfo.brand = "Honda";
        vehicleInfo.model = "Civic LXR";
        vehicleInfo.fabricationDate = LocalDate.of(2016,4,5);
        vehicleInfo.roadConsumption = new BigDecimal("16.4");
        vehicleInfo.cityConsumption = new BigDecimal("10");
        return vehicleInfo;
    }
}
