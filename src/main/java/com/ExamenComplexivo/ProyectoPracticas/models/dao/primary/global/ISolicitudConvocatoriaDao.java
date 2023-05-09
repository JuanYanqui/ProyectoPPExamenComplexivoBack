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
}
