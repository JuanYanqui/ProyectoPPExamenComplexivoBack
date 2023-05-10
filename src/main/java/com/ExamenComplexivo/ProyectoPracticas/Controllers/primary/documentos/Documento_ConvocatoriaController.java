package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;


import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_ConvocatoriaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Convocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudPracticas;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_ConvocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/documentoConvocatoria")
public class Documento_ConvocatoriaController {

    @Autowired
    IDocumento_ConvocatoriaDao documentoDao;

    @Autowired
    IDocumento_ConvocatoriaService documentoConvocatoriaService;
    @Autowired
    private DataSource dataSource;

    @PostMapping("/upload")
    public ResponseEntity<Documento_Convocatoria> uploadPdfFile(@RequestParam("file") MultipartFile file) {
        try {
            Documento_Convocatoria pdfFile = new Documento_Convocatoria();
            pdfFile.setDocumento_convocatoria(file.getBytes());
            documentoDao.save(pdfFile);
            return ResponseEntity.status(HttpStatus.CREATED).body(pdfFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Metodo para descargar
    @GetMapping("download/{id}")
    public ResponseEntity<byte[]> getPdfFile(@PathVariable Long id) {
        Optional<Documento_Convocatoria> optionalPdfFile = documentoDao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_Convocatoria pdfFile = optionalPdfFile.get();
            byte[] fileContent = pdfFile.getDocumento_convocatoria();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("DocumentoConvocatoria.pdf").build());
            return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/listar")
    public ResponseEntity<List<String>> getAllPdfFiles() {
        List<Documento_Convocatoria> pdfFiles = documentoDao.findAll();
        if (!pdfFiles.isEmpty()) {
            List<String> encodedFiles = new ArrayList<>();
            for (Documento_Convocatoria pdfFile : pdfFiles) {
                byte[] fileContent = pdfFile.getDocumento_convocatoria();
                String encodedFile = Base64.getEncoder().encodeToString(fileContent);
                encodedFiles.add(encodedFile);
            }
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<>(encodedFiles, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<Documento_Convocatoria> updatePdfFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        Optional<Documento_Convocatoria> optionalPdfFile = documentoDao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_Convocatoria pdfFile = optionalPdfFile.get();
            try {
                pdfFile.setDocumento_convocatoria(file.getBytes());
                Documento_Convocatoria updatedPdfFile = documentoDao.save(pdfFile);
                return ResponseEntity.ok().body(updatedPdfFile);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> deleteDocumento(@PathVariable Long id) {
        Optional<Documento_Convocatoria> optionalDocumento = documentoDao.findById(id);
        if (optionalDocumento.isPresent()) {
            Documento_Convocatoria documento = optionalDocumento.get();
            documentoDao.delete(documento);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
