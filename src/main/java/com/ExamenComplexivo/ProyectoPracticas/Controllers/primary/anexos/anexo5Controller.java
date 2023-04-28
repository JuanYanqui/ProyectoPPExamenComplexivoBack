package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo4;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo5;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo4Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo5Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/anexo5")
public class anexo5Controller {
    @Autowired
    IAnexo5Service anexo5Service;

    @GetMapping("/listar")
    public ResponseEntity<List<Anexo5>> obtenerLista() {
        return new ResponseEntity<>(anexo5Service.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Anexo5> crear(@RequestBody Anexo5 c){
        return new ResponseEntity<>(anexo5Service.save(c), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Anexo5> eliminar(@PathVariable Long id) {
        anexo5Service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Anexo5> actualizarUsuario(@PathVariable Long id, @RequestBody Anexo5 c) {
        Anexo5 anexo = anexo5Service.findById(id);
        if (anexo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                anexo.setDocumento_anexo5(c.getDocumento_anexo5());
                anexo.setFecha_actual(c.getFecha_actual());
                anexo.setFecha_desde(c.getFecha_desde());
                anexo.setHasta(c.getHasta());
                anexo.setActividades_seguimiento(c.getActividades_seguimiento());
                anexo.setObservaciones(c.getObservaciones());
                return new ResponseEntity<>(anexo5Service.save(anexo), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
