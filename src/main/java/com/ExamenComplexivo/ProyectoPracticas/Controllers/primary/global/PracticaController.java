package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IPracticaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Convocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo2;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo3;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IPracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/practica")
public class PracticaController {
    @Autowired
    IPracticaService practicaService;
    @Autowired
    IPracticaDao practicaDao;

    @GetMapping("/listar")
    public ResponseEntity<List<Practica>> obtenerLista() {
        try {
            return new ResponseEntity<>(practicaService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Practica> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(practicaService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Practica> crear(@RequestBody Practica p) {
        try {
            return new ResponseEntity<>(practicaService.save(p), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            practicaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar la practica");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Practica> actualizarUsuario(@PathVariable Long id, @RequestBody Practica p) {
        Practica practica = practicaService.findById(id);
        if (practica == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                practica.setFechaInicio(p.getFechaInicio());
                practica.setFechaFin(p.getFechaFin());
                practica.setEstadoPractica(p.isEstadoPractica());
                practica.setCheckAcademico(p.isCheckAcademico());
                practica.setCheckEmpresarial(p.isCheckEmpresarial());
                practica.setUsuario(p.getUsuario());
                practica.setTutorEmpresarial(p.getTutorEmpresarial());
                practica.setEstadoanexo1(p.isEstadoanexo1());
                practica.setEstadoanexo2(p.isEstadoanexo2());
                practica.setEstadoanexo3(p.isEstadoanexo3());
                practica.setEstadoanexo4(p.isEstadoanexo4());
                practica.setEstadoanexo5(p.isEstadoanexo5());
                practica.setEstadoanexo6(p.isEstadoanexo6());
                practica.setEstadoanexo7(p.isEstadoanexo7());
                practica.setEstadoanexo8(p.isEstadoanexo8());

                return new ResponseEntity<>(practicaService.save(practica), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
    @GetMapping("/aprobadas/{idempresa}")
    public List<Practica> getPracticasAprobadas(@PathVariable("idempresa") Long idempresa) {
        return practicaService.getPracticasAprobadas(idempresa);
    }

    @GetMapping("/convocatoriaspractica/{id}")
    public  List<Practica> getPracticasByConvocatoriaId(@PathVariable("id") Long convocatoriaId) {
        return practicaService.getPracticasByConvocatoriaId(convocatoriaId);
    }

    @PutMapping("/updateDocumentA/{id}")
    public ResponseEntity<String> actualizarDocumentoAcademico(@PathVariable Long id, @RequestParam Long idDocumento) {
        if (!practicaDao.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El documento con ID " + idDocumento + " no existe.");
        }
        try {

            practicaDao.actualizarDocumentoAsigTutorAc(idDocumento, id);
            return ResponseEntity.ok("Documento actualizado correctamente.");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo actualizar el documento. Detalles del error: " + e.getMessage());
        }
    }


    @PutMapping("/updateDocumentE/{id}")
    public ResponseEntity<String> actualizarDocumentoEmpresarial(@PathVariable Long id, @RequestParam Long idDocumento) {
        if (!practicaDao.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El documento con ID " + idDocumento + " no existe.");
        }
        try {

            practicaDao.actualizarDocumentoAsigTutorEmp(idDocumento, id);
            return ResponseEntity.ok("Documento actualizado correctamente.");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo actualizar el documento. Detalles del error: " + e.getMessage());
        }
    }

    @GetMapping("/usuariosxpractica/{id}")
    public  List<Practica> getPracticasBySolicitudPracticasId(@PathVariable("id") Long solicitudpracticasId) {
        return practicaService.getPracticasBySolicitudPracticasId(solicitudpracticasId);
    }

    @GetMapping("/practicaporacademico/{cedula}")
    public  List<Convocatorias> getPracticasByAcademico(@PathVariable("cedula") String cedula) {
        return practicaService.getPracticasByAcademico(cedula);
    }

    @GetMapping("/practicaparaanexo/{id}/{idusuario}")
    public  List<Practica> getPracticasByDocumentoAnexo(@PathVariable("id") Long idconvocatoria, @PathVariable("idusuario") Long idusuario) {
        return practicaService.getPracticasByDocumentoAnexo(idconvocatoria, idusuario);
    }

    @GetMapping("/practicaporestudiante/{cedula}")
    public  List<Practica> getPracticasByEstudiante(@PathVariable("cedula") String cedula) {
        return practicaService.getPracticasByEstudiante(cedula);
    }

    @GetMapping("/practicaporestudianteanexo3/{cedula}")
    public  List<Practica> getPracticasByEstudianteAnexo3(@PathVariable("cedula") String cedula) {
        return practicaService.getPracticasByEstudianteAnexo3(cedula);
    }

    @GetMapping("/carreraparaanexo/{carrera}")
    public ResponseEntity<List<Anexo1>> getPracticasByCarrera(@PathVariable String carrera) {
        List<Anexo1> practicas = practicaService.getPracticasByCarrera(carrera);
        return ResponseEntity.ok(practicas);
    }

    @GetMapping("/carreraparaanexo2/{carrera}")
    public ResponseEntity<List<Anexo2>> getPracticasByCarrera2(@PathVariable String carrera) {
        List<Anexo2> practicas = practicaService.getPracticasByCarrera2(carrera);
        return ResponseEntity.ok(practicas);
    }

    @GetMapping("/carreraparaanexo3/{carrera}")
    public ResponseEntity<List<Anexo3>> getPracticasByCarrera3(@PathVariable String carrera) {
        List<Anexo3> practicas = practicaService.getPracticasByCarrera3(carrera);
        return ResponseEntity.ok(practicas);
    }

    @GetMapping("/practicaparaanexo5/{id}/{idusuario}")
    public  List<Practica> getPracticasByDocumentoAnexo5(@PathVariable("id") Long idconvocatoria, @PathVariable("idusuario") Long idusuario) {
        return practicaService.getPracticasByDocumentoAnexo5(idconvocatoria, idusuario);
    }

    @GetMapping("/practicaporestudianteanexo6/{cedula}")
    public  List<Practica> getPracticasByEstudianteAnexo6(@PathVariable("cedula") String cedula) {
        return practicaService.getPracticasByEstudianteAnexo6(cedula);
    }

    @GetMapping("/practicaporempresaanexo7/{id}")
    public  List<Practica> getPracticasByEmpresarialAnexo7(@PathVariable("id") Long idempresa) {
        return practicaService.getPracticasByEmpresarialAnexo7(idempresa);
    }

    @GetMapping("/practicalistaranexo7/{id}")
    public  List<Practica> getPracticasBylistarAnexo7(@PathVariable("id") Long tutor) {
        return practicaService.getPracticasBylistarAnexo7(tutor);
    }

    @GetMapping("/practicaporestudianteanexo8/{cedula}")
    public  List<Practica> getPracticasByEstudianteAnexo8(@PathVariable("cedula") String cedula) {
        return practicaService.getPracticasByEstudianteAnexo8(cedula);
    }

    @GetMapping("/convocatoriasparaanexo1/{convocatoriaId}")
    public ResponseEntity<Long> getPracticasByConvocatoriaIdAnexo1(@PathVariable Long convocatoriaId) {
        Long id = practicaService.getPracticasByConvocatoriaIdAnexo1(convocatoriaId);
        return ResponseEntity.ok(id);
    }

}
