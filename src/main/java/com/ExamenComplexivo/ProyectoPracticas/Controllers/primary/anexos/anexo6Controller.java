package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos.IAnexo6_DetallePracticaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo5;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo6;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo5Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo6Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/anexo6")
public class anexo6Controller {
    @Autowired
    IAnexo6Service anexo6Service;
    @Autowired
    IAnexo6_DetallePracticaDao anexo6Dao;

    @GetMapping("/listar")
    public ResponseEntity<List<Anexo6>> obtenerLista() {
        try {
            List<Anexo6> listaAnexos = anexo6Service.findByAll();
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
    public ResponseEntity<Anexo6> crear(@RequestBody Anexo6 c) {
        try {
            if (c == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Anexo6 nuevoAnexo = anexo6Service.save(c);
            return new ResponseEntity<>(nuevoAnexo, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Anexo6> eliminar(@PathVariable Long id) {
        anexo6Service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Anexo6> actualizarUsuario(@PathVariable Long id, @RequestBody Anexo6 c) {
        Anexo6 anexo = anexo6Service.findById(id);
        if (anexo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                anexo.setFecha_inicio(c.getFecha_inicio());
                anexo.setFecha_fin(c.getFecha_fin());
                anexo.setEstado_academico(c.isEstado_academico());
                anexo.setEstado_especifico(c.isEstado_especifico());
                anexo.setEstado_estudiante(c.isEstado_estudiante());
                anexo.setNumero_semana(c.getNumero_semana());
                return new ResponseEntity<>(anexo6Service.save(anexo), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }

    @PutMapping("/updateDocument/{id}")
    public ResponseEntity<String> actualizarDocumento(@PathVariable Long id, @RequestParam Long idDocumento) {
        if (!anexo6Dao.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El documento con ID " + idDocumento + " no existe.");
        }
        try {

            anexo6Dao.actualizarAnexo6(idDocumento, id);
            return ResponseEntity.ok("Documento actualizado correctamente.");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo actualizar el documento. Detalles del error: " + e.getMessage());
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Anexo6> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(anexo6Service.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
