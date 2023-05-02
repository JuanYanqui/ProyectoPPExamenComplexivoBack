package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Actividades;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IActividadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/actividades")
public class ActividadesController {
    @Autowired
    IActividadesService actividadesService;

    @GetMapping("/listar")
    public ResponseEntity<List<Actividades>> obtenerLista() {
        try {
            return new ResponseEntity<>(actividadesService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Actividades> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(actividadesService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Actividades> crear(@RequestBody Actividades p) {
        try {
            return new ResponseEntity<>(actividadesService.save(p), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            actividadesService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar la actividad");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Actividades> actualizarUsuario(@PathVariable Long id, @RequestBody Actividades p) {
        Actividades actividades = actividadesService.findById(id);
        if (actividades == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                actividades.setHerramientas(p.getHerramientas());
                actividades.setRequerimientos(p.getRequerimientos());
                actividades.setDetalleActividad(p.getDetalleActividad());
                return new ResponseEntity<>(actividadesService.save(actividades), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
}