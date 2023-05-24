package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Convocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ISolicitudConvocatoriaDao extends JpaRepository<Solicitud_Convocatoria,Long> {

    //Metodo para hacer una actualizacion de la FK del documento para cuando se sube el documento.
    @Modifying
    @Query("UPDATE Solicitud_Convocatoria s SET s.documentoSolicitudConvocatoria.id_documentoSolicitudConvocatoria = :id_documentoSolicitudConvocatoria WHERE s.idSolicitudConvocatoria = :idSolicitudConvocatoria")
    void actualizarDocumentoSolicitudCnv(@Param("id_documentoSolicitudConvocatoria") Long id_documentoSolicitudConvocatoria, @Param("idSolicitudConvocatoria") Long idSolicitudConvocatoria);
    @Query("SELECT sc FROM Solicitud_Convocatoria sc JOIN sc.estudiantePracticante ep JOIN ep.usuario_estudiante_practicante us JOIN sc.convocatoria c WHERE sc.checkDirector = true and sc.checkResponsable = false and c.idConvocatorias = :convocatoriaId")
    List<Solicitud_Convocatoria> findByConvocatoriaId(@Param("convocatoriaId") Long convocatoriaId);

    @Query("SELECT sc FROM Solicitud_Convocatoria sc JOIN sc.estudiantePracticante ep JOIN ep.usuario_estudiante_practicante us JOIN sc.convocatoria c WHERE sc.checkDirector = true and sc.checkResponsable= true and c.idConvocatorias = :convocatoriaId")
    List<Solicitud_Convocatoria> findByConvocatoriaIdtrue(@Param("convocatoriaId") Long convocatoriaId);

    @Query("SELECT sc FROM Solicitud_Convocatoria sc JOIN sc.estudiantePracticante ep JOIN ep.usuario_estudiante_practicante us JOIN sc.convocatoria c JOIN sc.tutorEmpresarial tuto JOIN tuto.empresa empre WHERE sc.checkDirector = true and sc.checkResponsable= true and sc.checkEmpresarial = true and sc.checkPractica = false and c.idConvocatorias = :convocatoriaId")
    List<Solicitud_Convocatoria> findByConvocatoriaIdtrueprueba(@Param("convocatoriaId") Long convocatoriaId);


    @Query("SELECT sol FROM Solicitud_Convocatoria sol "
            + "JOIN sol.estudiantePracticante es "
            + "JOIN es.usuario_estudiante_practicante us "
            + "JOIN sol.convocatoria con "
            + "JOIN con.solicitudPracticas solp "
            + "WHERE sol.checkResponsable = true "
            + "AND solp.idSolicitudPracticas = :idSolicitudPracticas")

    List<Solicitud_Convocatoria> findByCheckResponsableAndIdSolicitudPracticas(
            @Param("idSolicitudPracticas") Long idSolicitudPracticas);

    //Metodo para buscar el id documento solicitud convocatoria
    @Query("SELECT doc.id_documentoSolicitudConvocatoria FROM Solicitud_Convocatoria con JOIN con.documentoSolicitudConvocatoria doc WHERE con.idSolicitudConvocatoria = :id")
    Long findDocumentoIdBySolicitudCId(@Param("id")Long id);


    @Query(value = "SELECT COUNT(*) FROM solicitud_convocatoria WHERE idconvocatorias = ?1 AND idestudiantepracticas = ?2", nativeQuery = true)
    int getCountByConvocatoriaAndEstudiante(Long convocatoriaId, Long estudiantePracticasId);


    @Query("SELECT sc FROM Solicitud_Convocatoria sc JOIN sc.estudiantePracticante ep JOIN ep.usuario_estudiante_practicante us JOIN sc.convocatoria c WHERE  sc.checkDirector =false and sc.estadoestudiante = false and c.idConvocatorias = :convocatoriaId")
    List<Solicitud_Convocatoria> findByConvocatoriasDirector(@Param("convocatoriaId") Long convocatoriaId);

    @Query("SELECT sc FROM Solicitud_Convocatoria sc JOIN sc.estudiantePracticante ep JOIN ep.usuario_estudiante_practicante us JOIN sc.convocatoria c WHERE  sc.checkDirector =true and c.idConvocatorias = :convocatoriaId")
    List<Solicitud_Convocatoria> findByConvocatoriasDirectorFalse(@Param("convocatoriaId") Long convocatoriaId);

    @Query("SELECT sc FROM Solicitud_Convocatoria sc JOIN sc.estudiantePracticante ep JOIN ep.usuario_estudiante_practicante us JOIN sc.convocatoria c WHERE  sc.checkEmpresarial =false and c.idConvocatorias = :convocatoriaId")
    List<Solicitud_Convocatoria> findByConvocatoriasTutor(@Param("convocatoriaId") Long convocatoriaId);

    @Query("SELECT sc FROM Solicitud_Convocatoria sc JOIN sc.estudiantePracticante ep JOIN ep.usuario_estudiante_practicante us JOIN sc.convocatoria c WHERE  sc.checkEmpresarial =true and c.idConvocatorias = :convocatoriaId")
    List<Solicitud_Convocatoria> findByConvocatoriasTutorFalse(@Param("convocatoriaId") Long convocatoriaId);

    //Query para sacar la lista de los estudiantes aprobados segun el check del responsable y del tutor que este logeado ese momento
    @Query("SELECT c.nombreConvocatoria, u.cedula, CONCAT(u.nombres, '', u.apellidos) AS nombres, u.carrera, s.fechaAprobacion " +
            "FROM Solicitud_Convocatoria s " +
            "INNER JOIN s.convocatoria c " +
            "INNER JOIN s.estudiantePracticante e " +
            "INNER JOIN e.usuario_estudiante_practicante u " +
            "WHERE s.checkResponsable = true AND s.tutorEmpresarial.idTutorEmpresarial = :idTutorEmpresarial")
    List<Object[]> obtenerEstudiantesAprobados(@Param("idTutorEmpresarial") Long idTutorEmpresarial);

    @Query("SELECT sc FROM Solicitud_Convocatoria sc JOIN sc.estudiantePracticante ep JOIN ep.usuario_estudiante_practicante us JOIN sc.convocatoria c JOIN sc.tutorEmpresarial tuto JOIN tuto.empresa empre JOIN sc.practica p WHERE p.estadoanexo1 = false and c.idConvocatorias = :convocatoriaId")
    List<Solicitud_Convocatoria> findByAnexo1(@Param("convocatoriaId") Long convocatoriaId);

    @Query("SELECT sc FROM Solicitud_Convocatoria sc JOIN sc.estudiantePracticante ep JOIN ep.usuario_estudiante_practicante us JOIN sc.convocatoria c JOIN sc.tutorEmpresarial tuto JOIN tuto.empresa empre JOIN sc.practica p WHERE p.estadoanexo1 = true and p.estadoanexo2 = true and p.estadoanexo3 = true and p.estadoanexo5 = false and c.idConvocatorias = :convocatoriaId")
    List<Solicitud_Convocatoria> findByAnexo5(@Param("convocatoriaId") Long convocatoriaId);

    @Query("SELECT sc FROM Solicitud_Convocatoria sc JOIN sc.estudiantePracticante ep JOIN ep.usuario_estudiante_practicante us JOIN sc.convocatoria c JOIN sc.tutorEmpresarial tuto JOIN tuto.empresa empre JOIN sc.practica p WHERE p.estadoanexo1 = true and p.estadoanexo2 = true and p.estadoanexo3 = true and p.estadoanexo5 = true and p.estadoanexo6 = true and p.estadoanexo7 = false and c.idConvocatorias = :convocatoriaId")
    List<Solicitud_Convocatoria> findByAnexo7(@Param("convocatoriaId") Long convocatoriaId);

    @Query("SELECT sc FROM Solicitud_Convocatoria sc JOIN sc.estudiantePracticante ep JOIN ep.usuario_estudiante_practicante us WHERE sc.estadoestudiante = false and us.cedula = :cedula ")
    List<Solicitud_Convocatoria> findSolicitudConvocatoriaPorEstudianteSinCancelar(@Param("cedula") String cedula);

    @Query("SELECT sc FROM Solicitud_Convocatoria sc JOIN sc.estudiantePracticante ep JOIN ep.usuario_estudiante_practicante us WHERE sc.estadoestudiante = true and us.cedula = :cedula ")
    List<Solicitud_Convocatoria> findSolicitudConvocatoriaPorEstudianteCancelado(@Param("cedula") String cedula);
}
