package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.anexos;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos.IAnexo7p1_EvaluaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo6;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo7;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo7Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/anexo7")
public class anexo7Controller {
    @Autowired
    IAnexo7Service anexo7Service;

    @Autowired
    IAnexo7p1_EvaluaDao anexo7Dao;

    @GetMapping("/listar")
    public ResponseEntity<List<Anexo7>> obtenerLista() {
        try {
            List<Anexo7> listaAnexos = anexo7Service.findByAll();
            if (listaAnexos.isEmpty()) {
                // Si no se encontraron registros
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                // Devuelve la lista de Anexo1 encontrada
                return new ResponseEntity<>(listaAnexos, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Anexo7> crear(@RequestBody Anexo7 c) {
        try {
            if (c == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Anexo7 nuevoAnexo = anexo7Service.save(c);
            return new ResponseEntity<>(nuevoAnexo, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Anexo7> eliminar(@PathVariable Long id) {
        anexo7Service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateDocument/{id}")
    public ResponseEntity<String> actualizarDocumento(@PathVariable Long id, @RequestParam Long idDocumento) {
        if (!anexo7Dao.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El documento con ID " + idDocumento + " no existe.");
        }
        try {

            anexo7Dao.actualizarAnexo7(idDocumento, id);
            return ResponseEntity.ok("Documento actualizado correctamente.");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo actualizar el documento. Detalles del error: " + e.getMessage());
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Anexo7> actualizarUsuario(@PathVariable Long id, @RequestBody Anexo7 c) {
        Anexo7 anexo = anexo7Service.findById(id);
        if (anexo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                anexo.setEstado_especifico(c.isEstado_especifico());
                anexo.setEstado_academico(c.isEstado_academico());
                return new ResponseEntity<>(anexo7Service.save(anexo), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Anexo7> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(anexo7Service.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

