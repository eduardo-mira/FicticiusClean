package com.ficticiusclean.service;

import com.ficticiusclean.entity.VehicleInfo;
import com.ficticiusclean.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleInfo> getAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public VehicleInfo saveVehicle(VehicleInfo vehicleInfo) {
        var vInfo = this.vehicleRepository.saveAndFlush(vehicleInfo);
        return vInfo;
    }
}
