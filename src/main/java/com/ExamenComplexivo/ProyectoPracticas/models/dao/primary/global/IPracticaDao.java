package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo2;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo3;
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
            "JOIN soli.responsablePPP r " +
            "WHERE a.estado_academico = true AND r.carrera = :carrera")
    List<Anexo1> findByCarreraRecibeAnexo(String carrera);

    @Query("SELECT a FROM Practica p " +
            "JOIN p.anexo2 a " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.responsablePPP r " +
            "WHERE  r.carrera = :carrera")
    List<Anexo2> findByCarreraRecibeAnexo2(String carrera);

    @Query("SELECT a FROM Practica p " +
            "JOIN p.anexo3 a " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.responsablePPP r " +
            "WHERE  r.carrera = :carrera")
    List<Anexo3> findByCarreraRecibeAnexo3(String carrera);

    @Query("SELECT p FROM Practica p " +
            "JOIN p.documentoasignacionaca a " +
            "JOIN p.solicitudConvocatoria soli " +
            "JOIN soli.responsablePPP r " +
            "WHERE  r.carrera = :carrera")
    List<Practica> findByCarreraRecibeAnexo4(String carrera);

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
}
