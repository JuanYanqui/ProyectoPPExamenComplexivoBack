package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.anexos;
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

    @GetMapping("/listar")
    public ResponseEntity<List<Anexo7>> obtenerLista() {
        return new ResponseEntity<>(anexo7Service.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Anexo7> crear(@RequestBody Anexo7 c) {
        return new ResponseEntity<>(anexo7Service.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Anexo7> eliminar(@PathVariable Long id) {
        anexo7Service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Anexo7> actualizarUsuario(@PathVariable Long id, @RequestBody Anexo7 c) {
        Anexo7 anexo = anexo7Service.findById(id);
        if (anexo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                anexo.setDocumento_anexo7(c.getDocumento_anexo7());
                anexo.setCalificacion(c.getCalificacion());
                anexo.setPuntaje_total(c.getPuntaje_total());
                anexo.setParametro_calificar(c.getParametro_calificar());
                return new ResponseEntity<>(anexo7Service.save(anexo), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}

