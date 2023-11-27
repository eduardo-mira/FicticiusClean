package com.ficticiusclean.controller;

import com.ficticiusclean.entity.VehicleInfo;
import com.ficticiusclean.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping(value = "/getAll")
    List<VehicleInfo> getAll() {
        return vehicleService.getAll();
    }

    @PostMapping(value = "/add")
    VehicleInfo add(@RequestBody VehicleInfo vInfo) {
        return vehicleService.saveVehicle(vInfo);
    }
}
