package com.ExamenComplexivo.ProyectoPracticas.models.dao.secundary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verdocentef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IverDocentesFDao extends JpaRepository<verdocentef, String> {
    Boolean existsByCedula(String cedula);

    @Query("SELECT d.nombres ||' '||d.apellidos as nombres FROM verdocentef d")
    List<String> findAllNombresDocentes();
}


