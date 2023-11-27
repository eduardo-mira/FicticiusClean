package com.ficticiusclean.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
            example = "Civic")
    @NotNull(message = "Campo [name] não pode ser nulo")
    @NotEmpty(message = "Campo [name] não pode ser vazio")
    public String name;

    @Schema(name = "brand",
            description = "Marca",
            example = "Honda")
    @NotNull(message = "Campo [brand] não pode ser nulo")
    @NotEmpty(message = "Campo [brand] não pode ser vazio")
    public String brand;

    @Schema(name = "model",
            description = "Modelo",
            example = "Honda Civic LXR")
    @NotNull(message = "Campo [model] não pode ser nulo")
    @NotEmpty(message = "Campo [model] não pode ser vazio")
    public String model;

    @Schema(name = "fabricationDate",
            description = "Data de fabricação",
            example = "2016-02-03")
    @NotNull(message = "Campo [fabricationDate] não pode ser nulo")
    @NotEmpty(message = "Campo [fabricationDate] não pode ser vazio")
    public LocalDate fabricationDate;

    @Schema(name = "cityConsumption",
            description = "Consumo Médio de combustível dentro de cidade (KM/L)",
            example = "12.2")
    @NotNull(message = "Campo [cityConsumption] não pode ser nulo")
    @NotEmpty(message = "Campo [cityConsumption] não pode ser vazio")
    public BigDecimal cityConsumption;

    @Schema(name = "roadConsumption",
            description = "Consumo Médio de combustível em rodovias (KM/L)",
            example = "12.6")
    @NotNull(message = "Campo [roadConsumption] não pode ser nulo")
    @NotEmpty(message = "Campo [roadConsumption] não pode ser vazio")
    public BigDecimal roadConsumption;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
