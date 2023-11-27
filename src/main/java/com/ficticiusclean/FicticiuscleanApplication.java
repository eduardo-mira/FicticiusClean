package com.ficticiusclean;

import com.ficticiusclean.entity.VehicleInfo;
import com.ficticiusclean.repository.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class FicticiuscleanApplication {

	public static void main(String[] args) {
		SpringApplication.run(FicticiuscleanApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(VehicleRepository vehicleRepository) throws Exception {
		return args -> {
			VehicleInfo vehicleInfo = new VehicleInfo();
			vehicleInfo.name = "Civic";
			vehicleInfo.brand = "Honda";
			vehicleInfo.model = "Civic LXR";
			vehicleInfo.fabricationDate = LocalDate.of(2016,4,5);
			vehicleInfo.roadConsumption = new BigDecimal("16.4");
			vehicleInfo.cityConsumption = new BigDecimal("10");
			vehicleRepository.save(vehicleInfo);

			vehicleInfo = new VehicleInfo();
			vehicleInfo.name = "Fusca";
			vehicleInfo.brand = "Volkswagen";
			vehicleInfo.model = "Fusca 1500";
			vehicleInfo.fabricationDate = LocalDate.of(1975,4,5);
			vehicleInfo.roadConsumption = new BigDecimal("12");
			vehicleInfo.cityConsumption = new BigDecimal("8");
			vehicleRepository.save(vehicleInfo);

			vehicleInfo = new VehicleInfo();
			vehicleInfo.name = "Uno";
			vehicleInfo.brand = "Fiat";
			vehicleInfo.model = "Uno Mille";
			vehicleInfo.fabricationDate = LocalDate.of(2003,4,5);
			vehicleInfo.roadConsumption = new BigDecimal("16");
			vehicleInfo.cityConsumption = new BigDecimal("12");
			vehicleRepository.save(vehicleInfo);
		};
	}

}
