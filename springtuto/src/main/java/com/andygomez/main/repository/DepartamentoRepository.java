package com.andygomez.main.repository;

import com.andygomez.main.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{

    public Departamento findByNomDepartamento(String nomDepartamento);
    
    public Departamento findByNomDepartamentoIgnoreCase(String nomDepartamento);
    
    
}
