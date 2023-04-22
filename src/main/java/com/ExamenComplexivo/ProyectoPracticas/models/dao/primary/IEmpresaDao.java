package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Empresa;
import org.springframework.data.repository.CrudRepository;

public interface IEmpresaDao extends CrudRepository<Empresa, Long> {

}
