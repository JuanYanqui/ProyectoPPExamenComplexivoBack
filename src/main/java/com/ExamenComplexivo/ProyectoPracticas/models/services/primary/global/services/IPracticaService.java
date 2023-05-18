package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo2;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo3;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;

import java.util.List;

public interface IPracticaService extends IGenericService<Practica,Long>{
    List<Practica> getPracticasAprobadas(Long idempresa);

    List<Practica> getPracticasByConvocatoriaId(Long convocatoriaId);

    void actualizarDocumentoAsigTutorAc(Long idDocumentoAsigTutorAcademico, Long idPractica);
    List<Practica>getPracticasBySolicitudPracticasId(Long solicitudpracticasId);

    List<Practica> getPracticasByAcademico(String cedula);

    List<Practica> getPracticasByDocumentoAnexo(Long convocatoriaId, Long idusuario);

    List<Practica> getPracticasByEstudiante(String cedula);

    List<Practica> getPracticasByEstudianteAnexo3(String cedula);


    List<Anexo1> getPracticasByCarrera(String carrera);
    List<Anexo2> getPracticasByCarrera2(String carrera);

    List<Anexo3> getPracticasByCarrera3(String carrera);

    List<Practica> getPracticasByDocumentoAnexo5(Long convocatoriaId, Long idusuario);

    List<Practica> getPracticasByEstudianteAnexo6(String cedula);

    List<Practica>getPracticasByEmpresarialAnexo7(Long idempresa);
    List<Practica>getPracticasBylistarAnexo7(Long tutor);

    List<Practica> getPracticasByEstudianteAnexo8(String cedula);

    Boolean getPracticasByEstadoxUsuario(Long idUsuario);
    Boolean getConvocatoriaLanzada(String nombre_carrera);
}
