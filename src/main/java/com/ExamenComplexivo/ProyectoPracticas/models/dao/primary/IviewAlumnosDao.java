package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.viewAlumnosI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IviewAlumnosDao extends JpaRepository<viewAlumnosI, String>{

	Boolean existsByCedula(String cedula);
}
