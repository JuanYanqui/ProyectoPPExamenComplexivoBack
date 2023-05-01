package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/convenio")
public class ConvenioController {
    @Autowired
    IConvenioService convenioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Convenio>> obtenerLista() {
        try {
            return new ResponseEntity<>(convenioService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Convenio> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(convenioService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Convenio> crear(@RequestBody Convenio p) {
        try {
            return new ResponseEntity<>(convenioService.save(p), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*
    @PostMapping("/crear/documento")
    public ResponseEntity<?> guardar(@RequestParam("file") MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("No se ha encontrado ningún archivo.");
        }
        byte[] bytesDocumento = file.getBytes();
        return new ResponseEntity<>(convenioService.guardarDocumento(bytesDocumento), HttpStatus.CREATED);
    }
*/

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            convenioService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar el convenio");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Convenio> actualizarUsuario(@PathVariable Long id, @RequestBody Convenio p) {
        Convenio convenio = convenioService.findById(id);
        if (convenio == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                convenio.setDocumentoConvenio(p.getDocumentoConvenio());
                convenio.setNumero_convenio(p.getNumero_convenio());
                convenio.setDescripcion(p.getDescripcion());
                convenio.setNumero_itv(p.getNumero_itv());
                convenio.setEstado(p.isEstado());
                return new ResponseEntity<>(convenioService.save(convenio), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
}
