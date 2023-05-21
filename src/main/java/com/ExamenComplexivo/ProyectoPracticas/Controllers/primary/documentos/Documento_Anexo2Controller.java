package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_Anexo2Dao;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/documentoAnexo2")
public class Documento_Anexo2Controller {

    @Autowired
    IDocumento_Anexo2Dao documentoAnexo2Dao;

    @PostMapping("/upload")
    public ResponseEntity<Documento_Anexo2> uploadPdfFile(@RequestParam("file") MultipartFile file) {
        try {
            Documento_Anexo2 pdfFile = new Documento_Anexo2();
            pdfFile.setDocumento_anexo2(file.getBytes());
            documentoAnexo2Dao.save(pdfFile);
            return ResponseEntity.status(HttpStatus.CREATED).body(pdfFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Metodo para descargar
    @GetMapping("download/{id}")
    public ResponseEntity<byte[]> getPdfFile(@PathVariable Long id) {
        Optional<Documento_Anexo2> optionalPdfFile = documentoAnexo2Dao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_Anexo2 pdfFile = optionalPdfFile.get();
            byte[] fileContent = pdfFile.getDocumento_anexo2();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("DocumentoAnexo2.pdf").build());
            return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
