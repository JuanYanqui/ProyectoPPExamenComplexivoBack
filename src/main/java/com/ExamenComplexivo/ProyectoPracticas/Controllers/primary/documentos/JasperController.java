package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl.JasperServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
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

    @GetMapping("/generar/{idConvocatorias}")
    public void generateConvocatorias(HttpServletResponse response, @PathVariable("idConvocatorias") Long idConvocatorias) {
        try {
            jasperServiceImp.reportConvocatorias(response,idConvocatorias);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    @GetMapping("/obtener/{idSolicitudConvocatoria}")
    public void generateSolicitudConvocatorias(HttpServletResponse response, @PathVariable("idSolicitudConvocatoria") Long idSolicitudConvocatoria) {
        try {
            jasperServiceImp.reportSolicitudConvocatoria(response,idSolicitudConvocatoria);
        }catch (Exception e){
            System.out.println(e);
        }

    }


    @GetMapping("/especifico/{idPractica}")

    public void generateAsignacionEspecifico(HttpServletResponse response, @PathVariable("idPractica") Long idPractica) {
        try {
            jasperServiceImp.reportAsignacionEspecifico(response,idPractica);
        }catch (Exception e){
            System.out.println(e);
        }

    }


    @GetMapping("/academico/{idPractica}")

    public void generateAsignacionAcademico(HttpServletResponse response, @PathVariable("idPractica") Long idPractica) {
        try {
            jasperServiceImp.reportAsignacionAcademico(response,idPractica);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    @GetMapping("/anexo1/{idAnexo1}")

    public void generateAnexo1(HttpServletResponse response, @PathVariable("idAnexo1") Long idAnexo1) {
        try {
            jasperServiceImp.reportAnexo1(response,idAnexo1);
        }catch (Exception e){
            System.out.println(e);
        }

    }


    @GetMapping("/anexo2/{idAnexo2}")

    public void generateAnexo2(HttpServletResponse response, @PathVariable("idAnexo2") Long idAnexo2) {
        try {
            jasperServiceImp.reportAnexo2(response,idAnexo2);
        }catch (Exception e){
            System.out.println(e);
        }

    }


    @GetMapping("/anexo3/{idAnexo3}")

    public void generateAnexo3(HttpServletResponse response, @PathVariable("idAnexo3") Long idAnexo3) {
        try {
            jasperServiceImp.reportAnexo3(response,idAnexo3);
        }catch (Exception e){
            System.out.println(e);
        }

    }


    @GetMapping("/anexo5/{idAnexo5}")

    public void generateAnexo5(HttpServletResponse response, @PathVariable("idAnexo5") Long idAnexo5) {
        try {
            jasperServiceImp.reportAnexo5(response,idAnexo5);
        }catch (Exception e){
            System.out.println(e);
        }

    }


    @GetMapping("/anexo6/{idAnexo6}")

    public void generateAnexo6(HttpServletResponse response, @PathVariable("idAnexo6") Long idAnexo6) {
        try {
            jasperServiceImp.reportAnexo6(response,idAnexo6);
        }catch (Exception e){
            System.out.println(e);
        }

    }


    @GetMapping("/anexo7/{idAnexo7}")

    public void generateAnexo7(HttpServletResponse response, @PathVariable("idAnexo7") Long idAnexo7) {
        try {
            jasperServiceImp.reportAnexo7(response,idAnexo7);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    @GetMapping("/anexo8/{idAnexo8}")

    public void generateAnexo8(HttpServletResponse response, @PathVariable("idAnexo8") Long idAnexo8) {
        try {
            jasperServiceImp.reportAnexo8(response,idAnexo8);
        }catch (Exception e){
            System.out.println(e);
        }

    }

}
