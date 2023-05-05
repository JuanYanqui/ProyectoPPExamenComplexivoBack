package com.ExamenComplexivo.ProyectoPracticas.models.dao.secundary;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verCarreras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IverCarrerasfDao extends JpaRepository<verCarreras,Integer> {

    @Query("SELECT c.carrera_nombre FROM verCarreras c")
    List<String> findAllNombres();

}
