package com.ficticiusclean.service;

import com.ficticiusclean.entity.VehicleInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface VehicleService {

    List<VehicleInfo> getAll();

    VehicleInfo saveVehicle(VehicleInfo vehicleInfo);
}
