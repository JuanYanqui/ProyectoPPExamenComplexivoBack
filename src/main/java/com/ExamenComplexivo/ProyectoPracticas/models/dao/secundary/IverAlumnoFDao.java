package com.ExamenComplexivo.ProyectoPracticas.models.dao.secundary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.veralumnosf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface IverAlumnoFDao extends JpaRepository<veralumnosf, String> {

	Boolean existsByCedula(String cedula);

}
