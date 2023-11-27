package com.ficticiusclean.service;

import com.ficticiusclean.entity.VehicleInfo;

import java.util.List;


public interface VehicleService {

    List<VehicleInfo> getAll();

    VehicleInfo saveVehicle(VehicleInfo vehicleInfo);
}
