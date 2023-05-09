package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudConvocatoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumento_SolicitudConvocatoriaDao extends JpaRepository <Documento_SolicitudConvocatoria, Long> {

}
