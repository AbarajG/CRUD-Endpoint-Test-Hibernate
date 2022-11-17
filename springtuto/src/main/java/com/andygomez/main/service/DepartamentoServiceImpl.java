package com.andygomez.main.service;

import com.andygomez.main.entity.Departamento;
import com.andygomez.main.errors.DepartamentosNotFoundException;
import com.andygomez.main.repository.DepartamentoRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public Departamento guardarDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public List<Departamento> traerDepartamentos() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento traerDepartamentoId(Long departamentoId) throws DepartamentosNotFoundException{
        Optional<Departamento> departamento = 
                departamentoRepository.findById(departamentoId);
        
        if (!departamento.isPresent()) {
           throw new DepartamentosNotFoundException("Departamento no disponible");
        }
        return departamento.get();
    }

    @Override
    public void eliminarDepartamentoId(Long departamentoId) {
        departamentoRepository.deleteById(departamentoId);
    }

    @Override
    public Departamento guardarDepartamento(Long departamentoId, Departamento departamento) {
        Departamento depDB = departamentoRepository.findById(departamentoId).get();

        if (Objects.nonNull(departamento.getNomDepartamento()) && !"".equalsIgnoreCase(departamento.getNomDepartamento())) {
            depDB.setNomDepartamento(departamento.getNomDepartamento());
        }
        if (Objects.nonNull(departamento.getDirDepartamento()) && !"".equalsIgnoreCase(departamento.getDirDepartamento())) {
            depDB.setDirDepartamento(departamento.getDirDepartamento());
        }
        if (Objects.nonNull(departamento.getCodDepartamento()) && !"".equalsIgnoreCase(departamento.getCodDepartamento())) {
            depDB.setCodDepartamento(departamento.getCodDepartamento());
        }
        return departamentoRepository.save(depDB);
    }

//    @Override
//    public Departamento fetchDepartmentByName(String nomDepartamento) {
//        return departamentoRepository.findByNomDepartamentoIgnoreCase(nomDepartamento);
//    }

    @Override
    public Departamento fetchNombreDepartamento(String nomDepartamento) {
        return departamentoRepository.findByNomDepartamentoIgnoreCase(nomDepartamento);
    }

}
