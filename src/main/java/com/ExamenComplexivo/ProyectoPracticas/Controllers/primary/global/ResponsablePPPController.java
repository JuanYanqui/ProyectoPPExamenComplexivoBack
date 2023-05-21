package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IResponsable_PPPDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Responsable_PPP;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/representantePPP")
public class ResponsablePPPController {
    @Autowired
    IResponsableService responsableService;

    @GetMapping("/listar")
    public ResponseEntity<List<Responsable_PPP>> obtenerLista() {
        try {
            return new ResponseEntity<>(responsableService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Responsable_PPP> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(responsableService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Responsable_PPP> crear(@RequestBody Responsable_PPP p) {
        try {
            return new ResponseEntity<>(responsableService.save(p), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            responsableService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar el representante de practicas");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Responsable_PPP> actualizarUsuario(@PathVariable Long id, @RequestBody Responsable_PPP p) {
        Responsable_PPP responsable = responsableService.findById(id);
        if (responsable == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {

                responsable.setCarrera(p.getCarrera());

                return new ResponseEntity<>(responsableService.save(responsable), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }


    @GetMapping("/carrera/{carrera}")
    public ResponseEntity<List<String>> getNombresCompletosDeResponsablesPorCarrera(@PathVariable String carrera) {
        List<String> nombresCompletos = responsableService.getNombresCompletosDeResponsablesPorCarrera(carrera);

        if (!nombresCompletos.isEmpty()) {
            return ResponseEntity.ok(nombresCompletos);
        } else {
            return ResponseEntity.noContent().build();
        }
    }



    @GetMapping("/carreraID/{nombreCarrera}")
    public ResponseEntity<Integer> buscarResponsablePorCarrera(@PathVariable String nombreCarrera) {
        try {
            Integer idResponsable = responsableService.buscarResponsablePorCarrera(nombreCarrera);
            return ResponseEntity.ok(idResponsable);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/cedularesponsable/{cedula}")
    public ResponseEntity<?> findByCedulaUsuario(@PathVariable String cedula) {
        try {
            Responsable_PPP responsable = responsableService.findByCedulaUsuario(cedula);
            if (responsable != null) {
                return ResponseEntity.ok(responsable);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
