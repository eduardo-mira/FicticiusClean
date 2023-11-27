package com.ficticiusclean.controller;

import com.ficticiusclean.entity.VehicleInfo;
import com.ficticiusclean.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping("/getAll")
    List<VehicleInfo> getAll() {
        return vehicleService.getAll();
    }

    @PostMapping("/add")
    ResponseEntity<VehicleInfo> add(@RequestBody VehicleInfo vInfo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.saveVehicle(vInfo));
    }
}
