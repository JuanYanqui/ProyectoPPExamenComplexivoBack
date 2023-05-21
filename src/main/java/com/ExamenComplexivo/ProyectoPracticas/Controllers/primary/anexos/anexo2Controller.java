package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos.IAnexo2Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo2;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo4;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/anexo2")
public class anexo2Controller {
    @Autowired
    IAnexo2Service anexo2Service;
    @Autowired
    IAnexo2Dao anexo2Dao;


    @GetMapping("/listar")
    public ResponseEntity<List<Anexo2>> obtenerLista() {
        try {
            List<Anexo2> listaAnexos2 = anexo2Service.findByAll();
            if (listaAnexos2.isEmpty()) {
                // Si no se encontraron registros
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                // Devuelve la lista de Anexo2 encontrada
                return new ResponseEntity<>(listaAnexos2, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Anexo2> crear(@RequestBody Anexo2 c) {
        try {
            if (c == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Anexo2 nuevoAnexo2 = anexo2Service.save(c);
            return new ResponseEntity<>(nuevoAnexo2, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Anexo2> eliminar(@PathVariable Long id) {
        anexo2Service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Anexo2> actualizarUsuario(@PathVariable Long id, @RequestBody Anexo2 c) {
        Anexo2 anexo2 = anexo2Service.findById(id);
        if (anexo2 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                anexo2.setIdAnexo2(c.getIdAnexo2());
                anexo2.setPractica(c.getPractica());
                return new ResponseEntity<>(anexo2Service.save(anexo2), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }


    @PutMapping("/updateDocument/{id}")
    public ResponseEntity<String> actualizarDocumento(@PathVariable Long id, @RequestParam Long idDocumento) {
        if (!anexo2Dao.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El documento con ID " + idDocumento + " no existe.");
        }
        try {

            anexo2Dao.actualizarAnexo2(idDocumento, id);
            return ResponseEntity.ok("Documento actualizado correctamente.");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo actualizar el documento. Detalles del error: " + e.getMessage());
        }
    }

}