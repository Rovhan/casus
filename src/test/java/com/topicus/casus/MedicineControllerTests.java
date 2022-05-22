package com.topicus.casus;

import com.topicus.casus.controllers.MedicineController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MedicineControllerTests {

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(MedicineController.class).build();
    }

    @Test
    public void aGetRequestToMedicineShouldReturnAllMedicine() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/medicine").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
                //.andExpect(jsonPath("$.*", ));
    }
}
