package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IConvocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/convocatorias")
public class ConvocatoriasController {
    @Autowired
    IConvocatoriaService convocatoriaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Convocatorias>> obtenerLista() {
        try {
            return new ResponseEntity<>(convocatoriaService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Convocatorias> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(convocatoriaService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
/*
    @PostMapping("/crear")
    public ResponseEntity<Convocatorias> crear(@RequestParam("file") MultipartFile file, @RequestBody Convocatorias solicitud) {
        try {
            byte[] bytes = file.getBytes();
            solicitud.setDocumento_convocatoria(bytes);
            Convocatorias solicitudGuardada = convocatoriaService.save(solicitud);
            return new ResponseEntity<>(solicitudGuardada, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

 */

    @PostMapping("/crear")
    public ResponseEntity<Convocatorias> crear(@Valid @RequestBody Convocatorias p) {
        try {
            return new ResponseEntity<>(convocatoriaService.save(p), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            convocatoriaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar la convocatoria");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Convocatorias> actualizarUsuario(@PathVariable Long id, @RequestBody Convocatorias p) {
        Convocatorias convocatorias = convocatoriaService.findById(id);
        if (convocatorias == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                convocatorias.setNombreConvocatoria(p.getNombreConvocatoria());
                convocatorias.setFechaPublicacion(p.getFechaPublicacion());
                convocatorias.setFechaExpiracion(p.getFechaExpiracion());
                convocatorias.setEstadoConvocatoria(p.isEstadoConvocatoria());
                //convocatorias.setDocumento_convocatoria(p.getDocumento_convocatoria());

                return new ResponseEntity<>(convocatoriaService.save(convocatorias), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
}
