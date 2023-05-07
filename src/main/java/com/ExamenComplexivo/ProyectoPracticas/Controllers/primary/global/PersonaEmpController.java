package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Personas_empresa;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Usuario;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IPersonaEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")

@RestController
@RequestMapping("/api/personaemp")
public class PersonaEmpController {
    @Autowired
    IPersonaEmpService personaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Personas_empresa>> obtenerLista() {
        try {
            return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/crear")
    public ResponseEntity<Personas_empresa> crear(@RequestBody Personas_empresa emp) {
        try {
            return new ResponseEntity<>(personaService.save(emp), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Personas_empresa> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(personaService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Personas_empresa> actualizarPersonaemp(@PathVariable Long id, @RequestBody Personas_empresa emp) {
        Personas_empresa empresa = personaService.findById(id);
        if (empresa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                empresa.setPrimer_nombre(emp.getPrimer_nombre());
                empresa.setSegundo_nombre(emp.getSegundo_nombre());
                empresa.setPrimer_apellido(emp.getPrimer_apellido());
                empresa.setSegundo_apellido(emp.getSegundo_apellido());
                empresa.setCorreo(emp.getCorreo());
                empresa.setGenero(emp.getGenero());
                empresa.setFoto(emp.getFoto());
                return new ResponseEntity<>(personaService.save(empresa), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            personaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar la persona de la empresa");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/buscarcedula/{cedula}")
    public Personas_empresa findByCedula(@PathVariable("cedula") String cedula) {
        return this.personaService.findbyCedula(cedula);
    }
    @GetMapping(value = "/buscarcorreo/{correo}")
    public Personas_empresa findByCorreo(@PathVariable("correo") String correo) {
        return this.personaService.findbyCorreo(correo);
    }
}
