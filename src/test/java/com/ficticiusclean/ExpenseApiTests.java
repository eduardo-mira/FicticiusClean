package com.ficticiusclean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ficticiusclean.data.ExpensesData;
import com.ficticiusclean.entity.ExpenseParametersInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExpenseApiTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @DisplayName("Realizar analise e retornar os itens - 200")
    @Test
    void analisysTest() throws Exception {
        mockMvc.perform(get("/api/expenses/analisys")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(ExpensesData.getExpenseParam())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].brand").value("Fiat"))
                .andExpect(jsonPath("$[0].name").value("Uno"))
                .andExpect(jsonPath("$[0].model").value("Uno Mille"))
                .andExpect(jsonPath("$[0].yearModel").value("2003"))
                .andExpect(jsonPath("$[0].totalFuelQuantity").value("4.17"))
                .andExpect(jsonPath("$[0].totalFuelExpense").value("23.31"));
    }


}
