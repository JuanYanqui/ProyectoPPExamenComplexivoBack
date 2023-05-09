package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos.IAnexo6_DetallePracticaDao;
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
        return new ResponseEntity<>(anexo6Service.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Anexo6> crear(@RequestBody Anexo6 c){
        return new ResponseEntity<>(anexo6Service.save(c), HttpStatus.CREATED);
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
                anexo.setDia(c.getDia());
                anexo.setHora_ingreso(c.getHora_ingreso());
                anexo.setHora_salida(c.getHora_salida());
                anexo.setHoras_diarias(c.getHoras_diarias());
                anexo.setTotal_horas(c.getTotal_horas());
                anexo.setNumero_semana(c.getNumero_semana());
                return new ResponseEntity<>(anexo6Service.save(anexo), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }

    @PutMapping("/updateDocument/{id}")
    public ResponseEntity<String> actualizarDocumento(@PathVariable Long id, @RequestParam Long idDocumento) {
        try {
            anexo6Dao.actualizarAnexo6(idDocumento, id);
            return ResponseEntity.ok("Documento actualizado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo actualizar el documento. Detalles del error: " + e.getMessage());
        }
    }
}
