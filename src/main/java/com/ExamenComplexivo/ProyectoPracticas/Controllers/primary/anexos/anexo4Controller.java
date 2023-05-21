package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos.IAnexo4Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo3;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo4;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo3Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/anexo4")
public class anexo4Controller {
    @Autowired
    IAnexo4Service anexo4Service;
    @Autowired
    IAnexo4Dao anexo4Dao;

    @GetMapping("/listar")
    public ResponseEntity<List<Anexo4>> obtenerLista() {
        try {
            List<Anexo4> listaAnexos4 = anexo4Service.findByAll();
            if (listaAnexos4.isEmpty()) {
                // Si no se encontraron registros
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                // Devuelve la lista de Anexo1 encontrada
                return new ResponseEntity<>(listaAnexos4, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/crear")
    public ResponseEntity<Anexo4> crear(@RequestBody Anexo4 c) {
        try {
            if (c == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Anexo4 nuevoAnexo4 = anexo4Service.save(c);
            return new ResponseEntity<>(nuevoAnexo4, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Anexo4> eliminar(@PathVariable Long id) {
        anexo4Service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Anexo4> actualizarUsuario(@PathVariable Long id, @RequestBody Anexo4 c) {
        Anexo4 anexo = anexo4Service.findById(id);
        if (anexo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                anexo.setFecha_actual(c.getFecha_actual());
                return new ResponseEntity<>(anexo4Service.save(anexo), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }

    @PutMapping("/updateDocument/{id}")
    public ResponseEntity<String> actualizarDocumento(@PathVariable Long id, @RequestParam Long idDocumento) {
        if (!anexo4Dao.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El documento con ID " + idDocumento + " no existe.");
        }
        try {

            anexo4Dao.actualizarAnexo4(idDocumento, id);
            return ResponseEntity.ok("Documento actualizado correctamente.");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo actualizar el documento. Detalles del error: " + e.getMessage());
        }
    }
}