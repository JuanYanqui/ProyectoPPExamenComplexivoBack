package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Convocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;

import java.util.List;

public interface ISolicitudConvocatoriaService extends IGenericService<Solicitud_Convocatoria,Long> {

    public Solicitud_Convocatoria guardarDocumento(byte[] documento);

    List<Solicitud_Convocatoria> getSolicitudesPorConvocatoria(Long convocatoriaId);

    List<Solicitud_Convocatoria> getSolicitudesPorConvocatoriatrue(Long convocatoriaId);

    List<Solicitud_Convocatoria> getSolicitudesPorConvocatoriatruepractica(Long convocatoriaId);

    int getCountByConvocatoriaAndEstudiante(Long convocatoriaId, Long estudiantePracticasId);

    List<Solicitud_Convocatoria> findByConvocatoriasDirector(Long convocatoriaId);

    List<Solicitud_Convocatoria> findByConvocatoriasDirectorFalse(Long convocatoriaId);
    List<Solicitud_Convocatoria> findByConvocatoriasTutor(Long convocatoriaId);

    List<Solicitud_Convocatoria> findByConvocatoriasTutorFalse(Long convocatoriaId);

}
