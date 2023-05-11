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

    @Query("SELECT sc FROM Solicitud_Convocatoria sc JOIN sc.estudiantePracticante ep JOIN ep.usuario_estudiante_practicante us JOIN sc.convocatoria c WHERE sc.checkDirector = true and sc.checkResponsable= true and sc.checkEmpresarial = true and sc.checkPractica = false and c.idConvocatorias = :convocatoriaId")
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

}
