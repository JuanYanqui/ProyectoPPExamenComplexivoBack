package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.ISolicitudConvocatoriaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.ISolicitudPracticasDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Convocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.ISolicitudConvocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/solicitudConvocatoria")
public class SolicitudConvocatoriaController {
    @Autowired
    ISolicitudConvocatoriaService solicitudConvocatoriaService;

    @Autowired
    ISolicitudConvocatoriaDao solicitudConvocatoriaDao;

    @GetMapping("/listar")
    public ResponseEntity<List<Solicitud_Convocatoria>> obtenerLista() {
        try {
            return new ResponseEntity<>(solicitudConvocatoriaService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Solicitud_Convocatoria> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(solicitudConvocatoriaService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Solicitud_Convocatoria> crear(@RequestBody Solicitud_Convocatoria p) {
        try {
            return new ResponseEntity<>(solicitudConvocatoriaService.save(p), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear/documento")
    public ResponseEntity<?> guardar(@RequestParam("file") MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("No se ha encontrado ningún archivo.");
        }
        byte[] bytesDocumento = file.getBytes();
        return new ResponseEntity<>(solicitudConvocatoriaService.guardarDocumento(bytesDocumento), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            solicitudConvocatoriaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar la solicitud");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Solicitud_Convocatoria> actualizarUsuario(@PathVariable Long id, @RequestBody Solicitud_Convocatoria p) {
        Solicitud_Convocatoria solicitudConvocatoria = solicitudConvocatoriaService.findById(id);
        if (solicitudConvocatoria == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                solicitudConvocatoria.setFechaEnvio(p.getFechaEnvio());
                solicitudConvocatoria.setFechaAprobacion(p.getFechaAprobacion());
                solicitudConvocatoria.setCheckDirector(p.isCheckDirector());
                solicitudConvocatoria.setCheckResponsable(p.isCheckResponsable());
                solicitudConvocatoria.setCheckEmpresarial(p.isCheckEmpresarial());
                solicitudConvocatoria.setEstadoSolicitudConvo(p.isEstadoSolicitudConvo());
                solicitudConvocatoria.setResponsablePPP(p.getResponsablePPP());
                solicitudConvocatoria.setUsuario(p.getUsuario());
                return new ResponseEntity<>(solicitudConvocatoriaService.save(solicitudConvocatoria), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }

    @PutMapping("/updateDocument/{id}")
    public void actualizarDocumentoSolicitudPrc(@PathVariable Long id, @RequestParam Long idDocumento) {
        solicitudConvocatoriaDao.actualizarDocumentoSolicitudCnv(idDocumento, id);
    }


    @GetMapping("/aprobados/{idSolicitudPracticas}")
    public ResponseEntity<List<Solicitud_Convocatoria>> findByCheckResponsableAndIdSolicitudPracticas(
            @PathVariable Long idSolicitudPracticas) {
        List<Solicitud_Convocatoria> solicitudes =
                solicitudConvocatoriaDao.findByCheckResponsableAndIdSolicitudPracticas(idSolicitudPracticas);
        if (solicitudes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(solicitudes, HttpStatus.OK);
        }
    }

    @GetMapping("/porconvocatoria/{id}")
    public List<Solicitud_Convocatoria> getSolicitudesPorConvocatoria(@PathVariable("id") Long convocatoriaId) {
        return solicitudConvocatoriaService.getSolicitudesPorConvocatoria(convocatoriaId);
    }

    @GetMapping("/porconvocatoriatrue/{id}")
    public List<Solicitud_Convocatoria> getSolicitudesPorConvocatoriatrue(@PathVariable("id") Long convocatoriaId) {
        return solicitudConvocatoriaService.getSolicitudesPorConvocatoriatrue(convocatoriaId);
    }
}
