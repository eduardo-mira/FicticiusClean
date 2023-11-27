package com.ficticiusclean.service;

import com.ficticiusclean.entity.VehicleInfo;
import com.ficticiusclean.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

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
