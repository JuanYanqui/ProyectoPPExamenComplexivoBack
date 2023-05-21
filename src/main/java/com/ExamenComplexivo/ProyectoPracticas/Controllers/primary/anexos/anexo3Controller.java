package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.anexos;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos.IAnexo3Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo2;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo3;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/anexo3")
public class anexo3Controller {
    @Autowired
    IAnexo3Service anexo3Service;
    @Autowired
    IAnexo3Dao anexo3Dao;

    @GetMapping("/listar")
    public ResponseEntity<List<Anexo3>> obtenerLista() {
        try {
            List<Anexo3> listaAnexos3 = anexo3Service.findByAll();
            if (listaAnexos3.isEmpty()) {
                // Si no se encontraron registros
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                // Devuelve la lista de Anexo1 encontrada
                return new ResponseEntity<>(listaAnexos3, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/crear")
    public ResponseEntity<Anexo3> crear(@RequestBody Anexo3 c) {
        try {
            if (c == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Anexo3 nuevoAnexo3 = anexo3Service.save(c);
            return new ResponseEntity<>(nuevoAnexo3, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Anexo3> eliminar(@PathVariable Long id) {
        anexo3Service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Anexo3> actualizarUsuario(@PathVariable Long id, @RequestBody Anexo3 c) {
        Anexo3 anexo = anexo3Service.findById(id);
        if (anexo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                anexo.setDocumentoAnexo3(c.getDocumentoAnexo3());
                anexo.setPractica(c.getPractica());
                return new ResponseEntity<>(anexo3Service.save(anexo), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }

    @PutMapping("/updateDocument/{id}")
    public ResponseEntity<String> actualizarDocumento(@PathVariable Long id, @RequestParam Long idDocumento) {
        if (!anexo3Dao.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El documento con ID " + idDocumento + " no existe.");
        }
        try {

            anexo3Dao.actualizarAnexo3(idDocumento, id);
            return ResponseEntity.ok("Documento actualizado correctamente.");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo actualizar el documento. Detalles del error: " + e.getMessage());
        }
    }


}
