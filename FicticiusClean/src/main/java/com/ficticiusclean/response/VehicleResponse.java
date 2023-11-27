package com.ficticiusclean.response;

import com.ficticiusclean.entity.VehicleInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Getter
@Setter
public class VehicleResponse {

    private Long id;
    private String name;
    private String model;
    private String brand;
    private LocalDate fabricationDate;
    private BigDecimal cityConsumption;
    private BigDecimal roadConsumption;

    public VehicleResponse(VehicleInfo vehicleInfo) {
        this.id = vehicleInfo.getId();
        this.name = vehicleInfo.getName();
        this.model = vehicleInfo.getModel();
        this.brand = vehicleInfo.getBrand();
        this.fabricationDate = vehicleInfo.getFabricationDate();
        this.cityConsumption = vehicleInfo.getCityConsumption().setScale(2, RoundingMode.CEILING);
        this.roadConsumption = vehicleInfo.getRoadConsumption().setScale(2, RoundingMode.CEILING);
    }
}
