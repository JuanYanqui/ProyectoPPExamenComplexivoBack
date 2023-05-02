package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPracticaDao extends JpaRepository<Practica,Long> {
}
