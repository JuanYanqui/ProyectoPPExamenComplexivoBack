package com.ExamenComplexivo.ProyectoPracticas.Controllers.secundary;
import com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.impl.IMateriaFenixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.vermateriasf;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/verMaterias")
public class verMateriasController {
    @Autowired
    IMateriaFenixService materiaFenixService;

    // Metodo para listar materias
    @GetMapping("/listar")
    public List<vermateriasf> index() {
        return materiaFenixService.findAll();
    }

    // Metodo para buscar por id
    @GetMapping("/list/{id}")
    public vermateriasf show(@PathVariable Integer id) {
        return materiaFenixService.findById(id);

    }
}
