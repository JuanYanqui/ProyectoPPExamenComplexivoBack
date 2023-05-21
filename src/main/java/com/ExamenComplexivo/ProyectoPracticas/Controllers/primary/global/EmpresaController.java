package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Empresa;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {
    @Autowired
    IEmpresaService empresaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Empresa>> obtenerLista() {
        try {
            return new ResponseEntity<>(empresaService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Empresa> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(empresaService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Empresa> crear(@RequestBody Empresa p) {
        try {
            Empresa nuevaEmpresa = empresaService.save(p);
            if (nuevaEmpresa != null) {
                return new ResponseEntity<>(nuevaEmpresa, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {
            empresaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar la empresa");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Empresa> actualizarUsuario(@PathVariable Long id, @RequestBody Empresa p) {
        Empresa empresa = empresaService.findById(id);
        if (empresa == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                empresa.setNombreEmpresa(p.getNombreEmpresa());
                empresa.setCiudad(p.getCiudad());
                empresa.setRucEmpresa(p.getRucEmpresa());
                empresa.setDescripcion(p.getDescripcion());
                empresa.setCorreo(p.getCorreo());
                empresa.setCodigoPostal(p.getCodigoPostal());
                empresa.setNumeroTelefono(p.getNumeroTelefono());
                empresa.setDireccion(p.getDireccion());
                empresa.setStatus(p.isStatus());

                return new ResponseEntity<>(empresaService.save(empresa), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
}
