package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_ConvenioDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudConvocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudPracticas;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_ConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.*;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperReport;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/documentoConvenio")
public class Documento_ConvenioController {

    @Autowired
    IDocumento_ConvenioDao convenioDao;
    @Autowired
    IDocumento_ConvenioService documentoConvenioService;
    @Autowired
    private DataSource dataSource;


    @GetMapping("/reporte")
    public ResponseEntity<ByteArrayResource> descargarReporte() throws JRException, SQLException {
        Connection conn = dataSource.getConnection();
        InputStream jrxmlInput = getClass().getResourceAsStream("/reports/Convenios.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlInput);
        Map<String, Object> parametros = new HashMap<>();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conn);

        byte[] reporte = JasperExportManager.exportReportToPdf(jasperPrint);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte.pdf");

        ByteArrayResource resource = new ByteArrayResource(reporte);

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(reporte.length)
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }

    //Metodo para subir documento a la base de datos
    @PostMapping("/upload")
    public ResponseEntity<Documento_Convenio> uploadPdfFile(@RequestParam("file") MultipartFile file) {
        try {
            Documento_Convenio pdfFile = new Documento_Convenio();
            pdfFile.setDocumentoConvenio(file.getBytes());
            convenioDao.save(pdfFile);
            return ResponseEntity.status(HttpStatus.CREATED).body(pdfFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Metodo para descargar
    @GetMapping("download/{id}")
    public ResponseEntity<byte[]> getPdfFile(@PathVariable Long id) {
        Optional<Documento_Convenio> optionalPdfFile = convenioDao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_Convenio pdfFile = optionalPdfFile.get();
            byte[] fileContent = pdfFile.getDocumentoConvenio();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename("DocumentoConvenio.pdf").build());
            return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<String>> getAllPdfFiles() {
        List<Documento_Convenio> pdfFiles = convenioDao.findAll();
        if (!pdfFiles.isEmpty()) {
            List<String> encodedFiles = new ArrayList<>();
            for (Documento_Convenio pdfFile : pdfFiles) {
                byte[] fileContent = pdfFile.getDocumentoConvenio();
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
    public ResponseEntity<Documento_Convenio> updatePdfFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        Optional<Documento_Convenio> optionalPdfFile = convenioDao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_Convenio pdfFile = optionalPdfFile.get();
            try {
                pdfFile.setDocumentoConvenio(file.getBytes());
                Documento_Convenio updatedPdfFile = convenioDao.save(pdfFile);
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
        Optional<Documento_Convenio> optionalDocumento = convenioDao.findById(id);
        if (optionalDocumento.isPresent()) {
            Documento_Convenio documento = optionalDocumento.get();
            convenioDao.delete(documento);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
