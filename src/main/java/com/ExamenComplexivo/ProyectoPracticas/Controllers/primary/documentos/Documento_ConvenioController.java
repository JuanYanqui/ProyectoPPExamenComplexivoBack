package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Documento_Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_ConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/documentoConvenio")
public class Documento_ConvenioController {
    @Autowired
    IDocumento_ConvenioService documentoConvenioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Documento_Convenio>> obtenerLista() {
        return new ResponseEntity<>(documentoConvenioService.findByAll(), HttpStatus.OK);
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
    /*
    @PostMapping("/ficha/crearfichaMedica")
    public ResponseEntity<Documento_Convenio> crear( @RequestBody Documento_Convenio documento){
        return new ResponseEntity<>(documentoConvenioService.save(documento), HttpStatus.CREATED);
    }
    */
    @PostMapping("/crear")
    public ResponseEntity<?> guardarFichaMedica(@RequestParam("file") MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("No se ha proporcionado ningún archivo.");
        }

        byte[] bytesDocumento = file.getBytes();

        return new ResponseEntity<>(documentoConvenioService.guardarDocumento(bytesDocumento), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id_fichaMedica") Long id){
        documentoConvenioService.delete(id);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Documento_Convenio> actualizar(@RequestBody Documento_Convenio p,@PathVariable Long id){
        Documento_Convenio documentoConvenio = documentoConvenioService.findById(id);
        documentoConvenio.setDocumentoConvenio(p.getDocumentoConvenio());
        return new ResponseEntity<>(documentoConvenioService.save(documentoConvenio), HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Documento_Convenio> buscar(@PathVariable("id_documentoCnv") Long id_documentoCnv) {
        return new ResponseEntity<>(documentoConvenioService.findById(id_documentoCnv), HttpStatus.OK);
    }
}
