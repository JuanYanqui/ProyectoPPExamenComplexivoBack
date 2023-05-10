package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo5;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IAnexo5Dao extends JpaRepository<Anexo5, Long> {

    @Modifying
    @Query("UPDATE Anexo5 s SET s.documentoAnexo5.id_documentoAnexo5 = :id_documentoAnexo5 WHERE s.idAnexo5 = :idAnexo5")
    void actualizarAnexo5(@Param("id_documentoAnexo5") Long id_documentoAnexo5, @Param("idAnexo5") Long idAnexo5);

}
