package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Estudiante_Practicante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEstudiantePracticanteDao extends JpaRepository<Estudiante_Practicante,Long> {
    @Query("select es from Estudiante_Practicante es join es.usuario_estudiante_practicante us where us.cedula = :cedula")
    List<Estudiante_Practicante> findByCedula(@Param("cedula") String cedula);

    @Query("SELECT e.idEstudiantePracticas FROM Estudiante_Practicante e JOIN e.usuario_estudiante_practicante us WHERE us.cedula = :cedula")
    Long findIdByCedula(@Param("cedula") String cedula);
}
