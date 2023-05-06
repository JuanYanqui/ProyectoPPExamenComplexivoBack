package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_SolicitudPracticasDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudPracticas;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_SolicitudPracticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/documentoSolicitudPracticas")

public class Documento_SolicitudPracticasController {

    @Autowired
    IDocumento_SolicitudPracticasDao documentoDao;

    @Autowired
    IDocumento_SolicitudPracticasService documentoSolicitudPracticasService;
    @Autowired
    private DataSource dataSource;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadPdfFile(@RequestParam("file") MultipartFile file) {
        try {
            Documento_SolicitudPracticas pdfFile = new Documento_SolicitudPracticas();
            pdfFile.setDocumento_solicitud_practicas(file.getBytes());
            documentoDao.save(pdfFile);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //Metodo para consultar
    @GetMapping("/{id}")
    public ResponseEntity<String> getPdfFile(@PathVariable Long id) {
        Optional<Documento_SolicitudPracticas> optionalPdfFile = documentoDao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_SolicitudPracticas pdfFile = optionalPdfFile.get();
            byte[] fileContent = pdfFile.getDocumento_solicitud_practicas();
            String encodedFile = Base64.getEncoder().encodeToString(fileContent);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("inline").build());
            return new ResponseEntity<>(encodedFile, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    /*
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
    */

}
