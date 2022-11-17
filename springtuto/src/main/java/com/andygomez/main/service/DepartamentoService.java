package com.andygomez.main.service;

import com.andygomez.main.entity.Departamento;
import com.andygomez.main.errors.DepartamentosNotFoundException;
import java.util.List;

public interface DepartamentoService {

    public Departamento guardarDepartamento(Departamento departamento);

    public List<Departamento> traerDepartamentos();

    public Departamento traerDepartamentoId(Long departamentoId)throws DepartamentosNotFoundException;

    public void eliminarDepartamentoId(Long departamentoId);

    public Departamento guardarDepartamento(Long departamentoId, Departamento departamento);

    public Departamento fetchNombreDepartamento(String nomDepartamento);

}
