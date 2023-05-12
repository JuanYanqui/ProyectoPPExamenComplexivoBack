package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Requerimientos;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRequerimientosDao extends JpaRepository<Requerimientos,Long> {

    @Query("SELECT r FROM Requerimientos r JOIN r.solicitudPracticas soli WHERE soli.idSolicitudPracticas = :idsolicitud")
    List<Requerimientos> findByRequerimientosPorSolicitud(@Param("idsolicitud") Long idsolicitud);
}
