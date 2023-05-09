package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IConvenioDao extends JpaRepository<Convenio, Long> {

    @Modifying
    @Query("UPDATE Convenio s SET s.documentoConvenio.id_documentoCnv = :id_documentoCnv WHERE s.idConvenio = :idConvenio")
    void actualizarDocumentoConvenio(@Param("id_documentoCnv") Long id_documentoCnv, @Param("idConvenio") Long idConvenio);


}
