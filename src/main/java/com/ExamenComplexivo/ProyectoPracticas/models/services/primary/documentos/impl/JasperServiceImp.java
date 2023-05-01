package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.JasperService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
@Service
public class JasperServiceImp implements JasperService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void reportSolicitudPracticas(HttpServletResponse response, long idSolicitudPracticas) {
        try {
            //Se encuentra entre las carpetas el nombre del archivo de jasper
            InputStream reportStream = this.getClass().getResourceAsStream("/reports/00_SolicitudPracticas.jrxml");

            // Crea un mapa de parámetros para generar documento con el id que se le proporcione
            Map<String, Object> params = new HashMap<>();

            //parametro que necesita jasper para ejecutar la consulta
            params.put("id_solicitud", idSolicitudPracticas);


            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=report.pdf");
            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
