package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IConvocatoriaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IConvocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/convocatorias")
public class ConvocatoriasController {
    @Autowired
    IConvocatoriaService convocatoriaService;

    @Autowired
    IConvocatoriaDao convocatoriaDao;
    @GetMapping("/listar")
    public ResponseEntity<List<Convocatorias>> obtenerLista() {
        try {
            return new ResponseEntity<>(convocatoriaService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listarconvocatoria")
    public ResponseEntity<List<Convocatorias>> obtenerdatos() {
        try {
            return new ResponseEntity<>(convocatoriaService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Convocatorias> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(convocatoriaService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Convocatorias> crear(@Valid @RequestBody Convocatorias p) {
        try {
            return new ResponseEntity<>(convocatoriaService.save(p), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            convocatoriaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar la convocatoria");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Convocatorias> actualizarUsuario(@PathVariable Long id, @RequestBody Convocatorias p) {
        Convocatorias convocatorias = convocatoriaService.findById(id);
        if (convocatorias == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                convocatorias.setNombreConvocatoria(p.getNombreConvocatoria());
                convocatorias.setFechaPublicacion(p.getFechaPublicacion());
                convocatorias.setFechaExpiracion(p.getFechaExpiracion());
                convocatorias.setEstadoConvocatoria(p.isEstadoConvocatoria());
                return new ResponseEntity<>(convocatoriaService.save(convocatorias), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
    @GetMapping("/convocatoria/documento/{id}")
    public ResponseEntity<Long> findDocumentoIdByConvocatoriaId(@PathVariable Long id) {
        try {
            // Obtener el ID del documento por ID de convocatoria desde el servicio
            Long documentoId = convocatoriaService.findDocumentoIdByConvocatoriaId(id);
            if (documentoId == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(documentoId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping("/updateDocument/{id}")
    public ResponseEntity<String> actualizarDocumento(@PathVariable Long id, @RequestParam Long idDocumento) {
        if (!convocatoriaDao.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El documento con ID " + idDocumento + " no existe.");
        }
        try {

            convocatoriaDao.actualizarDocumentoConvocatoria(idDocumento, id);
            return ResponseEntity.ok("Documento actualizado correctamente.");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo actualizar el documento. Detalles del error: " + e.getMessage());
        }
    }

    @GetMapping("/practicas")
    public ResponseEntity<List<Convocatorias>> buscarConvocatoriasConPractica() {
        try {
            List<Convocatorias> convocatorias = convocatoriaService.buscarConvocatoriasConPractica();
            // Verificar si se encontraron convocatorias con prácticas
            if (convocatorias.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(convocatorias);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/convocatoriaporcarrera/{carrera}")
    public ResponseEntity<List<Convocatorias>> buscarPorCarrera(@PathVariable String carrera) {
        try {
            List<Convocatorias> convocatorias = convocatoriaService.findByConvocatoriaporCarrera(carrera);
            // Verificar si se encontraron convocatorias
            if (convocatorias.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(convocatorias);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/convocatoriaporsolicitud/{idSolicitudPracticas}")
    public ResponseEntity<List<Convocatorias>> buscarPorSolicitud(@PathVariable Long idSolicitudPracticas) {
        try {

            List<Convocatorias> convocatorias = convocatoriaService.findByConvocatoriaporSolicitudP(idSolicitudPracticas);
            // Verificar si se encontraron convocatorias
            if (convocatorias.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(convocatorias);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/convocatoriaporempresa/{idempresa}")
    public ResponseEntity<List<Convocatorias>> buscarPorEmpresa(@PathVariable Long idempresa) {
        try {

            List<Convocatorias> convocatorias = convocatoriaService.buscarsoliporempresacovocatoria(idempresa);
            // Verificar si se encontraron convocatorias
            if (convocatorias.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(convocatorias);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/convocatoriaporempresaestadosoli/{idempresa}")
    public ResponseEntity<List<Convocatorias>> buscarsoliporempresacovocatoriaconestadosolicitud(@PathVariable Long idempresa) {
        try {
            List<Convocatorias> convocatorias = convocatoriaService.buscarsoliporempresacovocatoriaconestadosolicitud(idempresa);
            // Verificar si se encontraron convocatorias
            if (convocatorias.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(convocatorias);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/convocatoriaporcarreraconpractica/{carrera}")
    public ResponseEntity<List<Convocatorias>> findByConvocatoriaporCarreraPractica(@PathVariable String carrera) {
        try {
            List<Convocatorias> convocatorias = convocatoriaService.findByConvocatoriaporCarreraPractica(carrera);
            if (convocatorias.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(convocatorias);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/ListaConvocatoriasC")
    public ResponseEntity<List<Object[]>> buscarConvocatoriasC() {
        try {
            List<Object[]> convocatorias = convocatoriaService.buscarConvocatoriasC();
            if (convocatorias.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(convocatorias);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    
    //Metodo para listar convocatorias con datos relacionados desde otras tablas en ROL Responsable
    @GetMapping("/datos/{idResponsable}")
    public ResponseEntity<List<Map<String, String>>> obtenerDatosConvocatoria(@PathVariable("idResponsable") Long idResponsable){
        List<Object[]> datos = convocatoriaDao.listarConvocatorias(idResponsable);

        // Convertir los datos a un formato JSON
        List<Map<String, String>> datosJSON = new ArrayList<>();
        for (Object[] fila : datos) {
            Map<String, String> filaJSON = new HashMap<>();
            filaJSON.put("convocatoria", fila[0].toString());
            filaJSON.put("FechaPublicacion", (String) fila[1]);
            filaJSON.put("FechaExpiracion", (String) fila[2]);
            filaJSON.put("carrera", (String) fila[3]);
            filaJSON.put("estado", String.valueOf((Boolean) fila[4]));
            filaJSON.put("fechaAprobacion", (String) fila[5]);
            datosJSON.add(filaJSON);
        }
        // Me devuelve los datos en formato JSON
        return new ResponseEntity<>(datosJSON, HttpStatus.OK);
    }
    @GetMapping("/convocatoriasoli/{carrera}")
    public ResponseEntity<List<Convocatorias>> buscarConvocatoriaSoli(@PathVariable String carrera) {
        try {
            List<Convocatorias> convocatorias = convocatoriaService.BuscarConvocatoriaporCarrera(carrera);
            if (convocatorias.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(convocatorias);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
