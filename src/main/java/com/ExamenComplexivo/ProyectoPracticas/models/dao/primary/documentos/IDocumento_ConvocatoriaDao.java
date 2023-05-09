package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Convocatoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumento_ConvocatoriaDao extends JpaRepository <Documento_Convocatoria, Long> {
}
