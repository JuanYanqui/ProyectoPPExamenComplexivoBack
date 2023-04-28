package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo2;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/anexo2")
public class anexo2Controller {
    @Autowired
    IAnexo2Service anexo2Service;

    @GetMapping("/listar")
    public ResponseEntity<List<Anexo2>> obtenerLista() {
        return new ResponseEntity<>(anexo2Service.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Anexo2> crear(@RequestBody Anexo2 c){
        return new ResponseEntity<>(anexo2Service.save(c), HttpStatus.CREATED);
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
                anexo2.setDocumento_anexo2(c.getDocumento_anexo2());
                anexo2.setPractica(c.getPractica());
                return new ResponseEntity<>(anexo2Service.save(anexo2), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
