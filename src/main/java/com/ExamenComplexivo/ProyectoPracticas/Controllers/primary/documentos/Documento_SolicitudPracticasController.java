package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_SolicitudPracticasDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Empresa;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Convocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_OficioPreseleccion;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudPracticas;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_SolicitudPracticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.io.IOException;
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
    public ResponseEntity<Documento_SolicitudPracticas> uploadPdfFile(@RequestParam("file") MultipartFile file) {
        try {
            Documento_SolicitudPracticas pdfFile = new Documento_SolicitudPracticas();
            pdfFile.setDocumento_solicitud_practicas(file.getBytes());
            documentoDao.save(pdfFile);
            return ResponseEntity.status(HttpStatus.CREATED).body(pdfFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/listarDoc")
    public ResponseEntity<List<Documento_SolicitudPracticas>> obtenerLista() {
        try {
            return new ResponseEntity<>(documentoSolicitudPracticasService.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Metodo para descargar
    @GetMapping("download/{id}")
    public ResponseEntity<byte[]> getPdfFile(@PathVariable Long id) {
        Optional<Documento_SolicitudPracticas> optionalPdfFile = documentoDao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_SolicitudPracticas pdfFile = optionalPdfFile.get();
            byte[] fileContent = pdfFile.getDocumento_solicitud_practicas();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("Solicitud_Practicas.pdf").build());
            return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<String>> getAllPdfFiles() {
        List<Documento_SolicitudPracticas> pdfFiles = documentoDao.findAll();
        if (!pdfFiles.isEmpty()) {
            List<String> encodedFiles = new ArrayList<>();
            for (Documento_SolicitudPracticas pdfFile : pdfFiles) {
                byte[] fileContent = pdfFile.getDocumento_solicitud_practicas();
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
    public ResponseEntity<Documento_SolicitudPracticas> updatePdfFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        Optional<Documento_SolicitudPracticas> optionalPdfFile = documentoDao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_SolicitudPracticas pdfFile = optionalPdfFile.get();
            try {
                pdfFile.setDocumento_solicitud_practicas(file.getBytes());
                Documento_SolicitudPracticas updatedPdfFile = documentoDao.save(pdfFile);
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
        Optional<Documento_SolicitudPracticas> optionalDocumento = documentoDao.findById(id);
        if (optionalDocumento.isPresent()) {
            Documento_SolicitudPracticas documento = optionalDocumento.get();
            documentoDao.delete(documento);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
