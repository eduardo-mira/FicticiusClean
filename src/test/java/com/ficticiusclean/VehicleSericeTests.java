package com.ficticiusclean;

import com.ficticiusclean.data.VehiclesData;
import com.ficticiusclean.entity.VehicleInfo;
import com.ficticiusclean.repository.VehicleRepository;
import com.ficticiusclean.service.VehicleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class VehicleSericeTests {

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @Mock
    private VehicleRepository vehicleRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.vehicleService = new VehicleServiceImpl(this.vehicleRepository);
    }

    @Test
    void listVehicles() {
        doReturn(VehiclesData.getVehiclesList()).when(vehicleRepository).findAll();
        List<VehicleInfo> vehicleInfoList = vehicleService.getAll(-1,-1);
        assertEquals(vehicleInfoList.size(), 4);
    }

}
