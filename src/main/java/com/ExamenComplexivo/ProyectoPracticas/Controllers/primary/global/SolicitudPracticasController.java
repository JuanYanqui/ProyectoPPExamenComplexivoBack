package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.ISolicitudPracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/solicitudPractica")
public class SolicitudPracticasController {
    @Autowired
    ISolicitudPracticaService solicitudPracticaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Solicitud_Practicas>> obtenerLista() {
        try {
            return new ResponseEntity<>(solicitudPracticaService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Solicitud_Practicas> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(solicitudPracticaService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Solicitud_Practicas> crear(@RequestBody Solicitud_Practicas p) {
        try {
            return new ResponseEntity<>(solicitudPracticaService.save(p), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            solicitudPracticaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar la solicitud de practicas");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Solicitud_Practicas> actualizar(@RequestBody Solicitud_Practicas p,@PathVariable Long id){
        Solicitud_Practicas solicitud = solicitudPracticaService.findById(id);
        solicitud.setDocumento_solicitud_practicas(p.getDocumento_solicitud_practicas());
        return new ResponseEntity<>(solicitudPracticaService.save(solicitud), HttpStatus.CREATED);
    }
    */

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Solicitud_Practicas> actualizarUsuario(@PathVariable Long id, @RequestBody Solicitud_Practicas p) {
        Solicitud_Practicas solicitudPracticas = solicitudPracticaService.findById(id);
        if (solicitudPracticas == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                solicitudPracticas.setFechaEnvioSolicitud(p.getFechaEnvioSolicitud());
                solicitudPracticas.setFechaAceptacion(p.getFechaAceptacion());
                solicitudPracticas.setNombreSolicitud(p.getNombreSolicitud());
                solicitudPracticas.setEstadoActividad(p.isEstadoActividad());
                solicitudPracticas.setEstadoConvocatoria(p.isEstadoConvocatoria());
                solicitudPracticas.setEstadoSolicitud(p.isEstadoSolicitud());
                solicitudPracticas.setNumeroEstudiantes(p.getNumeroEstudiantes());
                return new ResponseEntity<>(solicitudPracticaService.save(solicitudPracticas), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
}
