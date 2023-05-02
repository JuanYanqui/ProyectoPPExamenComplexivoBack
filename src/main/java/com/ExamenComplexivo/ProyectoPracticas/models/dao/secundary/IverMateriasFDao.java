package com.ExamenComplexivo.ProyectoPracticas.models.dao.secundary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.vermateriasf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IverMateriasFDao extends JpaRepository<vermateriasf, Integer> {

    Boolean existsById_carrera(Integer id_materia);
}
