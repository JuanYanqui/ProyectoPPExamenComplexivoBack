package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service;

import javax.servlet.http.HttpServletResponse;

public interface JasperService {

    //Metodo para el reporte de solicitud practicas
    public void reportSolicitudPracticas(HttpServletResponse response, long idSolicitudPracticas);

    public void reportConvocatorias(HttpServletResponse response, long idConvocatorias);

    public void reportSolicitudConvocatoria(HttpServletResponse response, long idSolicitudConvocatoria);
}
