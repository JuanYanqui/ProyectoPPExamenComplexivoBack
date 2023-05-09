package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos.IAnexo1Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/anexo1")
public class anexo1Controller {
    @Autowired
    IAnexo1Service anexo1Service;
    @Autowired
    IAnexo1Dao anexo1Dao;
    @GetMapping("/listar")
    public ResponseEntity<List<Anexo1>> obtenerLista() {
        return new ResponseEntity<>(anexo1Service.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Anexo1> crear(@RequestBody Anexo1 c){
        return new ResponseEntity<>(anexo1Service.save(c), HttpStatus.CREATED);
    }


    /*
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id,@RequestBody Anexo1 c) {

        Anexo1 anexo = anexo1Service.findById(id);
        if (anexo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                anexo.setHabilitado(f.isHabilitado());
                return new ResponseEntity<>(ficha_odontologiaService.save(fichaOdontologica), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


        anexo1Service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
*/
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Anexo1> actualizarUsuario(@PathVariable Long id, @RequestBody Anexo1 c) {
        Anexo1 anexo1 = anexo1Service.findById(id);
        if (anexo1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                anexo1.setItv(c.getItv());
                anexo1.setHoras(c.getHoras());
                anexo1.setObjetivos(c.getObjetivos());
                anexo1.setFecha_inicio(c.getFecha_inicio());
                anexo1.setFecha_final(c.getFecha_final());
                anexo1.setAreas(c.getAreas());
                anexo1.setActividades(c.getActividades());
                return new ResponseEntity<>(anexo1Service.save(anexo1), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
    /*
    @PutMapping("/updateDocument/{id}")
    public void actualizarDocumento(@PathVariable Long id, @RequestParam Long idDocumento) {
        anexo1Dao.actualizarAnexo1(idDocumento, id);
    }*/

    @PutMapping("/updateDocument/{id}")
    public ResponseEntity<String> actualizarDocumento(@PathVariable Long id, @RequestParam Long idDocumento) {
        if (!anexo1Dao.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El documento con ID " + idDocumento + " no existe.");
        }
        try {

            anexo1Dao.actualizarAnexo1(idDocumento, id);
            return ResponseEntity.ok("Documento actualizado correctamente.");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo actualizar el documento. Detalles del error: " + e.getMessage());
        }
    }


}
