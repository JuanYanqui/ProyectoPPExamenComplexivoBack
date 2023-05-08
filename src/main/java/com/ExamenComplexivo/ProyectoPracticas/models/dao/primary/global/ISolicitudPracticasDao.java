package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISolicitudPracticasDao extends JpaRepository<Solicitud_Practicas,Long> {
    List<Solicitud_Practicas> findByEstadoSolicitud(boolean estado);

}
