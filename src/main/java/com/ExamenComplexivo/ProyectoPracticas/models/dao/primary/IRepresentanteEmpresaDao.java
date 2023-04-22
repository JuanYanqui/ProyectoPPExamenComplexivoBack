package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.RepresentanteEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepresentanteEmpresaDao extends JpaRepository<RepresentanteEmpresa, String> {

	Boolean existsByCedula(String cedula);
}
