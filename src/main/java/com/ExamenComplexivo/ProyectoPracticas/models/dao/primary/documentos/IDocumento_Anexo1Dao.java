package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumento_Anexo1Dao extends JpaRepository<Documento_Anexo1,Long> {
}
