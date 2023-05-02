package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.JasperService;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

            InputStream reportStream = getClass().getResourceAsStream("/reports/00_SolicitudPracticas.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            // Crea un mapa de parámetros para generar documento con el id que se le proporcione
            Map<String, Object> params = new HashMap<>();

            //parametro que necesita jasper para ejecutar la consulta
            params.put("idSolicitudPracticas", idSolicitudPracticas);


            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=report.pdf");
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
