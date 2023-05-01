package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudPracticas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumento_SolicitudPracticasDao extends JpaRepository <Documento_SolicitudPracticas, Long> {
}
