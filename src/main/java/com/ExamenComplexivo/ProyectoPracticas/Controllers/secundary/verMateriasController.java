package com.ExamenComplexivo.ProyectoPracticas.Controllers.secundary;
import com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.impl.IMateriaFenixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/nombre/{nombreCarrera}")
    public ResponseEntity<List<String>> obtenerMateriasPorCarrera(@PathVariable String nombreCarrera) {
        List<String> materias = materiaFenixService.obtenerMateriasPorCarrera(nombreCarrera);
        return new ResponseEntity<>(materias, HttpStatus.OK);
    }

}
