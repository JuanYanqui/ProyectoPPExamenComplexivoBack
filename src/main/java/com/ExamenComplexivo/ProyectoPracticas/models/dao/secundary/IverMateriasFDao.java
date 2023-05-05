package com.ExamenComplexivo.ProyectoPracticas.models.dao.secundary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.vermateriasf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IverMateriasFDao extends JpaRepository<vermateriasf, Integer> {

    @Query("SELECT vm.materia_nombre FROM vermateriasf vm JOIN verCarreras vc ON vm.id_carrera = vc.id_carrera WHERE vc.carrera_nombre = ?1")
    List<String> obtenerMateriasPorCarrera(String nombreCarrera);
}
