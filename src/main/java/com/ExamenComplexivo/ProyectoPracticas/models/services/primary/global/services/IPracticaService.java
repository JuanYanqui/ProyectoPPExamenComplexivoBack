package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;

import java.util.List;

public interface IPracticaService extends IGenericService<Practica,Long>{
    List<Practica> getPracticasAprobadas(Long idempresa);

    List<Practica> getPracticasByConvocatoriaId(Long convocatoriaId);

    void actualizarDocumentoAsigTutorAc(Long idDocumentoAsigTutorAcademico, Long idPractica);
    List<Practica>getPracticasBySolicitudPracticasId(Long solicitudpracticasId);

    Boolean getPracticasByEstadoxUsuario(Long idUsuario);
    Boolean getConvocatoriaLanzada(String nombre_carrera);
}
