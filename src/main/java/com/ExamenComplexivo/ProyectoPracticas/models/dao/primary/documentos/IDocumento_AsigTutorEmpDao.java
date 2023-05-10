package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_AsigTutorEmpresarial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumento_AsigTutorEmpDao extends JpaRepository<Documento_AsigTutorEmpresarial,Long> {
}
