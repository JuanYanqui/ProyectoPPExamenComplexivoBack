package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.ResponsableCarrera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResponsableCarreraDao extends JpaRepository<ResponsableCarrera, String> {

	Boolean existsByCedula(String cedula);
}
