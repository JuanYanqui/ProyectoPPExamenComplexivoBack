package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.*;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_AsigTutorAcademico;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;

import java.util.List;

public interface IPracticaService extends IGenericService<Practica,Long>{
    List<Practica> getPracticasAprobadas(Long idempresa);

    List<Practica> getPracticasByConvocatoriaId(Long convocatoriaId);

    void actualizarDocumentoAsigTutorAc(Long idDocumentoAsigTutorAcademico, Long idPractica);
    List<Practica>getPracticasBySolicitudPracticasId(Long solicitudpracticasId);

    List<Convocatorias> getPracticasByAcademico(String cedula);

    List<Convocatorias> findByPracticaAnexoParaResponsableFinal(String cedula);

    List<Practica> getPracticasByDocumentoAnexo(Long convocatoriaId, Long idusuario);

    List<Practica> getPracticasByEstudiante(String cedula);

    List<Practica> getPracticasByEstudianteAnexo3(String cedula);


    List<Anexo1> getPracticasByCarrera(Long idconvo);
    List<Anexo2> getPracticasByCarrera2(Long idconvo);

    List<Anexo3> getPracticasByCarrera3(Long idconvo);

    List<Practica> getPracticasByCarrera4(Long idconvo);

    List<Practica> getPracticasByDocumentoAnexo5(Long convocatoriaId, Long idusuario);

    List<Practica> getPracticasByEstudianteAnexo6(String cedula);

    List<Convocatorias>getPracticasByEmpresarialAnexo7(Long idempresa);
    List<Practica>getPracticasBylistarAnexo7(Long tutor);

    List<Practica> getPracticasByEstudianteAnexo8(String cedula);

    Long getPracticasByConvocatoriaIdAnexo1(Long solicitudpracticasId);

    List<Anexo5> getPracticasByCarrera5(Long idconvo);
    List<Anexo6> getPracticasByCarrera6(Long idconvo);

    List<Anexo7> getPracticasByCarrera7(Long idconvo);

    List<Anexo8> getPracticasByCarrera8(Long idconvo);

    Boolean getPracticasByEstadoxUsuario(Long idUsuario);
    Boolean getConvocatoriaLanzada(String nombre_carrera);
    List<Object[]> getConvocatoriaDisp(String nombre_carrera);
    List<Anexo1> findByDocumentoA1(Long idpractica);

    List<Convocatorias> findByPracticaAnexo1(String cedula);

    List<Convocatorias> findByPracticaAnexoParaAcademixoRecibe(String cedula);
    List<Anexo5> findByDocumentoA5(Long convocatoria);

    List<Anexo6> findByDocumentoA6(Long convocatoria);

    List<Anexo6> findByParaAcademicoDocumentoA6(Long convocatoria);

    List<Anexo7> findByParaEmpresarialDocumentoA7(Long convocatoria);

    List<Anexo8> findByParaAcademicoDocumentoA8(Long convocatoria);

    List<Anexo8> findByParaEmpresarialDocumentoA8(Long convocatoria);
}
