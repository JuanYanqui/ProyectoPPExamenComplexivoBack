package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Convocatoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISolicitudConvocatoriaDao extends JpaRepository<Solicitud_Convocatoria,Long> {
}
