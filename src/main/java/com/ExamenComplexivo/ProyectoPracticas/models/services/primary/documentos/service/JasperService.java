package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service;

import javax.servlet.http.HttpServletResponse;

public interface JasperService {

    //Metodo para el reporte de solicitud practicas
    public void reportSolicitudPracticas(HttpServletResponse response, long idSolicitudPracticas);

    public void reportConvocatorias(HttpServletResponse response, long idConvocatorias);

    public void reportSolicitudConvocatoria(HttpServletResponse response, long idSolicitudConvocatoria);

    public void reportAsignacionEspecifico(HttpServletResponse response, long idPractica);

    public void reportAsignacionAcademico(HttpServletResponse response, long idPractica);

    public void reportAnexo1(HttpServletResponse response, long idAnexo1);
    public void reportAnexo2(HttpServletResponse response, long idAnexo2);
    public void reportAnexo3(HttpServletResponse response, long idAnexo3);

    public void reportAnexo5(HttpServletResponse response, long idAnexo5);

    public void reportAnexo6(HttpServletResponse response, long idAnexo6);

    public void reportAnexo7(HttpServletResponse response, long idAnexo7);

    public void reportAnexo8(HttpServletResponse response, long idAnexo8);







}
