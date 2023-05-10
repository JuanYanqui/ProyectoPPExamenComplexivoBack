package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Convocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISolicitudConvocatoriaDao extends JpaRepository<Solicitud_Convocatoria,Long> {

    @Query("SELECT sc FROM Solicitud_Convocatoria sc JOIN sc.estudiantePracticante ep JOIN ep.usuario_estudiante_practicante us JOIN sc.convocatoria c WHERE sc.checkDirector = true and sc.checkResponsable = false and c.idConvocatorias = :convocatoriaId")
    List<Solicitud_Convocatoria> findByConvocatoriaId(@Param("convocatoriaId") Long convocatoriaId);

    @Query("SELECT sc FROM Solicitud_Convocatoria sc JOIN sc.estudiantePracticante ep JOIN ep.usuario_estudiante_practicante us JOIN sc.convocatoria c WHERE sc.checkDirector = true and sc.checkResponsable= true and c.idConvocatorias = :convocatoriaId")
    List<Solicitud_Convocatoria> findByConvocatoriaIdtrue(@Param("convocatoriaId") Long convocatoriaId);

}
