package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo6;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IAnexo6_DetallePracticaDao extends JpaRepository<Anexo6, Long> {

    @Modifying
    @Query("UPDATE Anexo6 s SET s.documento_anexo6.id_documentoAnexo6 = :id_documentoAnexo6 WHERE s.idAnexo6 = :idAnexo6")
    void actualizarAnexo6(@Param("id_documentoAnexo6") Long id_documentoAnexo6, @Param("idAnexo6") Long idAnexo6);


}
