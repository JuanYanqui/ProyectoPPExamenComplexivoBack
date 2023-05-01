package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl.JasperServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/jasperReport")
public class JasperController {
    @Autowired
    private JasperServiceImp jasperServiceImp;


    //Metodo para descargar reporte de solicitu de practicas 
    @GetMapping("/descargar/{idSolicitudPracticas}")
    public void generateReportUser(HttpServletResponse response, @PathVariable("idSolicitudPracticas") Long idSolicitudPracticas) {
        try {
            jasperServiceImp.reportSolicitudPracticas(response,idSolicitudPracticas);
        }catch (Exception e){
            System.out.println(e);
        }

    }

}
