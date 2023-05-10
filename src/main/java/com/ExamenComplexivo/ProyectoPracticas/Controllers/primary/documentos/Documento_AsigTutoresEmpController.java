package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_AsigTutorEmpDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_AsigTutorEmpresarial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/documentoAsigTutorEmpresarial")
public class Documento_AsigTutoresEmpController {

    @Autowired
    IDocumento_AsigTutorEmpDao asigTutorEmpDao;

    //Metodo para descargar
    @GetMapping("download/{id}")
    public ResponseEntity<String> getPdfFile(@PathVariable Long id) {
        Optional<Documento_AsigTutorEmpresarial> optionalPdfFile = asigTutorEmpDao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_AsigTutorEmpresarial pdfFile = optionalPdfFile.get();
            byte[] fileContent = pdfFile.getDocumento_asigtutorempresarial();
            String encodedFile = Base64.getEncoder().encodeToString(fileContent);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("inline").build());
            return new ResponseEntity<>(encodedFile, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<Documento_AsigTutorEmpresarial> uploadPdfFile(@RequestParam("file") MultipartFile file) {
        try {
            Documento_AsigTutorEmpresarial pdfFile = new Documento_AsigTutorEmpresarial();
            pdfFile.setDocumento_asigtutorempresarial(file.getBytes());
            asigTutorEmpDao.save(pdfFile);
            return ResponseEntity.status(HttpStatus.CREATED).body(pdfFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
