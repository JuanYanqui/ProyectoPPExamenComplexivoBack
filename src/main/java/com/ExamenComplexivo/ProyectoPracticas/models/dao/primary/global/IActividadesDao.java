package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Actividades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActividadesDao extends JpaRepository<Actividades,Long> {
    @Query("SELECT ac FROM Convocatorias con JOIN con.solicitudPracticas soli JOIN soli.requerimientos re JOIN re.actividades ac WHERE con.idConvocatorias = :convocatoriaId")
    List<Actividades> findActividadesByConvocatoriaId(@Param("convocatoriaId") Long convocatoriaId);

}
