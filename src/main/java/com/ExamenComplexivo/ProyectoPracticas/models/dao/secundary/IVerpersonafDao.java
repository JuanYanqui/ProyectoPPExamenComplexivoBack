package com.ExamenComplexivo.ProyectoPracticas.models.dao.secundary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verpersonaf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVerpersonafDao extends JpaRepository<verpersonaf, String> {

	Boolean existsByCedula(String cedula);

}
