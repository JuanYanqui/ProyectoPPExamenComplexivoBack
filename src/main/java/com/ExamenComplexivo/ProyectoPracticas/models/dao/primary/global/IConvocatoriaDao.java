package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IConvocatoriaDao extends JpaRepository<Convocatorias,Long> {

    @Modifying
    @Query("UPDATE Convocatorias s SET s.documentoConvocatoria.id_documentoConvocatoria = :id_documentoConvocatoria WHERE s.idConvocatorias = :idConvocatorias")
    void actualizarDocumentoConvocatoria(@Param("id_documentoConvocatoria") Long id_documentoConvocatoria, @Param("idConvocatorias") Long idConvocatorias);

}
