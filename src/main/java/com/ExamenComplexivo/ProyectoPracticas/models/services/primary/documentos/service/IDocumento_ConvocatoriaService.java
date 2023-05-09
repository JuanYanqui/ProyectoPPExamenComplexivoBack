package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Convocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;

public interface IDocumento_ConvocatoriaService extends IGenericService <Documento_Convocatoria, Long> {

    public Documento_Convocatoria guardarDocumento(byte[] documento);
}
