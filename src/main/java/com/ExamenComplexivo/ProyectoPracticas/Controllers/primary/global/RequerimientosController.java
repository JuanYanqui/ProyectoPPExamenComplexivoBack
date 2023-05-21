package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Requerimientos;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Convocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IRequerimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/requerimientos")
public class RequerimientosController {
    @Autowired
    IRequerimientoService requerimientoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Requerimientos>> obtenerLista() {
        try {
            return new ResponseEntity<>(requerimientoService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Requerimientos> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(requerimientoService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Requerimientos> crear(@RequestBody Requerimientos p) {
        try {
            return new ResponseEntity<>(requerimientoService.save(p), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            requerimientoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar el requerimiento");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/porsolicitud/{idsolicitud}")
    public ResponseEntity<List<Requerimientos>> getSolicitudesPorConvocatoriatrue(@PathVariable("idsolicitud") Long idsolicitud) {
        List<Requerimientos> requerimientos = requerimientoService.findByRequerimientosPorSolicitud(idsolicitud);

        if (!requerimientos.isEmpty()) {
            return ResponseEntity.ok(requerimientos);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


}
