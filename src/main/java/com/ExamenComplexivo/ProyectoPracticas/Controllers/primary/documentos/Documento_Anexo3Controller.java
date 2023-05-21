package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_Anexo3Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/documentoAnexo3")
public class Documento_Anexo3Controller {

    @Autowired
    IDocumento_Anexo3Dao documentoAnexo3Dao;

    @PostMapping("/upload")
    public ResponseEntity<Documento_Anexo3> uploadPdfFile(@RequestParam("file") MultipartFile file) {
        try {
            Documento_Anexo3 pdfFile = new Documento_Anexo3();
            pdfFile.setDocumento_anexo3(file.getBytes());
            documentoAnexo3Dao.save(pdfFile);
            return ResponseEntity.status(HttpStatus.CREATED).body(pdfFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Metodo para descargar
    @GetMapping("download/{id}")
    public ResponseEntity<byte[]> getPdfFile(@PathVariable Long id) {
        Optional<Documento_Anexo3> optionalPdfFile = documentoAnexo3Dao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_Anexo3 pdfFile = optionalPdfFile.get();
            byte[] fileContent = pdfFile.getDocumento_anexo3();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("DocumentoAnexo3.pdf").build());
            return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
