package com.ExamenComplexivo.ProyectoPracticas.Controllers.secundary;

import com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.impl.IverCarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verCarreras;

import java.util.List;
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/verCarreras")
public class verCarrerasController {
    @Autowired
    IverCarreraService carreraService;

    // Metodo para listar carreras
    @GetMapping("/listar")
    public List<verCarreras> index() {
        return carreraService.findAll();
    }

    // Metodo para buscar por id
    @GetMapping("/list/{id}")
    public verCarreras show(@PathVariable Integer id) {
        return carreraService.findById(id);

    }
}