package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Estudiante_Practicante;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IEstudiantePracticanteService;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.ISolicitudPracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/estudiantepracticante")
public class EstudiantePracticanteController {
    @Autowired
    IEstudiantePracticanteService iEstudiantePracticanteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Estudiante_Practicante>> obtenerLista() {
        try {
            return new ResponseEntity<>(iEstudiantePracticanteService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Estudiante_Practicante> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(iEstudiantePracticanteService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Estudiante_Practicante> crear(@RequestBody Estudiante_Practicante p) {
        try {
            Estudiante_Practicante nuevoEstudiantePracticante = iEstudiantePracticanteService.save(p);
            if (nuevoEstudiantePracticante != null) {
                return new ResponseEntity<>(nuevoEstudiantePracticante, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            iEstudiantePracticanteService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar la solicitud de practicas");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Estudiante_Practicante> actualizarUsuario(@PathVariable Long id, @RequestBody Estudiante_Practicante p) {
        Estudiante_Practicante estudiantePracticante = iEstudiantePracticanteService.findById(id);
        if (estudiantePracticante == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                estudiantePracticante.setEstado(p.getEstado());
                return new ResponseEntity<>(iEstudiantePracticanteService.save(estudiantePracticante), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }

    @GetMapping("/buscarPorCedula/{cedula}")
    public ResponseEntity<List<Estudiante_Practicante>> buscarPorCedula(@PathVariable String cedula) {
        try {

            List<Estudiante_Practicante> estudiantes = iEstudiantePracticanteService.findByCedula(cedula);
            if (estudiantes.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(estudiantes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/estudiantePracticante/{cedula}")
    public ResponseEntity<Long> findIdByCedula(@PathVariable String cedula) {
        try {
            Long id = iEstudiantePracticanteService.findIdByCedula(cedula);

            if (id == null) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
