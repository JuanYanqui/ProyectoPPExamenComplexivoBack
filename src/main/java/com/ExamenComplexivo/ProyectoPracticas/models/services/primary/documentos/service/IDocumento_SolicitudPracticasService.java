package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudPracticas;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;

public interface IDocumento_SolicitudPracticasService extends IGenericService<Documento_SolicitudPracticas, Long> {

    public Documento_SolicitudPracticas guardarDocumento(byte[] documento);
}
