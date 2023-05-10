package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_Anexo4Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo4;
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
@RequestMapping("/api/documentoAnexo4")
public class Documento_Anexo4Controller {

    @Autowired
    IDocumento_Anexo4Dao documentoAnexo4Dao;

    @PostMapping("/upload")
    public ResponseEntity<Documento_Anexo4> uploadPdfFile(@RequestParam("file") MultipartFile file) {
        try {
            Documento_Anexo4 pdfFile = new Documento_Anexo4();
            pdfFile.setDocumento_anexo4(file.getBytes());
            documentoAnexo4Dao.save(pdfFile);
            return ResponseEntity.status(HttpStatus.CREATED).body(pdfFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //Metodo para descargar
    @GetMapping("download/{id}")
    public ResponseEntity<String> getPdfFile(@PathVariable Long id) {
        Optional<Documento_Anexo4> optionalPdfFile = documentoAnexo4Dao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_Anexo4 pdfFile = optionalPdfFile.get();
            byte[] fileContent = pdfFile.getDocumento_anexo4();
            String encodedFile = Base64.getEncoder().encodeToString(fileContent);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("inline").build());
            return new ResponseEntity<>(encodedFile, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<String>> getAllPdfFiles() {
        List<Documento_Anexo4> pdfFiles = documentoAnexo4Dao.findAll();
        if (!pdfFiles.isEmpty()) {
            List<String> encodedFiles = new ArrayList<>();
            for (Documento_Anexo4 pdfFile : pdfFiles) {
                byte[] fileContent = pdfFile.getDocumento_anexo4();
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
    public ResponseEntity<Documento_Anexo4> updatePdfFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        Optional<Documento_Anexo4> optionalPdfFile = documentoAnexo4Dao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_Anexo4 pdfFile = optionalPdfFile.get();
            try {
                pdfFile.setDocumento_anexo4(file.getBytes());
                Documento_Anexo4 updatedPdfFile = documentoAnexo4Dao.save(pdfFile);
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
        Optional<Documento_Anexo4> optionalDocumento = documentoAnexo4Dao.findById(id);
        if (optionalDocumento.isPresent()) {
            Documento_Anexo4 documento = optionalDocumento.get();
            documentoAnexo4Dao.delete(documento);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
