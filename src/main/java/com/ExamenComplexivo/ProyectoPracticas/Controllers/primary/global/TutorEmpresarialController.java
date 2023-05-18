package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.ITutorEmpresarialDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Tutor_Empresarial;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.ITutorEmpresarialService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/tutorEmp")
public class TutorEmpresarialController {
    @Autowired
    ITutorEmpresarialService tutorEmpresarialService;
    @Autowired
    ITutorEmpresarialDao empresarialDao;
    @GetMapping("/listar")
    public ResponseEntity<List<Tutor_Empresarial>> obtenerLista() {
        try {
            return new ResponseEntity<>(tutorEmpresarialService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Tutor_Empresarial> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(tutorEmpresarialService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Tutor_Empresarial> crear(@RequestBody Tutor_Empresarial p) {
        try {
            return new ResponseEntity<>(tutorEmpresarialService.save(p), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            tutorEmpresarialService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar el tutor empresarial");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Tutor_Empresarial> actualizarUsuario(@PathVariable Long id, @RequestBody Tutor_Empresarial p) {
        Tutor_Empresarial tutorEmpresarial = tutorEmpresarialService.findById(id);
        if (tutorEmpresarial == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                tutorEmpresarial.setCargo(p.getCargo());
                tutorEmpresarial.setDepartamento(p.getDepartamento());
                tutorEmpresarial.setTitulo(p.getTitulo());
                return new ResponseEntity<>(tutorEmpresarialService.save(tutorEmpresarial), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }

    @GetMapping("/extraer/{idUsuario}")
    public ResponseEntity<Tutor_Empresarial> findByUsuarioId(@PathVariable Long idUsuario) {
        Tutor_Empresarial tutorEmpresarial = tutorEmpresarialService.findByUsuarioId(idUsuario);
        if (tutorEmpresarial == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tutorEmpresarial);
    }

    @GetMapping("/datos/{idResponsable}")
    public ResponseEntity<List<Map<String, String>>> obtenerDatosTutorEmpresarial(@PathVariable("idResponsable") Long idResponsable) {
        List<Object[]> datos = empresarialDao.obtenerInfoEmpresasYUsuarios(idResponsable);

        // Convertir los datos a un formato JSON
        List<Map<String, String>> datosJSON = new ArrayList<>();
        for (Object[] fila : datos) {
            Map<String, String> filaJSON = new HashMap<>();
            filaJSON.put("idUsuario", fila[0].toString());
            filaJSON.put("nombreEmpresa", (String) fila[1]);
            filaJSON.put("nombreUsuario", (String) fila[2]);
            filaJSON.put("correoUsuario", (String) fila[3]);
            filaJSON.put("telefonoUsuario", (String) fila[4]);
            datosJSON.add(filaJSON);
        }

        // Me devuelve los datos en formato JSON
        return new ResponseEntity<>(datosJSON, HttpStatus.OK);
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<String> actualizarTutorEmpresarial(@PathVariable("id") Long idTutorEmpresarial) {
        try {
            tutorEmpresarialService.actualizarTutorEmpresarial(idTutorEmpresarial);
            return ResponseEntity.ok("Tutor empresarial actualizado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo actualizar el tutor empresarial. Detalles del error: " + e.getMessage());
        }
    }



}
