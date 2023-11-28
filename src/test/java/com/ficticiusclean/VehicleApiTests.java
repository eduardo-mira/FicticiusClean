package com.ficticiusclean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ficticiusclean.entity.VehicleInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VehicleApiTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @DisplayName("Salvar novo veiculo e retornar Created - 201")
    @Test
    void addNewVehicleTest() throws Exception {
        mockMvc.perform(post("/api/vehicle/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(vehicleInfo())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.brand").value("Honda"))
                .andExpect(jsonPath("$.name").value("Civic"))
                .andExpect(jsonPath("$.model").value("Civic LXR"))
                .andExpect(jsonPath("$.fabricationDate").value("2016-04-05"))
                .andExpect(jsonPath("$.cityConsumption").value("10"))
                .andExpect(jsonPath("$.roadConsumption").value("16.4"));

    }

    @DisplayName("Buscar a lista de veiculos e retornar OK - 200")
    @Test
    void getAllVehiclesTest() throws Exception {
        mockMvc.perform(get("/api/vehicle/getAll")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].brand").value("Honda"))
                .andExpect(jsonPath("$[0].name").value("Civic"))
                .andExpect(jsonPath("$[0].model").value("Civic LXR"))
                .andExpect(jsonPath("$[0].fabricationDate").value("2016-04-05"))
                .andExpect(jsonPath("$[0].cityConsumption").value("10.0"))
                .andExpect(jsonPath("$[0].roadConsumption").value("16.4"));
    }

    @DisplayName("Chamando api não implementada - 404")
    @Test
    void getAllVehicle404Test() throws Exception {
        mockMvc.perform(get("/api/vehicle/getAllVehicle")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    private VehicleInfo vehicleInfo() {
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.name = "Civic";
        vehicleInfo.brand = "Honda";
        vehicleInfo.model = "Civic LXR";
        vehicleInfo.fabricationDate = LocalDate.of(2016,4,5);
        vehicleInfo.roadConsumption = new BigDecimal("16.4");
        vehicleInfo.cityConsumption = new BigDecimal("10");
        return vehicleInfo;
    }
}
