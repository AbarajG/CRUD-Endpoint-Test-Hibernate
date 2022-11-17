package com.andygomez.main.service;

//import com.andygomez.main.entity.Departamento;
//import com.andygomez.main.errors.DepartamentosNotFoundException;
//import java.util.List;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
import com.andygomez.main.entity.Departamento;
import com.andygomez.main.repository.DepartamentoRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class DepartamentoServiceTest {

    @Autowired
    private DepartamentoService departamentoService;
    
    @MockBean
    private DepartamentoRepository departamentoRepository;

    @BeforeEach
    public void setUp() {
        Departamento departamento = 
                Departamento.builder()
                        .nomDepartamento("Ventas")
                        .dirDepartamento("Av.Central")
                        .codDepartamento("V-0001")
                        .departamentoId(1L)
                        .build();
        
        Mockito.when(departamentoRepository.findByNomDepartamentoIgnoreCase("Ventas"))
                .thenReturn(departamento);
                        
    }

    @Test
    @DisplayName("Obtener datos al valida el nombre en la db")
//      
    public void ValidandoNombreDepartamentoEncontrado() {
        String nomDepartamento = "Ventas";
        Departamento encontrado = departamentoService
                .fetchNombreDepartamento(nomDepartamento);

        assertEquals(nomDepartamento, encontrado.getNomDepartamento());
    }

//    
//    public DepartamentoServiceTest() {
//    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    
//    @AfterEach
//    public void tearDown() {
//    }
//
//    @Test
//    public void testGuardarDepartamento_Departamento() {
//        System.out.println("guardarDepartamento");
//        Departamento departamento = null;
//        DepartamentoService instance = new DepartamentoServiceImpl();
//        Departamento expResult = null;
//        Departamento result = instance.guardarDepartamento(departamento);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of traerDepartamentos method, of class DepartamentoService.
//     */
//    @Test
//    public void testTraerDepartamentos() {
//        System.out.println("traerDepartamentos");
//        DepartamentoService instance = new DepartamentoServiceImpl();
//        List<Departamento> expResult = null;
//        List<Departamento> result = instance.traerDepartamentos();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of traerDepartamentoId method, of class DepartamentoService.
//     */
//    @Test
//    public void testTraerDepartamentoId() throws Exception {
//        System.out.println("traerDepartamentoId");
//        Long departamentoId = null;
//        DepartamentoService instance = new DepartamentoServiceImpl();
//        Departamento expResult = null;
//        Departamento result = instance.traerDepartamentoId(departamentoId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of eliminarDepartamentoId method, of class DepartamentoService.
//     */
//    @Test
//    public void testEliminarDepartamentoId() {
//        System.out.println("eliminarDepartamentoId");
//        Long departamentoId = null;
//        DepartamentoService instance = new DepartamentoServiceImpl();
//        instance.eliminarDepartamentoId(departamentoId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of guardarDepartamento method, of class DepartamentoService.
//     */
//    @Test
//    public void testGuardarDepartamento_Long_Departamento() {
//        System.out.println("guardarDepartamento");
//        Long departamentoId = null;
//        Departamento departamento = null;
//        DepartamentoService instance = new DepartamentoServiceImpl();
//        Departamento expResult = null;
//        Departamento result = instance.guardarDepartamento(departamentoId, departamento);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of fetchNombreDepartamento method, of class DepartamentoService.
//     */
//    @Test
//    public void testFetchNombreDepartamento() {
//        System.out.println("fetchNombreDepartamento");
//        String nomDepartamento = "";
//        DepartamentoService instance = new DepartamentoServiceImpl();
//        Departamento expResult = null;
//        Departamento result = instance.fetchNombreDepartamento(nomDepartamento);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    public class DepartamentoServiceImpl implements DepartamentoService {
//
//        public Departamento guardarDepartamento(Departamento departamento) {
//            return null;
//        }
//
//        public List<Departamento> traerDepartamentos() {
//            return null;
//        }
//
//        public Departamento traerDepartamentoId(Long departamentoId) throws DepartamentosNotFoundException {
//            return null;
//        }
//
//        public void eliminarDepartamentoId(Long departamentoId) {
//        }
//
//        public Departamento guardarDepartamento(Long departamentoId, Departamento departamento) {
//            return null;
//        }
//
//        public Departamento fetchNombreDepartamento(String nomDepartamento) {
//            return null;
//        }
//    }
}
