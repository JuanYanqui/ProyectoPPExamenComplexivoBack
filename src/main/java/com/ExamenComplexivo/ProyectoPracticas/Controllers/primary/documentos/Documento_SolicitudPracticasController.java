package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;


import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudPracticas;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_ConvenioService;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_SolicitudPracticasService;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/documentoSolicitudPracticas")

public class Documento_SolicitudPracticasController {



    @Autowired
    IDocumento_SolicitudPracticasService documentoSolicitudPracticasService;
    @Autowired
    private DataSource dataSource;



    @GetMapping("/listar")
    public ResponseEntity<List<Documento_SolicitudPracticas>> obtenerLista() {
        return new ResponseEntity<>(documentoSolicitudPracticasService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/descargar/{id}")
    public ResponseEntity<ByteArrayResource> descargarFichaMedica(@PathVariable Long id) {
        Documento_SolicitudPracticas solicitudPracticas = documentoSolicitudPracticasService.findById(id);
        if (solicitudPracticas == null) {
            return ResponseEntity.notFound().build();
        }

        ByteArrayResource resource = new ByteArrayResource(solicitudPracticas.getDocumento_solicitud_practicas());
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ficha_medica.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(solicitudPracticas.getDocumento_solicitud_practicas().length)
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }


    @PostMapping("/subir")
    public ResponseEntity<?> guardarSolicitudPractica(@RequestParam("file") MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("No se ha proporcionado ningún archivo.");
        }

        byte[] bytesDocumento = file.getBytes();

        return new ResponseEntity<>(documentoSolicitudPracticasService.guardarDocumento(bytesDocumento), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id_fichaMedica") Long id) {
        documentoSolicitudPracticasService.delete(id);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Documento_SolicitudPracticas> actualizar(@RequestBody Documento_Convenio p, @PathVariable Long id) {
        Documento_SolicitudPracticas documentoSolicitudPracticas = documentoSolicitudPracticasService.findById(id);
        documentoSolicitudPracticas.setDocumento_solicitud_practicas(p.getDocumentoConvenio());
        return new ResponseEntity<>(documentoSolicitudPracticasService.save(documentoSolicitudPracticas), HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Documento_SolicitudPracticas> buscar(@PathVariable("id_documentoSolicitudPrc") Long id_documentoSolicitudPrc) {
        return new ResponseEntity<>(documentoSolicitudPracticasService.findById(id_documentoSolicitudPrc), HttpStatus.OK);
    }


}
