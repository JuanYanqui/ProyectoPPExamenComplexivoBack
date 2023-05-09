package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@EnableJpaRepositories
public interface IAnexo1Dao extends JpaRepository<Anexo1, Long> {

    @Modifying
    @Query("UPDATE Anexo1 s SET s.documentoAnexo1.id_documentoAnexo1 = :id_documentoAnexo1 WHERE s.idAnexo1 = :idAnexo1")
    void actualizarAnexo1(@Param("id_documentoAnexo1") Long id_documentoAnexo1, @Param("idAnexo1") Long idAnexo1);


}
