package com.ExamenComplexivo.ProyectoPracticas.models.dao.secundary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verestudiantef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IverEstudianteFDao extends JpaRepository<verestudiantef, String> {

	Boolean existsByCedula(String cedula);

}
