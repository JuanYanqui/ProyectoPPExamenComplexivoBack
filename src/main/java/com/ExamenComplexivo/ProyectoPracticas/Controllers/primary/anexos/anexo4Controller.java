package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.anexos;

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

    @GetMapping("/listar")
    public ResponseEntity<List<Anexo4>> obtenerLista() {
        return new ResponseEntity<>(anexo4Service.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Anexo4> crear(@RequestBody Anexo4 c){
        return new ResponseEntity<>(anexo4Service.save(c), HttpStatus.CREATED);
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
}