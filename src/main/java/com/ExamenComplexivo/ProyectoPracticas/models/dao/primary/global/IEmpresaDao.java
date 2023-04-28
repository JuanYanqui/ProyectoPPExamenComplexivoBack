package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpresaDao extends JpaRepository<Empresa,Long> {
}
