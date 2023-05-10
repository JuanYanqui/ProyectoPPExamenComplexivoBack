package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IConvocatoriaDao extends JpaRepository<Convocatorias,Long> {
    @Query("SELECT doc.id_documentoConvocatoria FROM Convocatorias con JOIN con.documentoConvocatoria doc WHERE con.idConvocatorias = :id")
    Long findDocumentoIdByConvocatoriaId(@Param("id") Long id);



}
