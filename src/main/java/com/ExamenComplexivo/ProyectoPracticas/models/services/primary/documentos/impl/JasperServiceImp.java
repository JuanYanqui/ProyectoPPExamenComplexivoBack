package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.JasperService;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
@Service
public class JasperServiceImp implements JasperService {

    @Autowired
    private DataSource dataSource;

    @Override
    public void reportSolicitudPracticas(HttpServletResponse response, long idSolicitudPracticas) {
        try {

            Connection conn = dataSource.getConnection();

            InputStream reportStream = getClass().getResourceAsStream("/reports/00_Soli.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            // Crea un mapa de parámetros para generar documento con el id que se le proporcione
            Map<String, Object> params = new HashMap<>();

            //parametro que necesita jasper para ejecutar la consulta
            params.put("idSolicitudPracticas", idSolicitudPracticas);


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=SolicitudPracticas.pdf");
            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){

            System.out.println("No encuentra");
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void reportConvocatorias(HttpServletResponse response, long idConvocatorias) {
        try {

            Connection conn = dataSource.getConnection();

            InputStream reportStream = getClass().getResourceAsStream("/reports/Solicitud.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            // Crea un mapa de parámetros para generar documento con el id que se le proporcione
            Map<String, Object> params = new HashMap<>();

            //parametro que necesita jasper para ejecutar la consulta
            params.put("idConvocatorias", idConvocatorias);


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=ConvocatoriaISTA.pdf");
            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){

            System.out.println("No encuentra");
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void reportSolicitudConvocatoria(HttpServletResponse response, long idSolicitudConvocatoria) {
        try {

            Connection conn = dataSource.getConnection();

            InputStream reportStream = getClass().getResourceAsStream("/reports/Solicitud_estudiante.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            // Crea un mapa de parámetros para generar documento con el id que se le proporcione
            Map<String, Object> params = new HashMap<>();

            //parametro que necesita jasper para ejecutar la consulta
            params.put("idSolicitudConvocatoria", idSolicitudConvocatoria);


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=SolicitudConvocatoria.pdf");
            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){

            System.out.println("No encuentra");
            System.out.println(e.getMessage());
        }
    }



    @Override
    public void reportAsignacionEspecifico(HttpServletResponse response, long idPractica) {
        try {

            Connection conn = dataSource.getConnection();

            InputStream reportStream = getClass().getResourceAsStream("/reports/AsignacionEmpecifico.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            // Crea un mapa de parámetros para generar documento con el id que se le proporcione
            Map<String, Object> params = new HashMap<>();

            //parametro que necesita jasper para ejecutar la consulta
            params.put("idPractica", idPractica);


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=AsignacionEspecifico.pdf");
            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){

            System.out.println("No encuentra");
            System.out.println(e.getMessage());
        }
    }



    @Override
    public void reportAsignacionAcademico(HttpServletResponse response, long idPractica) {
        try {

            Connection conn = dataSource.getConnection();

            InputStream reportStream = getClass().getResourceAsStream("/reports/AsignacionAcademico.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            // Crea un mapa de parámetros para generar documento con el id que se le proporcione
            Map<String, Object> params = new HashMap<>();

            //parametro que necesita jasper para ejecutar la consulta
            params.put("idPractica", idPractica);


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=AsignacionAcademico.pdf");
            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){

            System.out.println("No encuentra");
            System.out.println(e.getMessage());
        }
    }



    @Override
    public void reportAnexo1(HttpServletResponse response, long idAnexo1) {
        try {

            Connection conn = dataSource.getConnection();

            InputStream reportStream = getClass().getResourceAsStream("/reports/GeneraAnexo1.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            // Crea un mapa de parámetros para generar documento con el id que se le proporcione
            Map<String, Object> params = new HashMap<>();

            //parametro que necesita jasper para ejecutar la consulta
            params.put("idAnexo1", idAnexo1);


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=Anexo1.pdf");
            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){

            System.out.println("No encuentra");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void reportAnexo2(HttpServletResponse response, long idAnexo2) {
        try {

            Connection conn = dataSource.getConnection();

            InputStream reportStream = getClass().getResourceAsStream("/reports/Anexo 2.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            // Crea un mapa de parámetros para generar documento con el id que se le proporcione
            Map<String, Object> params = new HashMap<>();

            //parametro que necesita jasper para ejecutar la consulta
            params.put("idAnexo2", idAnexo2);


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=Anexo2.pdf");
            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){

            System.out.println("No encuentra");
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void reportAnexo3(HttpServletResponse response, long idAnexo3) {
        try {

            Connection conn = dataSource.getConnection();

            InputStream reportStream = getClass().getResourceAsStream("/reports/Anexo3.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            // Crea un mapa de parámetros para generar documento con el id que se le proporcione
            Map<String, Object> params = new HashMap<>();

            //parametro que necesita jasper para ejecutar la consulta
            params.put("idAnexo3", idAnexo3);


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=Anexo3.pdf");
            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){

            System.out.println("No encuentra");
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void reportAnexo5(HttpServletResponse response, long idAnexo5) {
        try {

            Connection conn = dataSource.getConnection();

            InputStream reportStream = getClass().getResourceAsStream("/reports/Anexo 5.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            // Crea un mapa de parámetros para generar documento con el id que se le proporcione
            Map<String, Object> params = new HashMap<>();

            //parametro que necesita jasper para ejecutar la consulta
            params.put("idAnexo5", idAnexo5);


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=Anexo5.pdf");
            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){

            System.out.println("No encuentra");
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void reportAnexo6(HttpServletResponse response, long idAnexo6) {
        try {

            Connection conn = dataSource.getConnection();

            InputStream reportStream = getClass().getResourceAsStream("/reports/Anexo 6.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            // Crea un mapa de parámetros para generar documento con el id que se le proporcione
            Map<String, Object> params = new HashMap<>();

            //parametro que necesita jasper para ejecutar la consulta
            params.put("idAnexo6", idAnexo6);


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=Anexo6.pdf");
            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){

            System.out.println("No encuentra");
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void reportAnexo7(HttpServletResponse response, long idAnexo7) {
        try {

            Connection conn = dataSource.getConnection();

            InputStream reportStream = getClass().getResourceAsStream("/reports/GeneraAnexo7.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            // Crea un mapa de parámetros para generar documento con el id que se le proporcione
            Map<String, Object> params = new HashMap<>();

            //parametro que necesita jasper para ejecutar la consulta
            params.put("idAnexo7", idAnexo7);


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=Anexo7.pdf");
            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){

            System.out.println("No encuentra");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void reportAnexo8(HttpServletResponse response, long idAnexo8) {
        try {

            Connection conn = dataSource.getConnection();

            InputStream reportStream = getClass().getResourceAsStream("/reports/GeneraAnexo8.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            // Crea un mapa de parámetros para generar documento con el id que se le proporcione
            Map<String, Object> params = new HashMap<>();

            //parametro que necesita jasper para ejecutar la consulta
            params.put("idAnexo8", idAnexo8);


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=Anexo8.pdf");
            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){

            System.out.println("No encuentra");
            System.out.println(e.getMessage());
        }
    }






}
