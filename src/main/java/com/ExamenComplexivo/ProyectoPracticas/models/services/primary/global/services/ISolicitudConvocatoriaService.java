package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Convocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;

public interface ISolicitudConvocatoriaService extends IGenericService<Solicitud_Convocatoria,Long> {

    public Solicitud_Convocatoria guardarDocumento(byte[] documento);
}
