package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Detalle_Convenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDetalleConvenioDao extends JpaRepository<Detalle_Convenio,Long> {

    @Query("SELECT dc FROM Detalle_Convenio dc WHERE dc.empresa.idEmpresa = :idEmpresa")
    List<Detalle_Convenio> findByEmpresaId(@Param("idEmpresa") Long idEmpresa);

}
