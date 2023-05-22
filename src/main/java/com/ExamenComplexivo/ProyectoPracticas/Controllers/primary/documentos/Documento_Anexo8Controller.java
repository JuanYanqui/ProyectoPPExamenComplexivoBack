package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_Anexo8Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo7;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo8;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_AsigTutorEmpresarial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/documentoAnexo8")
public class Documento_Anexo8Controller {

    @Autowired
    IDocumento_Anexo8Dao anexo8Dao;

    @PostMapping("/upload")
    public ResponseEntity<Documento_Anexo8> uploadPdfFile(@RequestParam("file") MultipartFile file) {
        try {
            Documento_Anexo8 pdfFile = new Documento_Anexo8();
            pdfFile.setDocumento_anexo8(file.getBytes());
            anexo8Dao.save(pdfFile);
            return ResponseEntity.status(HttpStatus.CREATED).body(pdfFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Metodo para descargar
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> getPdfFile(@PathVariable Long id) {
        Optional<Documento_Anexo8> optionalPdfFile = anexo8Dao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_Anexo8 pdfFile = optionalPdfFile.get();
            byte[] fileContent = pdfFile.getDocumento_anexo8();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("DocumentoAnexo8.pdf").build());
            return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<String>> getAllPdfFiles() {
        List<Documento_Anexo8> pdfFiles = anexo8Dao.findAll();
        if (!pdfFiles.isEmpty()) {
            List<String> encodedFiles = new ArrayList<>();
            for (Documento_Anexo8 pdfFile : pdfFiles) {
                byte[] fileContent = pdfFile.getDocumento_anexo8();
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
    public ResponseEntity<Documento_Anexo8> updatePdfFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        Optional<Documento_Anexo8> optionalPdfFile = anexo8Dao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_Anexo8 pdfFile = optionalPdfFile.get();
            try {
                pdfFile.setDocumento_anexo8(file.getBytes());
                Documento_Anexo8 updatedPdfFile = anexo8Dao.save(pdfFile);
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
        Optional<Documento_Anexo8> optionalDocumento = anexo8Dao.findById(id);
        if (optionalDocumento.isPresent()) {
            Documento_Anexo8 documento = optionalDocumento.get();
            anexo8Dao.delete(documento);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
