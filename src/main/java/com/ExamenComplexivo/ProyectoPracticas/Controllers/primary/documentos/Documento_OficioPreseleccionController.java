package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_OficioPreseleccionDao;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_OficioPreseleccion;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudConvocatoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/documentoOficioPreseleccion")
public class Documento_OficioPreseleccionController {

    @Autowired
    IDocumento_OficioPreseleccionDao oficioPreseleccionDao;

    //Metodo para descargar
    @GetMapping("download/{id}")
    public ResponseEntity<byte[]> getPdfFile(@PathVariable Long id) {
        Optional<Documento_OficioPreseleccion> optionalPdfFile = oficioPreseleccionDao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_OficioPreseleccion pdfFile = optionalPdfFile.get();
            byte[] fileContent = pdfFile.getDocumento_oficiopreseleccion();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("Oficio_Preseleccion.pdf").build());
            return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<Documento_OficioPreseleccion> uploadPdfFile(@RequestParam("file") MultipartFile file) {
        try {
            Documento_OficioPreseleccion pdfFile = new Documento_OficioPreseleccion();
            pdfFile.setDocumento_oficiopreseleccion(file.getBytes());
            oficioPreseleccionDao.save(pdfFile);
            return ResponseEntity.status(HttpStatus.CREATED).body(pdfFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
