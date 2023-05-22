package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_Anexo5Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo5;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo6;
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
@RequestMapping("/api/documentoAnexo5")
public class Documento_Anexo5Controller {

    @Autowired
    IDocumento_Anexo5Dao documentoAnexo5Dao;

    @PostMapping("/upload")
    public ResponseEntity<Documento_Anexo5> uploadPdfFile(@RequestParam("file") MultipartFile file) {
        try {
            Documento_Anexo5 pdfFile = new Documento_Anexo5();
            pdfFile.setDocumento_anexo5(file.getBytes());
            documentoAnexo5Dao.save(pdfFile);
            return ResponseEntity.status(HttpStatus.CREATED).body(pdfFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //Metodo para descargar

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> getPdfFile(@PathVariable Long id) {
        Optional<Documento_Anexo5> optionalPdfFile = documentoAnexo5Dao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_Anexo5 pdfFile = optionalPdfFile.get();
            byte[] fileContent = pdfFile.getDocumento_anexo5();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("DocumentoAnexo5.pdf").build());
            return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/listar")
    public ResponseEntity<List<String>> getAllPdfFiles() {
        List<Documento_Anexo5> pdfFiles = documentoAnexo5Dao.findAll();
        if (!pdfFiles.isEmpty()) {
            List<String> encodedFiles = new ArrayList<>();
            for (Documento_Anexo5 pdfFile : pdfFiles) {
                byte[] fileContent = pdfFile.getDocumento_anexo5();
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
    public ResponseEntity<Documento_Anexo5> updatePdfFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        Optional<Documento_Anexo5> optionalPdfFile = documentoAnexo5Dao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_Anexo5 pdfFile = optionalPdfFile.get();
            try {
                pdfFile.setDocumento_anexo5(file.getBytes());
                Documento_Anexo5 updatedPdfFile = documentoAnexo5Dao.save(pdfFile);
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
        Optional<Documento_Anexo5> optionalDocumento = documentoAnexo5Dao.findById(id);
        if (optionalDocumento.isPresent()) {
            Documento_Anexo5 documento = optionalDocumento.get();
            documentoAnexo5Dao.delete(documento);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
