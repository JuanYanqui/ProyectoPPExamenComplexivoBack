package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.ISolicitudConvocatoriaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.ISolicitudPracticasDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Convocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.ISolicitudConvocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                solicitudConvocatoria.setTutorEmpresarial(p.getTutorEmpresarial());
                solicitudConvocatoria.setUsuario(p.getUsuario());
                solicitudConvocatoria.setCheckPractica(p.isCheckPractica());
                solicitudConvocatoria.setEstadoestudiante(p.isEstadoestudiante());
                return new ResponseEntity<>(solicitudConvocatoriaService.save(solicitudConvocatoria), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }

    @PutMapping("/updateDocument/{id}")
    public ResponseEntity<String> actualizarDocumento(@PathVariable Long id, @RequestParam Long idDocumento) {
        if (!solicitudConvocatoriaDao.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El documento con ID " + idDocumento + " no existe.");
        }
        try {

            solicitudConvocatoriaDao.actualizarDocumentoSolicitudCnv(idDocumento, id);
            return ResponseEntity.ok("Documento actualizado correctamente.");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo actualizar el documento. Detalles del error: " + e.getMessage());
        }
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
    public ResponseEntity<List<Solicitud_Convocatoria>> getSolicitudesPorConvocatoria(@PathVariable("id") Long convocatoriaId) {
        try {
            List<Solicitud_Convocatoria> solicitudes = solicitudConvocatoriaService.getSolicitudesPorConvocatoria(convocatoriaId);

            if (solicitudes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/porconvocatoriatrue/{id}")
    public ResponseEntity<List<Solicitud_Convocatoria>> getSolicitudesPorConvocatoriatrue(@PathVariable("id") Long convocatoriaId) {
        try {
            List<Solicitud_Convocatoria> solicitudes = solicitudConvocatoriaService.getSolicitudesPorConvocatoriatrue(convocatoriaId);

            if (solicitudes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/buscardocument/{id}")
    public ResponseEntity<Long> findDocumentoIdByConvocatoriaId(@PathVariable Long id) {
        try {
            Long documentoId = solicitudConvocatoriaDao.findDocumentoIdBySolicitudCId(id);

            if (documentoId == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return ResponseEntity.ok(documentoId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/porconvocatoriatruepractica/{id}")
    public ResponseEntity<List<Solicitud_Convocatoria>> getSolicitudesPorConvocatoriatrupractica(@PathVariable("id") Long convocatoriaId) {
        try {
            List<Solicitud_Convocatoria> solicitudes = solicitudConvocatoriaService.getSolicitudesPorConvocatoriatruepractica(convocatoriaId);
            if (solicitudes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/count/{convocatoriaId}/{estudiantePracticasId}")
    public ResponseEntity<Integer> getCount(@PathVariable Long convocatoriaId, @PathVariable Long estudiantePracticasId) {
        try {
            int count = solicitudConvocatoriaService.getCountByConvocatoriaAndEstudiante(convocatoriaId, estudiantePracticasId);
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/buscarcovocatoriadirector/{id}")
    public ResponseEntity<List<Solicitud_Convocatoria>> findByConvocatoriasDirector(@PathVariable("id") Long convocatoriaId) {
        try {
            List<Solicitud_Convocatoria> solicitudes = solicitudConvocatoriaService.findByConvocatoriasDirector(convocatoriaId);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/buscarcovocatoriadirectorfalse/{id}")
    public ResponseEntity<List<Solicitud_Convocatoria>> findByConvocatoriasDirectorFalse(@PathVariable("id") Long convocatoriaId) {
        try {
            List<Solicitud_Convocatoria> solicitudes = solicitudConvocatoriaService.findByConvocatoriasDirectorFalse(convocatoriaId);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/buscarcovocatoriatutor/{id}")
    public ResponseEntity<List<Solicitud_Convocatoria>> findByConvocatoriasTutor(@PathVariable("id") Long convocatoriaId) {
        try {
            List<Solicitud_Convocatoria> solicitudes = solicitudConvocatoriaService.findByConvocatoriasTutor(convocatoriaId);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/buscarcovocatoriatutorfalse/{id}")
    public ResponseEntity<List<Solicitud_Convocatoria>> findByConvocatoriasTutorFalse(@PathVariable("id") Long convocatoriaId) {
        try {
            List<Solicitud_Convocatoria> solicitudes = solicitudConvocatoriaService.findByConvocatoriasTutorFalse(convocatoriaId);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @GetMapping("/listadoAprobados/{idTutorEmpresarial}")
    public ResponseEntity<List<Map<String, String>>> buscarEstudiantesAprobados(@PathVariable("idTutorEmpresarial") Long idTutorEmpresarial) {
        List<Object[]> datos = solicitudConvocatoriaDao.obtenerEstudiantesAprobados(idTutorEmpresarial);
        // Convertir los datos a un formato JSON
        List<Map<String, String>> datosJSON = new ArrayList<>();
        for (Object[] fila : datos) {
            Map<String, String> filaJSON = new HashMap<>();
            filaJSON.put("nombreConvocatoria", (String) fila[0]);
            filaJSON.put("cedula", (String) fila[1]);
            filaJSON.put("nombres", (String) fila[2]);
            filaJSON.put("carrera", (String) fila[3]);
            filaJSON.put("fechaAprobacion", (String) fila[4]);
            datosJSON.add(filaJSON);
        }

        // Me devuelve los datos en formato JSON
        return new ResponseEntity<>(datosJSON, HttpStatus.OK);
    }

    @GetMapping("/buscaranexo1/{id}")
    public ResponseEntity<List<Solicitud_Convocatoria>> findByAnexo1(@PathVariable("id") Long convocatoriaId) {
        try {
            List<Solicitud_Convocatoria> solicitudes = solicitudConvocatoriaService.findByAnexo1(convocatoriaId);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/buscaranexo5/{id}")
    public ResponseEntity<List<Solicitud_Convocatoria>> findByAnexo5(@PathVariable("id") Long convocatoriaId) {
        try {
            List<Solicitud_Convocatoria> solicitudes = solicitudConvocatoriaService.findByAnexo5(convocatoriaId);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/buscaranexo7/{id}")
    public ResponseEntity<List<Solicitud_Convocatoria>> findByAnexo7(@PathVariable("id") Long convocatoriaId) {
        try {
            List<Solicitud_Convocatoria> solicitudes = solicitudConvocatoriaService.findByAnexo7(convocatoriaId);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/SolicitudEstudianteNoCancelado/{cedula}")
    public ResponseEntity<List<Solicitud_Convocatoria>> findSolicitudConvocatoriaPorEstudianteSinCancelar(@PathVariable("cedula") String cedula) {
        try {
            List<Solicitud_Convocatoria> solicitudes = solicitudConvocatoriaService.findSolicitudConvocatoriaPorEstudianteSinCancelar(cedula);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/SolicitudEstudianteCancelado/{cedula}")
    public ResponseEntity<List<Solicitud_Convocatoria>> findSolicitudConvocatoriaPorEstudianteCancelado(@PathVariable("cedula") String cedula) {
        try {
            List<Solicitud_Convocatoria> solicitudes = solicitudConvocatoriaService.findSolicitudConvocatoriaPorEstudianteCancelado(cedula);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
