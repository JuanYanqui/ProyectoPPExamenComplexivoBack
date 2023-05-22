package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_Anexo6Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo6;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/documentoAnexo6")
public class Documento_Anexo6Controller {

    @Autowired
    IDocumento_Anexo6Dao documentoAnexo6Dao;

    @PostMapping("/upload")
    public ResponseEntity<Documento_Anexo6> uploadPdfFile(@RequestParam("file") MultipartFile file) {
        try {
            Documento_Anexo6 pdfFile = new Documento_Anexo6();
            pdfFile.setDocumento_anexo6(file.getBytes());
            documentoAnexo6Dao.save(pdfFile);
            return ResponseEntity.status(HttpStatus.CREATED).body(pdfFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Metodo para descargar
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> getPdfFile(@PathVariable Long id) {
        Optional<Documento_Anexo6> optionalPdfFile = documentoAnexo6Dao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_Anexo6 pdfFile = optionalPdfFile.get();
            byte[] fileContent = pdfFile.getDocumento_anexo6();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("DocumentoAnexo6.pdf").build());
            return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<String>> getAllPdfFiles() {
        List<Documento_Anexo6> pdfFiles = documentoAnexo6Dao.findAll();
        if (!pdfFiles.isEmpty()) {
            List<String> encodedFiles = new ArrayList<>();
            for (Documento_Anexo6 pdfFile : pdfFiles) {
                byte[] fileContent = pdfFile.getDocumento_anexo6();
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
    public ResponseEntity<Documento_Anexo6> updatePdfFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        Optional<Documento_Anexo6> optionalPdfFile = documentoAnexo6Dao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_Anexo6 pdfFile = optionalPdfFile.get();
            try {
                pdfFile.setDocumento_anexo6(file.getBytes());
                Documento_Anexo6 updatedPdfFile = documentoAnexo6Dao.save(pdfFile);
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
        Optional<Documento_Anexo6> optionalDocumento = documentoAnexo6Dao.findById(id);
        if (optionalDocumento.isPresent()) {
            Documento_Anexo6 documento = optionalDocumento.get();
            documentoAnexo6Dao.delete(documento);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

