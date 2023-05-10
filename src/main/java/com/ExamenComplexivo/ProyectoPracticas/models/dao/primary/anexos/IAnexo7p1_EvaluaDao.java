package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo7;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IAnexo7p1_EvaluaDao extends JpaRepository<Anexo7, Long> {

    @Modifying
    @Query("UPDATE Anexo7 s SET s.documentoAnexo7.id_documentoAnexo7 = :id_documentoAnexo7 WHERE s.idAnexo7 = :idAnexo7")
    void actualizarAnexo7(@Param("id_documentoAnexo7") Long id_documentoAnexo7, @Param("idAnexo7") Long idAnexo7);

}
