package com.ExamenComplexivo.ProyectoPracticas.models.dao.secundary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verdocentef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IverDocentesFDao extends JpaRepository<verdocentef, String> {
    Boolean existsByCedula(String cedula);
}
