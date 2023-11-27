package com.ficticiusclean.entity;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(name = "id",
            description = "Identificador do registro",
            example = "1",
            hidden = true)
    private Long id;

    @Schema(name = "name",
            description = "Nome",
            example = "Civic",
            required = true)
    public String name;

    @Schema(name = "brand",
            description = "Marca",
            example = "Honda",
            required = true)
    public String brand;

    @Schema(name = "model",
            description = "Modelo",
            example = "Honda Civic LXR",
            required = true)
    public String model;

    @Schema(name = "fabricationDate",
            description = "Data de fabricação",
            example = "2016-02-03",
            required = true)
    public LocalDate fabricationDate;

    @Schema(name = "cityConsumption",
            description = "Consumo Médio de combustível dentro de cidade (KM/L)",
            example = "12.2",
            required = true)
    public BigDecimal cityConsumption;

    @Schema(name = "roadConsumption",
            description = "Consumo Médio de combustível em rodovias (KM/L)",
            example = "12.6",
            required = true)
    public BigDecimal roadConsumption;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
