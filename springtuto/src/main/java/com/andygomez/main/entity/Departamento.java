package com.andygomez.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departamentoId;
    
    @NotBlank(message = "Por favor agrega el nombre del departamento")
    private String nomDepartamento;
    private String dirDepartamento;
    private String codDepartamento;

}
