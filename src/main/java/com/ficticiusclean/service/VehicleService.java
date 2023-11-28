package com.ficticiusclean.service;

import com.ficticiusclean.entity.VehicleInfo;

import java.util.List;


public interface VehicleService {

    List<VehicleInfo> getAll(int page, int pageSize);

    VehicleInfo saveVehicle(VehicleInfo vehicleInfo);
}
