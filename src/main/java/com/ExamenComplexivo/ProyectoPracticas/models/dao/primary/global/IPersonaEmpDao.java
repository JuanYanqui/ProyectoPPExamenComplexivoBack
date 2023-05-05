package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Personas_empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaEmpDao extends JpaRepository<Personas_empresa,Long> {
}
