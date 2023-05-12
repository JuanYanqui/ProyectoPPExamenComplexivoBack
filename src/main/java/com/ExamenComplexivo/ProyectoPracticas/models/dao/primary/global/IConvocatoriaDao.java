package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IConvocatoriaDao extends JpaRepository<Convocatorias,Long> {
    //Metodo para buscar id de convocatoria
    @Query("SELECT doc.id_documentoConvocatoria FROM Convocatorias con JOIN con.documentoConvocatoria doc WHERE con.idConvocatorias = :id")
    Long findDocumentoIdByConvocatoriaId(@Param("id")Long id);

    //Metodo para actualizar documento
    @Modifying
    @Query("UPDATE Convocatorias s SET s.documentoConvocatoria.id_documentoConvocatoria = :id_documentoConvocatoria WHERE s.idConvocatorias = :idConvocatorias")
    void actualizarDocumentoConvocatoria(@Param("id_documentoConvocatoria") Long id_documentoConvocatoria, @Param("idConvocatorias") Long idConvocatorias);

    @Query("SELECT DISTINCT c FROM Convocatorias c JOIN c.solicitudConvocatorias s JOIN s.estudiantePracticante estu JOIN estu.usuario_estudiante_practicante us  WHERE s.checkPractica = true")
    List<Convocatorias> buscarConvocatoriasConPractica();

}
