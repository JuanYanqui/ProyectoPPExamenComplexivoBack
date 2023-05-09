package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudConvocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudPracticas;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;

public interface IDocumento_SolicitudConvocatoriaService extends IGenericService<Documento_SolicitudConvocatoria, Long> {

    public Documento_SolicitudConvocatoria guardarDocumento(byte[] documento);
}
