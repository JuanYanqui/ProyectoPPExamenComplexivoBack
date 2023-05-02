package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo6;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo7;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo8;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo7Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo8Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/anexo8")
public class anexo8Controller {
    @Autowired
    IAnexo8Service anexo8Service;

    @GetMapping("/listar")
    public ResponseEntity<List<Anexo8>> obtenerLista() {
        return new ResponseEntity<>(anexo8Service.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Anexo8> crear(@RequestBody Anexo8 c){
        return new ResponseEntity<>(anexo8Service.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Anexo8> eliminar(@PathVariable Long id) {
        anexo8Service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Anexo8> actualizarUsuario(@PathVariable Long id, @RequestBody Anexo8 c) {
        Anexo8 anexo = anexo8Service.findById(id);
        if (anexo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                anexo.setDocumento_anexo8(c.getDocumento_anexo8());
                anexo.setTiempo_duracion(c.getTiempo_duracion());
                anexo.setConclusiones(c.getConclusiones());
                return new ResponseEntity<>(anexo8Service.save(anexo), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
