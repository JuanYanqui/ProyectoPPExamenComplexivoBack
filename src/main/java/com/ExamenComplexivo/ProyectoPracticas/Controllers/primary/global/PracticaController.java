package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Convocatoria;
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
                return new ResponseEntity<>(practicaService.save(practica), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
    @GetMapping("/aprobadas")
    public List<Practica> getPracticasAprobadas() {
        return practicaService.getPracticasAprobadas();
    }

    @GetMapping("/convocatoriaspractica/{id}")
    public  List<Practica> getPracticasByConvocatoriaId(@PathVariable("id") Long convocatoriaId) {
        return practicaService.getPracticasByConvocatoriaId(convocatoriaId);
    }
    @GetMapping("/usuariosxpractica/{id}")
    public  List<Practica> getPracticasBySolicitudPracticasId(@PathVariable("id") Long solicitudpracticasId) {
        return practicaService.getPracticasBySolicitudPracticasId(solicitudpracticasId);
    }

}
