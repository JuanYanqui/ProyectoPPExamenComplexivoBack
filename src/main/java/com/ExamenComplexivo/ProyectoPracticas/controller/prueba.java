package com.ExamenComplexivo.ProyectoPracticas.controller;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verpersonaf;
import com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.impl.IDocenteFenixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prueba")
@CrossOrigin("*")
public class prueba {
    @Autowired
    private IDocenteFenixService docenteFenix;

    @GetMapping("/personafenix/{cedula}")
    public verpersonaf buscar(@PathVariable String cedula){
        return docenteFenix.findById(cedula);
    }
}
