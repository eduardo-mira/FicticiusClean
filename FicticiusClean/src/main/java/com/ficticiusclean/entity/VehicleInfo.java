package com.ficticiusclean.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Data
@Table(name = "veiculo")
@Entity
public class VehicleInfo {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
