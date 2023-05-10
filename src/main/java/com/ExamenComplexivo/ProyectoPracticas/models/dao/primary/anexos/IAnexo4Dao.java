package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IAnexo4Dao extends JpaRepository<Anexo4, Long> {
    @Modifying
    @Query("UPDATE Anexo4 s SET s.documentoAnexo4.id_documentoAnexo4 = :id_documentoAnexo4 WHERE s.idAnexo4 = :idAnexo4")
    void actualizarAnexo4(@Param("id_documentoAnexo4") Long id_documentoAnexo4, @Param("idAnexo4") Long idAnexo4);


}
