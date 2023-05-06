package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_ConvenioDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Convenio;
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

    @GetMapping("/listar")
    public ResponseEntity<List<Documento_Convenio>> obtenerLista() {
        return new ResponseEntity<>(documentoConvenioService.findByAll(), HttpStatus.OK);
    }

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

    @GetMapping("/descargar/{id}")
    public ResponseEntity<ByteArrayResource> descargarFichaMedica(@PathVariable Long id) {
        Documento_Convenio convenio = documentoConvenioService.findById(id);
        if (convenio == null) {
            return ResponseEntity.notFound().build();
        }

        ByteArrayResource resource = new ByteArrayResource(convenio.getDocumentoConvenio());
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ficha_medica.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(convenio.getDocumentoConvenio().length)
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }

    //Metodo para subir documento a la base de datos
    @PostMapping("/upload")
    public ResponseEntity<?> uploadPdfFile(@RequestParam("file") MultipartFile file) {
        try {
            Documento_Convenio pdfFile = new Documento_Convenio();
            pdfFile.setDocumentoConvenio(file.getBytes());
            convenioDao.save(pdfFile);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getPdfFile(@PathVariable Long id) {
        Optional<Documento_Convenio> optionalPdfFile = convenioDao.findById(id);
        if (optionalPdfFile.isPresent()) {
            Documento_Convenio pdfFile = optionalPdfFile.get();
            byte[] fileContent = pdfFile.getDocumentoConvenio();
            String encodedFile = Base64.getEncoder().encodeToString(fileContent);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.builder("inline").build());
            return new ResponseEntity<>(encodedFile, headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id_fichaMedica") Long id) {
        documentoConvenioService.delete(id);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Documento_Convenio> actualizar(@RequestBody Documento_Convenio p, @PathVariable Long id) {
        Documento_Convenio documentoConvenio = documentoConvenioService.findById(id);
        documentoConvenio.setDocumentoConvenio(p.getDocumentoConvenio());
        return new ResponseEntity<>(documentoConvenioService.save(documentoConvenio), HttpStatus.CREATED);
    }
    /*
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Documento_Convenio> buscar(@PathVariable("id_documentoCnv") Long id_documentoCnv) {
        return new ResponseEntity<>(documentoConvenioService.findById(id_documentoCnv), HttpStatus.OK);
    }
    */

}
