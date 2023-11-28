package com.ficticiusclean.service;

import com.ficticiusclean.entity.VehicleInfo;
import com.ficticiusclean.repository.VehicleRepository;
import com.ficticiusclean.utils.PagebleUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleInfo> getAll(int page, int pageSize) {
        List<VehicleInfo> vehicleInfoList = vehicleRepository.findAll();
        if (page >= 0 && pageSize > 0) {
            return (List<VehicleInfo>) PagebleUtil.pagebleList(vehicleInfoList, page, pageSize);
        }
        return vehicleRepository.findAll();
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleInfo saveVehicle(VehicleInfo vehicleInfo) {
        validateVehicleInfo(vehicleInfo);
        var vInfo = this.vehicleRepository.saveAndFlush(vehicleInfo);
        return vInfo;
    }

    public void validateVehicleInfo(VehicleInfo vehicleInfo) {
        Assert.notNull(vehicleInfo.name, "Campo [name] não informado");
        Assert.notNull(vehicleInfo.brand, "Campo [brand] não informado");
        Assert.notNull(vehicleInfo.model, "Campo [model] não informado");
        Assert.notNull(vehicleInfo.fabricationDate, "Campo [fabricationDate] não informado");
        Assert.notNull(vehicleInfo.roadConsumption, "Campo [roadConsumption] não informado");
        Assert.notNull(vehicleInfo.cityConsumption, "Campo [cityConsumption] não informado");
    }

    private Pageable createPageRequestUsing(int page, int size) {
        return PageRequest.of(page, size);
    }
}
