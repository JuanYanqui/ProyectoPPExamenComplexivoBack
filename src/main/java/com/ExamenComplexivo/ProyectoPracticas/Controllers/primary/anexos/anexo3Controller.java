package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.anexos;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo3;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/anexo3")
public class anexo3Controller {
    @Autowired
    IAnexo3Service anexo3Service;

    @GetMapping("/listar")
    public ResponseEntity<List<Anexo3>> obtenerLista() {
        return new ResponseEntity<>(anexo3Service.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Anexo3> crear(@RequestBody Anexo3 c){
        return new ResponseEntity<>(anexo3Service.save(c), HttpStatus.CREATED);
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
                anexo.setDocumento_anexo3(c.getDocumento_anexo3());
                return new ResponseEntity<>(anexo3Service.save(anexo), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
