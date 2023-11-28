package com.ficticiusclean.controller;

import com.ficticiusclean.entity.VehicleInfo;
import com.ficticiusclean.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @Operation(summary = "Retorna todos os veículos", description = "Retorna todos os veículos cadastrados no banco")

    @GetMapping(value = "/getAll")
    List<VehicleInfo> getAll(@RequestParam(value = "page", defaultValue = "0" , required = false) String page,
                             @RequestParam(value = "pageSize", defaultValue =  "0", required = false) String pageSize) {

        return vehicleService.getAll(Integer.parseInt(page), Integer.parseInt(pageSize));
    }

    @Operation(summary = "Adiciona novo veículo", description = "Adiciona um novo veículo ao cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/add")
    VehicleInfo add(@RequestBody VehicleInfo vInfo) {
        return vehicleService.saveVehicle(vInfo);
    }
}
