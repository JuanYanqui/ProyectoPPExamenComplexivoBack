package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPracticaDao extends JpaRepository<Practica,Long> {
    @Query("SELECT p FROM Practica p JOIN p.solicitudConvocatoria sol  WHERE sol.checkPractica = true AND p.checkEmpresarial = true")
    List<Practica> getPracticasAprobadas();
}
