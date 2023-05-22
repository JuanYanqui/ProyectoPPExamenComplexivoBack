package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IPracticaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Convocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.*;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_AsigTutorAcademico;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IPracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/convocatoriasporresponsable/{cedula}")
    public  List<Convocatorias> findByPracticaAnexoParaResponsableFinal(@PathVariable("cedula") String cedula) {
        return practicaService.findByPracticaAnexoParaResponsableFinal(cedula);
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

    @GetMapping("/carreraparaanexo/{idconvo}")
    public ResponseEntity<List<Anexo1>> getPracticasByCarrera(@PathVariable Long idconvo) {
        List<Anexo1> practicas = practicaService.getPracticasByCarrera(idconvo);
        return ResponseEntity.ok(practicas);
    }

    @GetMapping("/carreraparaanexo2/{idconvo}")
    public ResponseEntity<List<Anexo2>> getPracticasByCarrera2(@PathVariable Long idconvo) {
        List<Anexo2> practicas = practicaService.getPracticasByCarrera2(idconvo);
        return ResponseEntity.ok(practicas);
    }

    @GetMapping("/carreraparaanexo3/{idconvo}")
    public ResponseEntity<List<Anexo3>> getPracticasByCarrera3(@PathVariable Long idconvo) {
        List<Anexo3> practicas = practicaService.getPracticasByCarrera3(idconvo);
        return ResponseEntity.ok(practicas);
    }

    @GetMapping("/carreraparaanexo4/{idconvo}")
    public ResponseEntity<List<Practica>> getPracticasByCarrera4(@PathVariable Long idconvo) {
        List<Practica> practicas = practicaService.getPracticasByCarrera4(idconvo);
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
    public  List<Convocatorias> getPracticasByEmpresarialAnexo7(@PathVariable("id") Long idempresa) {
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
    
    @GetMapping("/listadoAprobados/{cedulaTutor}")
    public ResponseEntity<List<Map<String, String>>> buscarEstudiantesAprobados(@PathVariable("cedulaTutor") String cedulaTutor) {
        List<Object[]> datos = practicaDao.findPracticasByCedulaTutorAcademico(cedulaTutor);
        // Convertir los datos a un formato JSON
        List<Map<String, String>> datosJSON = new ArrayList<>();
        for (Object[] fila : datos) {
            Map<String, String> filaJSON = new HashMap<>();
            filaJSON.put("nombreConvocatoria", (String) fila[0]);
            filaJSON.put("nombres", (String) fila[1]);
            filaJSON.put("carrera", (String) fila[2]);
            filaJSON.put("fechainicio", (String) fila[3]);
            filaJSON.put("fechafin", (String) fila[4]);
            datosJSON.add(filaJSON);
        }

        // Me devuelve los datos en formato JSON
        return new ResponseEntity<>(datosJSON, HttpStatus.OK);
    }

    @GetMapping("/carreraparaanexo5/{idconvo}")
    public ResponseEntity<List<Anexo5>> getPracticasByCarrera5(@PathVariable Long idconvo) {
        List<Anexo5> practicas = practicaService.getPracticasByCarrera5(idconvo);
        return ResponseEntity.ok(practicas);
    }
    @GetMapping("/carreraparaanexo6/{idconvo}")
    public ResponseEntity<List<Anexo6>> getPracticasByCarrera6(@PathVariable Long idconvo) {
        List<Anexo6> practicas = practicaService.getPracticasByCarrera6(idconvo);
        return ResponseEntity.ok(practicas);
    }

    @GetMapping("/carreraparaanexo7/{idconvo}")
    public ResponseEntity<List<Anexo7>> getPracticasByCarrera7(@PathVariable Long idconvo) {
        List<Anexo7> practicas = practicaService.getPracticasByCarrera7(idconvo);
        return ResponseEntity.ok(practicas);
    }

    @GetMapping("/carreraparaanexo8/{idconvo}")
    public ResponseEntity<List<Anexo8>> getPracticasByCarrera8(@PathVariable Long idconvo) {
        List<Anexo8> practicas = practicaService.getPracticasByCarrera8(idconvo);
        return ResponseEntity.ok(practicas);
    }

    @GetMapping("/documentoanexo1/{idpractica}")
    public ResponseEntity<List<Anexo1>> findByDocumentoA1(@PathVariable Long idpractica) {
        List<Anexo1> practicas = practicaService.findByDocumentoA1(idpractica);
        return ResponseEntity.ok(practicas);
    }

    @GetMapping("/documentoanexoPractica/{cedula}")
    public ResponseEntity<List<Convocatorias>> findByPracticaAnexo1(@PathVariable String cedula) {
        List<Convocatorias> practicas = practicaService.findByPracticaAnexo1(cedula);
        return ResponseEntity.ok(practicas);
    }

    @GetMapping("/documentoanexoParaAcademico/{cedula}")
    public ResponseEntity<List<Convocatorias>> findByPracticaAnexoParaAcademixoRecibe(@PathVariable String cedula) {
        List<Convocatorias> practicas = practicaService.findByPracticaAnexoParaAcademixoRecibe(cedula);
        return ResponseEntity.ok(practicas);
    }


    @GetMapping("/documentoanexo5/{convocatoria}")
    public ResponseEntity<List<Anexo5>> findByDocumentoA5(@PathVariable Long convocatoria) {
        List<Anexo5> practicas = practicaService.findByDocumentoA5(convocatoria);
        return ResponseEntity.ok(practicas);
    }

    @GetMapping("/documentoanexo6/{convocatoria}")
    public ResponseEntity<List<Anexo6>> findByDocumentoA6(@PathVariable Long convocatoria) {
        List<Anexo6> practicas = practicaService.findByDocumentoA6(convocatoria);
        return ResponseEntity.ok(practicas);
    }

    @GetMapping("/documentoAcademicoanexo6/{convocatoria}")
    public ResponseEntity<List<Anexo6>> findByParaAcademicoDocumentoA6(@PathVariable Long convocatoria) {
        List<Anexo6> practicas = practicaService.findByParaAcademicoDocumentoA6(convocatoria);
        return ResponseEntity.ok(practicas);
    }

    @GetMapping("/documentoEmpresarialanexo7/{convocatoria}")
    public ResponseEntity<List<Anexo7>> findByParaEmpresarialDocumentoA7(@PathVariable Long convocatoria) {
        List<Anexo7> practicas = practicaService.findByParaEmpresarialDocumentoA7(convocatoria);
        return ResponseEntity.ok(practicas);
    }

    @GetMapping("/documentoAcademicoanexo8/{convocatoria}")
    public ResponseEntity<List<Anexo8>> findByParaAcademicoDocumentoA8(@PathVariable Long convocatoria) {
        List<Anexo8> practicas = practicaService.findByParaAcademicoDocumentoA8(convocatoria);
        return ResponseEntity.ok(practicas);
    }

    @GetMapping("/documentoEmpresarialanexo8/{convocatoria}")
    public ResponseEntity<List<Anexo8>> findByParaEmpresarialDocumentoA8(@PathVariable Long convocatoria) {
        List<Anexo8> practicas = practicaService.findByParaEmpresarialDocumentoA8(convocatoria);
        return ResponseEntity.ok(practicas);
    }


}
