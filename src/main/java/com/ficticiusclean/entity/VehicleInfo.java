package com.ficticiusclean.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class VehicleInfo {
    @Id
    @GeneratedValue
    private Long id;

    public String name;

    public String brand;

    public String model;

    public LocalDate fabricationDate;

    public BigDecimal cityConsumption;

    public BigDecimal roadConsumption;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
