package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;

public interface IDocumento_ConvenioService extends IGenericService<Documento_Convenio,Long> {

    // Guardar documento
    public Documento_Convenio guardarDocumento(byte[] documento);
}
