package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_AsigTutorAcaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_AsigTutorAcademico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/documentoAsigTutorAcademico")
public class Documento_AsigTutorAcaController {
    @Autowired
    IDocumento_AsigTutorAcaDao asigTutorAcaDao;
    //Metodo para descargar
    @GetMapping("download/{id}")
    public ResponseEntity<byte[]> getPdfFile(@PathVariable Long id) {
        Optional<Documento_AsigTutorAcademico> optionalPdfFile = asigTutorAcaDao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_AsigTutorAcademico pdfFile = optionalPdfFile.get();
            byte[] fileContent = pdfFile.getDocumento_asigtutoracademico();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("Asignacion_Tutor_Academico.pdf").build());
            return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<Documento_AsigTutorAcademico> uploadPdfFile(@RequestParam("file") MultipartFile file) {
        try {
            Documento_AsigTutorAcademico pdfFile = new Documento_AsigTutorAcademico();
            pdfFile.setDocumento_asigtutoracademico(file.getBytes());
            asigTutorAcaDao.save(pdfFile);
            return ResponseEntity.status(HttpStatus.CREATED).body(pdfFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
