package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IConvocatoriaDao;
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
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/convocatorias")
public class ConvocatoriasController {
    @Autowired
    IConvocatoriaService convocatoriaService;

    @Autowired
    IConvocatoriaDao convocatoriaDao;
    @GetMapping("/listar")
    public ResponseEntity<List<Convocatorias>> obtenerLista() {
        try {
            return new ResponseEntity<>(convocatoriaService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listarconvocatoria")
    public ResponseEntity<List<Convocatorias>> obtenerdatos() {
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
                return new ResponseEntity<>(convocatoriaService.save(convocatorias), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
    @GetMapping("/convocatoria/documento/{id}")
    public ResponseEntity<Long> findDocumentoIdByConvocatoriaId(@PathVariable Long id) {
        Long documentoId = convocatoriaService.findDocumentoIdByConvocatoriaId(id);
        return ResponseEntity.ok(documentoId);
}

    @PutMapping("/updateDocument/{id}")
    public ResponseEntity<String> actualizarDocumento(@PathVariable Long id, @RequestParam Long idDocumento) {
        if (!convocatoriaDao.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El documento con ID " + idDocumento + " no existe.");
        }
        try {

            convocatoriaDao.actualizarDocumentoConvocatoria(idDocumento, id);
            return ResponseEntity.ok("Documento actualizado correctamente.");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo actualizar el documento. Detalles del error: " + e.getMessage());
        }
    }

    @GetMapping("/practicas")
    public ResponseEntity<List<Convocatorias>> buscarConvocatoriasConPractica() {
        List<Convocatorias> convocatorias = convocatoriaService.buscarConvocatoriasConPractica();
        return ResponseEntity.ok(convocatorias);
    }

}
