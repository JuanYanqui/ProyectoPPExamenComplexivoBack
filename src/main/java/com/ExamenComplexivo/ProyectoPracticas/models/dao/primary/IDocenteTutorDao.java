package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.DocenteTutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocenteTutorDao extends JpaRepository<DocenteTutor, String> {

	Boolean existsByCedula(String cedula);
}
