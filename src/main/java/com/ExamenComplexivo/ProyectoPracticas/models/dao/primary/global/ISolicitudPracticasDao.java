package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.List;
@Transactional
public interface ISolicitudPracticasDao extends JpaRepository<Solicitud_Practicas,Long> {

    @Query("SELECT s FROM Solicitud_Practicas s WHERE s.estadoActividad = true")
    List<Solicitud_Practicas> findByEstadoActividadTrue();
    List<Solicitud_Practicas> findByEstadoSolicitud(boolean estado);

    @Modifying
    @Query("UPDATE Solicitud_Practicas s SET s.documentoSolicitudPracticas.id_documentoSolicitudPrc = :idDocumento WHERE s.idSolicitudPracticas = :idSolicitud")
    void actualizarDocumentoSolicitudPrc(@Param("id_documentoSolicitudPrc") Long id_documentoSolicitudPrc, @Param("idSolicitudPracticas") Long idSolicitudPracticas);

}
