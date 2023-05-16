package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface IAnexo2Dao extends JpaRepository<Anexo2, Long> {

    @Modifying
    @Query("UPDATE Anexo2 s SET s.documentoAnexo2.id_documentoAnexo2 = :id_documentoAnexo2 WHERE s.idAnexo2 = :idAnexo2")
    void actualizarAnexo2(@Param("id_documentoAnexo2") Long id_documentoAnexo2, @Param("idAnexo2") Long idAnexo2);

}
