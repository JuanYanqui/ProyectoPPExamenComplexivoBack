package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_Anexo1Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo4;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Convenio;
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
@RequestMapping("/api/documentoAnexo1")
public class
Documento_Anexo1Controller {

    @Autowired
    IDocumento_Anexo1Dao documentoAnexo1Dao;

    @PostMapping("/upload")
    public ResponseEntity<Documento_Anexo1> uploadPdfFile(@RequestParam("file") MultipartFile file) {
        try {
            Documento_Anexo1 pdfFile = new Documento_Anexo1();
            pdfFile.setDocumento_anexo1(file.getBytes());
            documentoAnexo1Dao.save(pdfFile);
            return ResponseEntity.status(HttpStatus.CREATED).body(pdfFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Metodo para descargar
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> getPdfFile(@PathVariable Long id) {
        Optional<Documento_Anexo1> optionalPdfFile = documentoAnexo1Dao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_Anexo1 pdfFile = optionalPdfFile.get();
            byte[] fileContent = pdfFile.getDocumento_anexo1();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("DocumentoAnexo1.pdf").build());
            return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<String>> getAllPdfFiles() {
        List<Documento_Anexo1> pdfFiles = documentoAnexo1Dao.findAll();
        if (!pdfFiles.isEmpty()) {
            List<String> encodedFiles = new ArrayList<>();
            for (Documento_Anexo1 pdfFile : pdfFiles) {
                byte[] fileContent = pdfFile.getDocumento_anexo1();
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
    public ResponseEntity<Documento_Anexo1> updatePdfFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        Optional<Documento_Anexo1> optionalPdfFile = documentoAnexo1Dao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_Anexo1 pdfFile = optionalPdfFile.get();
            try {
                pdfFile.setDocumento_anexo1(file.getBytes());
                Documento_Anexo1 updatedPdfFile = documentoAnexo1Dao.save(pdfFile);
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
        Optional<Documento_Anexo1> optionalDocumento = documentoAnexo1Dao.findById(id);
        if (optionalDocumento.isPresent()) {
            Documento_Anexo1 documento = optionalDocumento.get();
            documentoAnexo1Dao.delete(documento);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
