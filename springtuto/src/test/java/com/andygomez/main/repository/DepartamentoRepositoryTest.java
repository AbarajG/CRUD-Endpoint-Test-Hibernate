package com.andygomez.main.repository;

import com.andygomez.main.entity.Departamento;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class DepartamentoRepositoryTest {
    
    @Autowired
    private DepartamentoRepository departamentoRepository;
    
    @Autowired
    private TestEntityManager entityManager;
    
    @BeforeEach
    public void setUp() {
        Departamento departamento =
                Departamento.builder()
                .nomDepartamento("")
                .codDepartamento("")
                .dirDepartamento("")
                .build();
        
        entityManager.persist(departamento);
                
    }
    
    @Test
    public void EncontrandoIdRegresandoDepartamento(){
        Departamento departamento = departamentoRepository.findById(1L).get();
         assertEquals(departamento.getNomDepartamento(), "");
    }

    
}
