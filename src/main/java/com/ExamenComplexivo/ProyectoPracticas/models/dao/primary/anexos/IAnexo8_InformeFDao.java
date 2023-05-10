package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo8;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IAnexo8_InformeFDao extends JpaRepository<Anexo8, Long> {

    @Modifying
    @Query("UPDATE Anexo8 s SET s.documentoAnexo8.id_documentoAnexo8 = :id_documentoAnexo8 WHERE s.idAnexo8 = :idAnexo8")
    void actualizarAnexo8(@Param("id_documentoAnexo8") Long id_documentoAnexo8, @Param("idAnexo8") Long idAnexo8);

}
