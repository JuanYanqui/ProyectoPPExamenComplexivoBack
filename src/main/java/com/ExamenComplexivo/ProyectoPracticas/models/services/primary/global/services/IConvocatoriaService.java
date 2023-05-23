package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;

import java.util.List;

public interface IConvocatoriaService extends IGenericService<Convocatorias,Long>{

    //Guardamos el documento de convocatoria
    public Convocatorias guardarDocumento(byte[] documento);

    Long findDocumentoIdByConvocatoriaId(Long id);

    List<Convocatorias> buscarConvocatoriasConPractica();

    ///para buscar el doc de convocatoria
    List<Convocatorias> findByConvocatoriaporCarrera(String carrera);
    List<Convocatorias> findByConvocatoriaporSolicitudP(Long idSolicitudPracticas);

    List<Convocatorias> buscarsoliporempresacovocatoria(Long idempresa);

    List<Convocatorias> buscarsoliporempresacovocatoriaconestadosolicitud(Long idempresa);

    List<Convocatorias> findByConvocatoriaporCarreraPractica(String carrera);

    List<Object[]> buscarConvocatoriasC();
    List<Convocatorias> BuscarConvocatoriaporCarrera(String carrera);
}
