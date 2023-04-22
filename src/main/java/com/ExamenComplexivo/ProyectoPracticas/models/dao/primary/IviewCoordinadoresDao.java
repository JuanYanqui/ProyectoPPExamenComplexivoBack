package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.viewCoordinadoresI;
import org.springframework.data.repository.CrudRepository;

public interface IviewCoordinadoresDao extends CrudRepository<viewCoordinadoresI, String>{

	Boolean existsByCedula(String cedula);
}
