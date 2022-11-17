
package com.andygomez.main.controller;

import com.andygomez.main.entity.Departamento;
import com.andygomez.main.errors.DepartamentosNotFoundException;
import com.andygomez.main.service.DepartamentoService;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepaController {

    @Autowired
    private DepartamentoService departamentoService;
    
    private final Logger LOGGER = LoggerFactory.getLogger(DepaController.class);
    
    @PostMapping("/departamento")
    public Departamento guardarDepartamento(@Valid @RequestBody Departamento departamento){
        LOGGER.info("Dentro de guardar Departamento");
        return departamentoService.guardarDepartamento(departamento);
    }
    
    @GetMapping("/departamento")
    public List<Departamento> traerDepartamentos(){
        return departamentoService.traerDepartamentos();
    }
    
    @GetMapping("/departamento/{id}")
    public Departamento traerDepartamentoId(@PathVariable("id")Long departamentoId)
            throws DepartamentosNotFoundException{
        return departamentoService.traerDepartamentoId(departamentoId);
    }
    
    @DeleteMapping("/departamento/{id}")
    public String eliminarDepartamentoId(@PathVariable("id")Long departamentoId){
        departamentoService.eliminarDepartamentoId(departamentoId);
        return "Departamento eliminado correctamente";
    }
    
    @PutMapping("/departamento/{id}")
    public Departamento modificarDepartamento(@PathVariable("id") Long departamentoId ,@RequestBody Departamento departamento){
        return departamentoService.guardarDepartamento(departamentoId,departamento);
    }
    
    @GetMapping("/departamento/nombre/{nombre}")
    public Departamento fetchNombreDepartamento(@PathVariable("nombre") String nomDepartamento){
        return departamentoService.fetchNombreDepartamento(nomDepartamento);
    }
}
