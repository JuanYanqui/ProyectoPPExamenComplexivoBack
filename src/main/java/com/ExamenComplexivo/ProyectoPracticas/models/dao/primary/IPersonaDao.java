package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaDao extends CrudRepository<Persona, Long> {

}
