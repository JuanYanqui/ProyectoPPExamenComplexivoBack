package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Actividades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActividadesDao extends JpaRepository<Actividades,Long> {
}
