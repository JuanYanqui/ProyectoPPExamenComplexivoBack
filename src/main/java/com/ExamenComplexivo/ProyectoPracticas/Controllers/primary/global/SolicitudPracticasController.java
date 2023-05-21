package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.ISolicitudPracticasDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Usuario;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.ISolicitudPracticaService;
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
@RequestMapping("/api/solicitudPractica")
public class SolicitudPracticasController {
    @Autowired
    ISolicitudPracticaService solicitudPracticaService;
    @Autowired
    ISolicitudPracticasDao solicitudPracticasDao;
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


    @GetMapping("/activas")
    public ResponseEntity<List<Solicitud_Practicas>> obtenerSolicitudesActivas() {
        try {
            List<Solicitud_Practicas> solicitudesActivas = solicitudPracticaService.findByEstadoActividadTrue();
            return new ResponseEntity<>(solicitudesActivas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listarestado")
    public ResponseEntity<List<Solicitud_Practicas>> buscarPorEstadoSolicitud() {
        try {
            List<Solicitud_Practicas> solicitudes = solicitudPracticaService.buscarPorEstadoSolicitud(true);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/listarestadocarrera/{carrera}")
    public ResponseEntity<List<Solicitud_Practicas>> buscarPorEstadoSolicitud(@PathVariable String carrera) {
        try {
            List<Solicitud_Practicas> solicitudes = solicitudPracticaService.findByEstadoSolicitudPorcarrera(carrera);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @GetMapping("/listarestadoentrue/{carrera}")
    public ResponseEntity<List<Solicitud_Practicas>> buscarPorEstadoSolicitudentrue(@PathVariable String carrera) {
        try {
            List<Solicitud_Practicas> solicitudes = solicitudPracticaService.findByEstadoSolicitudPorcarreraSolicitudaprobada(carrera);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/listarestadofalse")
    public ResponseEntity<List<Solicitud_Practicas>> buscarPorEstadoSolicitudfalse() {
        try {
            List<Solicitud_Practicas> solicitudes = solicitudPracticaService.buscarPorEstadoSolicitud(false);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping("/updateDocument/{id}")
    public ResponseEntity<String> actualizarDocumento(@PathVariable Long id, @RequestParam Long idDocumento) {
        if (!solicitudPracticasDao.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El documento con ID " + idDocumento + " no existe.");
        }
        try {

            solicitudPracticasDao.actualizarDocumentoSolicitudPrc(idDocumento, id);
            return ResponseEntity.ok("Documento actualizado correctamente.");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo actualizar el documento. Detalles del error: " + e.getMessage());
        }
    }

    @GetMapping("/buscardocument/{id}")
    public ResponseEntity<Long> findDocumentoIdByConvocatoriaId(@PathVariable Long id) {
        try {
            Long documentoId = solicitudPracticasDao.findDocumentoIdBySolicitudId(id);
            return ResponseEntity.ok(documentoId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/buscarporempresa/{idempresa}")
    public ResponseEntity<List<Solicitud_Practicas>> findBybuscarporempresa(@PathVariable Long idempresa) {
        try {
            List<Solicitud_Practicas> solicitudes = solicitudPracticaService.buscarPorEmpresa(idempresa);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/buscarTodas/{idempresa}")
    public ResponseEntity<List<Solicitud_Practicas>> findBybuscarporempresaTodas(@PathVariable Long idempresa) {
        try {
            List<Solicitud_Practicas> solicitudes = solicitudPracticasDao.findbyTodas(idempresa);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/nombrestutores/{idempresa}")
    public ResponseEntity<List<Usuario>> obtenerNombresTutores(@PathVariable Long idempresa) {
        try {
            List<Usuario> tutores = solicitudPracticaService.obtenerNombresTutores(idempresa);
            return ResponseEntity.ok(tutores);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/listaporidresponsableppp/{idresponsableppp}")
    public ResponseEntity<List<Solicitud_Practicas>> findByEstadoActividadTruePorResponsablePPP(@PathVariable Long idresponsableppp) {
        try {
            List<Solicitud_Practicas> solicitudes = solicitudPracticaService.findByEstadoActividadTruePorResponsablePPP(idresponsableppp);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/listasolicitudcheckresponsable/{idempresa}")
    public ResponseEntity<List<Solicitud_Practicas>> findBySolicitudpracticasCheckResponsable(@PathVariable Long idempresa) {
        try {
            List<Solicitud_Practicas> solicitudes = solicitudPracticaService.findBySolicitudpracticasCheckResponsable(idempresa);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/listasolicitudcheck/{idempresa}")
    public ResponseEntity<List<Solicitud_Practicas>> buscarsoliporempresa(@PathVariable Long idempresa) {
        try {
            List<Solicitud_Practicas> solicitudes = solicitudPracticaService.buscarsoliporempresa(idempresa);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/listasoltuto/{idUsuario}")
    public ResponseEntity<List<Object[]>> buscarsolportutor(@PathVariable Long idUsuario) {
        try {
            List<Object[]> solicitudes = solicitudPracticaService.buscarsolportutor(idUsuario);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/listasoltutoaceptadas/{idUsuario}")
    public ResponseEntity<List<Object[]>> buscarsolportutoraceptadas(@PathVariable Long idUsuario) {
        try {
            List<Object[]> solicitudes = solicitudPracticaService.buscarsolportutoraceptadas(idUsuario);
            return ResponseEntity.ok(solicitudes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }





}
