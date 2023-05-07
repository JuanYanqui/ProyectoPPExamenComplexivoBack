package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Detalle_Convenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDetalleConvenioDao extends JpaRepository<Detalle_Convenio,Long> {

    @Query("SELECT d FROM Detalle_Convenio d INNER JOIN Tutor_Empresarial t ON d.empresa.idEmpresa = t.empresa.idEmpresa WHERE t.idTutorEmpresarial = :idTutorEmpresarial")
    List<Detalle_Convenio> BuscarXempresa(@Param("idTutorEmpresarial") Long idTutorEmpresarial);

}
