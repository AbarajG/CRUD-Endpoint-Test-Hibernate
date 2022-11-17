package com.andygomez.main.controller;

import com.andygomez.main.entity.Departamento;
import com.andygomez.main.service.DepartamentoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(DepaController.class)
public class DepaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartamentoService departamentoService;

    private Departamento departamento;

    @BeforeEach
    void setUp() {
        departamento = Departamento.builder()
                .nomDepartamento("Compras")
                .dirDepartamento("Av.Central")
                .codDepartamento("C-0001")
                .departamentoId(1L)
                .build();
    }

    @Test
    public void testGuardarDepartamento() throws Exception {
        Departamento inputDepartamento = Departamento.builder()
                .nomDepartamento("Compras")
                .dirDepartamento("Av.Central")
                .codDepartamento("C-0001")
                .departamentoId(1L)
                .build();

        Mockito.when(departamentoService.guardarDepartamento(inputDepartamento))
                .thenReturn(departamento);

        mockMvc.perform(MockMvcRequestBuilders.post("/departamento")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n"
                        + "\"nomDepartamento\": \"Compras\",\n"
                        + "\"dirDepartamento\": \"Av.Central\",\n"
                        + "\"codDepartamento\": \"C-0001\"\n"
                        + "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void traerDepartamentoId() throws Exception{
        Mockito.when(departamentoService.traerDepartamentoId(1L))
                .thenReturn(departamento);
        
        mockMvc.perform(get("/departamento/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.nomDepartamento").
                value(departamento.getNomDepartamento()));
    }

}
