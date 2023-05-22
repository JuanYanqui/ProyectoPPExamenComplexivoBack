package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.*;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_AsigTutorAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface IPracticaDao extends JpaRepository<Practica,Long> {
    @Query("SELECT p FROM Practica p JOIN p.solicitudConvocatoria sol  JOIN sol.tutorEmpresarial tuto JOIN tuto.empresa empre WHERE sol.checkPractica = true AND p.checkEmpresarial = true and empre.idEmpresa= :idempresa")
    List<Practica> getPracticasAprobadas(@Param("idempresa") Long idempresa);


    @Query("SELECT p " +
            "FROM Convocatorias c " +
            "JOIN c.solicitudConvocatorias sc JOIN sc.practica p JOIN sc.estudiantePracticante estu JOIN estu.usuario_estudiante_practicante uspra WHERE sc.checkPractica = true AND sc.checkEmpresarial = true AND p.checkAcademico = false AND c.idConvocatorias = :convocatoriaId")
    List<Practica> getPracticasByConvocatoriaId(Long convocatoriaId);

    @Modifying
    @Query("UPDATE Practica s SET s.documentoasignacionaca.id_documentoasigtutoracademico = :id_documentoasigtutoracademico WHERE s.idPractica = :idPractica")
    void actualizarDocumentoAsigTutorAc(@Param("id_documentoasigtutoracademico") Long id_documentoasigtutoracademico, @Param("idPractica") Long idPractica);

    @Modifying
    @Query("UPDATE Practica s SET s.documentoasignacion.id_documentoasigtutorempresarial = :id_documentoasigtutorempresarial WHERE s.idPractica = :idPractica")
    void actualizarDocumentoAsigTutorEmp(@Param("id_documentoasigtutorempresarial") Long id_documentoasigtutorempresarial, @Param("idPractica") Long idPractica);


    //listar usuario por solicitud
    @Query("SELECT p FROM Convocatorias c JOIN c.solicitudConvocatorias sc JOIN sc.practica p JOIN sc.estudiantePracticante estu JOIN estu.usuario_estudiante_practicante uspra JOIN sc.convocatoria con JOIN con.solicitudPracticas solipra WHERE p.estadoPractica =false AND solipra.idSolicitudPracticas = :solicitudpracticasId")
    List<Practica> getPracticasBySolicitudPracticasId(Long solicitudpracticasId);

    @Query("SELECT DISTINCT c FROM Convocatorias c JOIN c.solicitudConvocatorias sc JOIN sc.practica p JOIN p.usuario usu JOIN sc.convocatoria con JOIN con.solicitudPracticas WHERE usu.cedula = :cedula")
    List<Convocatorias> getPracticasByAcademico(String cedula);

    @Query("SELECT p " +
            "FROM Convocatorias c " +
            "JOIN c.solicitudConvocatorias sc JOIN sc.practica p JOIN p.usuario us WHERE sc.checkPractica = true AND sc.checkEmpresarial = true AND p.checkAcademico = true AND p.checkEmpresarial= true AND p.estadoanexo1 = false AND us.idUsuario = :idusuario AND  c.idConvocatorias = :convocatoriaId")
    List<Practica> getPracticasByDocumentoAnexo(Long convocatoriaId, Long idusuario);

    @Query("SELECT p FROM Convocatorias c JOIN c.solicitudConvocatorias sc JOIN sc.practica p JOIN sc.estudiantePracticante estu JOIN estu.usuario_estudiante_practicante uspra WHERE p.estadoanexo1 = true AND p.estadoanexo2 = false AND uspra.cedula = :cedula")
    List<Practica> getPracticasByEstudiante(String cedula);

    @Query("SELECT p FROM Convocatorias c JOIN c.solicitudConvocatorias sc JOIN sc.practica p JOIN sc.estudiantePracticante estu JOIN estu.usuario_estudiante_practicante uspra WHERE p.estadoanexo1 = true AND p.estadoanexo2 = true AND p.estadoanexo3 = false AND uspra.cedula = :cedula")
    List<Practica> getPracticasByEstudianteAnexo3(String cedula);

    @Query("SELECT a FROM Practica p " +
            "JOIN p.anexo1 a " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.convocatoria con " +
            "WHERE a.estado_academico = true AND a.estado_empresarial = true AND con.idConvocatorias = :idconvo")
    List<Anexo1> findByCarreraRecibeAnexo(Long idconvo);

    @Query("SELECT DISTINCT con FROM Practica p " +
            "JOIN p.anexo1 a " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.convocatoria con " +
            "JOIN con.solicitudPracticas soliprac " +
            "JOIN soli.responsablePPP respo " +
            "JOIN respo.usuario_responsable usu WHERE usu.cedula = :cedula")
    List<Convocatorias> findByPracticaAnexoParaResponsableFinal(String cedula);

    @Query("SELECT a FROM Practica p " +
            "JOIN p.anexo1 a " +
            "JOIN a.documentoAnexo1 doc1 " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.convocatoria con " +
            "JOIN p.tutorEmpresarial tuto " +
            "JOIN tuto.usuario_empresarial usuem " +
            "WHERE a.estado_academico = true AND a.estado_empresarial = false AND con.idConvocatorias = :idpractica")
    List<Anexo1> findByDocumentoA1(Long idpractica);

    @Query("SELECT DISTINCT con FROM Practica p " +
            "JOIN p.anexo1 a " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.convocatoria con " +
            "JOIN con.solicitudPracticas soliprac " +
            "JOIN p.tutorEmpresarial tuto " +
            "JOIN tuto.usuario_empresarial usuem " +
            "WHERE usuem.cedula = :cedula")
    List<Convocatorias> findByPracticaAnexo1(String cedula);

    @Query("SELECT DISTINCT con FROM Practica p " +
            "JOIN p.anexo1 a " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.convocatoria con " +
            "JOIN con.solicitudPracticas soliprac " +
            "JOIN p.usuario usu " +
            "WHERE usu.cedula = :cedula")
    List<Convocatorias> findByPracticaAnexoParaAcademixoRecibe(String cedula);

    @Query("SELECT a FROM Practica p " +
            "JOIN p.anexo2 a " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.convocatoria con " +
            "WHERE  con.idConvocatorias = :idconvo")
    List<Anexo2> findByCarreraRecibeAnexo2(Long idconvo);

    @Query("SELECT a FROM Practica p " +
            "JOIN p.anexo5 a " +
            "JOIN a.documentoAnexo5 doc5 " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.convocatoria con " +
            "JOIN p.tutorEmpresarial tuto " +
            "JOIN tuto.usuario_empresarial usuem " +
            "WHERE a.estado_academico = true AND a.estado_empresarial = false AND con.idConvocatorias = :convocatoria")
    List<Anexo5> findByDocumentoA5(Long convocatoria);

    @Query("SELECT a FROM Practica p " +
            "JOIN p.anexo3 a " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.convocatoria con " +
            "WHERE  con.idConvocatorias = :idconvo")
    List<Anexo3> findByCarreraRecibeAnexo3(Long idconvo);

    @Query("SELECT p FROM Practica p " +
            "JOIN p.documentoasignacionaca a " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.convocatoria con " +
            "WHERE  con.idConvocatorias = :idconvo")
    List<Practica> findByCarreraRecibeAnexo4(Long idconvo);

    @Query("SELECT a FROM Practica p " +
            "JOIN p.anexo5 a " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.convocatoria con " +
            "WHERE  a.estado_academico = true AND a.estado_empresarial = true AND con.idConvocatorias = :idconvo")
    List<Anexo5> findByCarreraRecibeAnexo5(Long idconvo);

    @Query("SELECT a FROM Practica p " +
            "JOIN p.anexo6 a " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.convocatoria con " +
            "WHERE  a.estado_academico = true AND a.estado_estudiante = true AND a.estado_especifico = true AND con.idConvocatorias = :idconvo")
    List<Anexo6> findByCarreraRecibeAnexo6(Long idconvo);

    @Query("SELECT a FROM Practica p " +
            "JOIN p.anexo6 a " +
            "JOIN a.documento_anexo6 doc6 " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.convocatoria con " +
            "JOIN p.tutorEmpresarial tuto " +
            "JOIN tuto.usuario_empresarial usuem " +
            "WHERE  a.estado_estudiante = true AND a.estado_academico = true AND a.estado_especifico = false AND con.idConvocatorias = :convocatoria")
    List<Anexo6> findByDocumentoA6(Long convocatoria);

    @Query("SELECT a FROM Practica p " +
            "JOIN p.anexo6 a " +
            "JOIN a.documento_anexo6 doc6 " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.convocatoria con " +
            "JOIN p.tutorEmpresarial tuto " +
            "JOIN tuto.usuario_empresarial usuem " +
            "WHERE  a.estado_estudiante = true AND a.estado_academico = false AND con.idConvocatorias = :convocatoria")
    List<Anexo6> findByParaAcademicoDocumentoA6(Long convocatoria);


    @Query("SELECT a FROM Practica p " +
            "JOIN p.anexo7 a " +
            "JOIN a.documentoAnexo7 doc7 " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.convocatoria con " +
            "JOIN p.tutorEmpresarial tuto " +
            "JOIN tuto.usuario_empresarial usuem " +
            "WHERE   a.estado_especifico = true AND a.estado_academico = false AND con.idConvocatorias = :convocatoria")
    List<Anexo7> findByParaEmpresarialDocumentoA7(Long convocatoria);


    @Query("SELECT a FROM Practica p " +
            "JOIN p.anexo8 a " +
            "JOIN a.documentoAnexo8 doc8 " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.convocatoria con " +
            "JOIN p.tutorEmpresarial tuto " +
            "JOIN tuto.usuario_empresarial usuem " +
            "WHERE   a.estado_estudiante= true AND a.estado_especifico = false AND a.estado_academico = false AND con.idConvocatorias = :convocatoria")
    List<Anexo8> findByParaAcademicoDocumentoA8(Long convocatoria);

    @Query("SELECT a FROM Practica p " +
            "JOIN p.anexo8 a " +
            "JOIN a.documentoAnexo8 doc8 " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.convocatoria con " +
            "JOIN p.tutorEmpresarial tuto " +
            "JOIN tuto.usuario_empresarial usuem " +
            "WHERE a.estado_estudiante= true AND a.estado_especifico = false AND a.estado_academico = true AND con.idConvocatorias = :convocatoria")
    List<Anexo8> findByParaEmpresarialDocumentoA8(Long convocatoria);

    @Query("SELECT a FROM Practica p " +
            "JOIN p.anexo7 a " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.convocatoria con " +
            "WHERE con.idConvocatorias = :idconvo")
    List<Anexo7> findByCarreraRecibeAnexo7(Long idconvo);

    @Query("SELECT a FROM Practica p " +
            "JOIN p.anexo8 a " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.convocatoria con " +
            "WHERE con.idConvocatorias = :idconvo")
    List<Anexo8> findByCarreraRecibeAnexo8(Long idconvo);

    @Query("SELECT p " +
            "FROM Convocatorias c " +
            "JOIN c.solicitudConvocatorias sc JOIN sc.practica p JOIN p.usuario us WHERE sc.checkPractica = true AND sc.checkEmpresarial = true AND p.checkAcademico = true AND p.checkEmpresarial= true AND p.estadoanexo1 = true AND p.estadoanexo2 = true AND p.estadoanexo3 = true AND p.estadoanexo5 = false AND us.idUsuario = :idusuario AND  c.idConvocatorias = :convocatoriaId")
    List<Practica> getPracticasByDocumentoAnexo5(Long convocatoriaId, Long idusuario);

    @Query("SELECT p FROM Convocatorias c JOIN c.solicitudConvocatorias sc JOIN sc.practica p JOIN sc.estudiantePracticante estu JOIN estu.usuario_estudiante_practicante uspra WHERE p.estadoanexo1 = true AND p.estadoanexo2 = true AND p.estadoanexo3 = true AND p.estadoanexo5 = true  AND uspra.cedula = :cedula")
    List<Practica> getPracticasByEstudianteAnexo6(String cedula);

    @Query("SELECT DISTINCT c FROM Convocatorias c JOIN c.solicitudConvocatorias sc JOIN sc.practica p JOIN sc.tutorEmpresarial tuto JOIN tuto.empresa empre WHERE p.estadoanexo1 = true AND p.estadoanexo2 = true AND p.estadoanexo3 = true AND p.estadoanexo5 = true  AND p.estadoanexo6 =true AND empre.idEmpresa = :idempresa")
    List<Convocatorias> getPracticasByEmpresarialAnexo7(Long idempresa);

    @Query("SELECT p FROM Convocatorias c JOIN c.solicitudConvocatorias sc JOIN sc.practica p JOIN sc.tutorEmpresarial tuto JOIN tuto.empresa empre WHERE p.estadoanexo1 = true AND p.estadoanexo2 = true AND p.estadoanexo3 = true AND p.estadoanexo5 = true  AND p.estadoanexo6 =true AND p.estadoanexo7 = false AND  tuto.idTutorEmpresarial = :tutor")
    List<Practica> getPracticasBylistarAnexo7(Long tutor);

    @Query("SELECT p FROM Convocatorias c JOIN c.solicitudConvocatorias sc JOIN sc.practica p JOIN sc.estudiantePracticante estu JOIN estu.usuario_estudiante_practicante uspra WHERE p.estadoanexo1 = true AND p.estadoanexo2 = true AND p.estadoanexo3 = true AND p.estadoanexo5 = true  AND p.estadoanexo6 =true AND p.estadoanexo7 = true AND p.estadoanexo8 = false AND uspra.cedula = :cedula")
    List<Practica> getPracticasByEstudianteAnexo8(String cedula);

    @Query("SELECT p.idPractica " +
            "FROM Convocatorias c " +
            "JOIN c.solicitudConvocatorias sc JOIN sc.practica p JOIN sc.estudiantePracticante estu JOIN estu.usuario_estudiante_practicante uspra WHERE sc.idSolicitudConvocatoria = :convocatoriaId")
    Long getPracticasByConvocatoriaIdAnexo1(Long convocatoriaId);
    
    //Query para devolver los estudiantes asignados a un tutor academico
    @Query("SELECT c.nombreConvocatoria, CONCAT(u2.nombres, ' ', u2.apellidos) as estudiante, u2.carrera, p.fechaInicio as Inicio, p.fechaFin AS Fin " +
            "FROM Practica p " +
            "INNER JOIN p.usuario u " +
            "INNER JOIN p.solicitudConvocatoria s " +
            "INNER JOIN s.convocatoria c " +
            "INNER JOIN s.estudiantePracticante e " +
            "INNER JOIN e.usuario_estudiante_practicante u2 " +
            "WHERE p.checkAcademico = true and u.cedula = :cedulaTutorAcademico")
    List<Object[]> findPracticasByCedulaTutorAcademico(@Param("cedulaTutorAcademico") String cedulaTutorAcademico);


//    listar usuario por solicitud


    //moviles
    @Query("SELECT p.checkEmpresarial FROM Convocatorias c JOIN c.solicitudConvocatorias sc JOIN sc.practica p JOIN sc.estudiantePracticante estu JOIN " +
            "estu.usuario_estudiante_practicante uspra JOIN sc.convocatoria con JOIN " +
            "con.solicitudPracticas solipra WHERE p.checkEmpresarial = true and uspra.idUsuario = :idUsuario")
    Boolean getPracticasByEstadoxUsuario(Long idUsuario);

    @Query("SELECT c.estadoConvocatoria FROM Convocatorias c JOIN c.solicitudPracticas s where c.estadoConvocatoria = true and s.nombre_carrera = :nombre_carrera")
    Boolean getConvocatoriaLanzada(String nombre_carrera);
    @Query("SELECT c.nombreConvocatoria, c.fechaPublicacion, c.fechaExpiracion " +
            "FROM Convocatorias c JOIN c.solicitudPracticas s " +
            "where c.estadoConvocatoria = true and s.nombre_carrera = :nombre_carrera")
    List<Object[]> getConvocatoriaDisp(String nombre_carrera);
}
