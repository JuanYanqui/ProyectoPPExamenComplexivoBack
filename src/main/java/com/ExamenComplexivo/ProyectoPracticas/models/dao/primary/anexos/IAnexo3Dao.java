package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IAnexo3Dao extends JpaRepository<Anexo3, Long> {

    @Modifying
    @Query("UPDATE Anexo3 s SET s.documentoAnexo3.id_documentoAnexo3 = :id_documentoAnexo3 WHERE s.idAnexo3 = :idAnexo3")
    void actualizarAnexo3(@Param("id_documentoAnexo3") Long id_documentoAnexo3, @Param("idAnexo3") Long idAnexo3);

}
