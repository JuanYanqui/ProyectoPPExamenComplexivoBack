package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;

public interface IConvocatoriaService extends IGenericService<Convocatorias,Long>{

    //Guardamos el documento de convocatoria
    public Convocatorias guardarDocumento(byte[] documento);

    Long findDocumentoIdByConvocatoriaId(Long id);
}
