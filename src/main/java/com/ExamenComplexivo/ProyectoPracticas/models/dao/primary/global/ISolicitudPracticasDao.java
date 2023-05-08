package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISolicitudPracticasDao extends JpaRepository<Solicitud_Practicas,Long> {

    @Query("SELECT s FROM Solicitud_Practicas s WHERE s.estadoActividad = true")
    List<Solicitud_Practicas> findByEstadoActividadTrue();

}
