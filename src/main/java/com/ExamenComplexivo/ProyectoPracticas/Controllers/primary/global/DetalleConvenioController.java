package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Detalle_Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IDetalleConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/detalleConvenio")
public class DetalleConvenioController {
    @Autowired
    IDetalleConvenioService detalleConvenioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Detalle_Convenio>> obtenerLista() {
        try {
            return new ResponseEntity<>(detalleConvenioService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Detalle_Convenio> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(detalleConvenioService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Detalle_Convenio> crear(@RequestBody Detalle_Convenio p) {
        try {
            return new ResponseEntity<>(detalleConvenioService.save(p), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            detalleConvenioService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Detalle_Convenio> actualizarUsuario(@PathVariable Long id, @RequestBody Detalle_Convenio p) {
        Detalle_Convenio detalleConvenio = detalleConvenioService.findById(id);
        if (detalleConvenio == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                detalleConvenio.setFecha_caducidad(p.getFecha_caducidad());
                detalleConvenio.setFechaAprobacion(p.getFechaAprobacion());
                return new ResponseEntity<>(detalleConvenioService.save(detalleConvenio), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
}