package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Estudiante_Practicante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstudiantePracticanteDao extends JpaRepository<Estudiante_Practicante,Long> {
}
