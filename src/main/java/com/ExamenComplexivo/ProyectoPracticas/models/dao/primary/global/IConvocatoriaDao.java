package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConvocatoriaDao extends JpaRepository<Convocatorias,Long> {
}
