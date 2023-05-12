package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface IPracticaDao extends JpaRepository<Practica,Long> {
    @Query("SELECT p FROM Practica p JOIN p.solicitudConvocatoria sol  WHERE sol.checkPractica = true AND p.checkEmpresarial = true")
    List<Practica> getPracticasAprobadas();


    @Query("SELECT p " +
            "FROM Convocatorias c " +
            "JOIN c.solicitudConvocatorias sc JOIN sc.practica p JOIN sc.estudiantePracticante estu JOIN estu.usuario_estudiante_practicante uspra WHERE sc.checkPractica = true AND sc.checkEmpresarial = true AND p.checkAcademico = false AND c.idConvocatorias = :convocatoriaId")
    List<Practica> getPracticasByConvocatoriaId(Long convocatoriaId);

    @Modifying
    @Query("UPDATE Practica s SET s.documentoasignacionaca.id_documentoasigtutoracademico = :id_documentoasigtutoracademico WHERE s.idPractica = :idPractica")
    void actualizarDocumentoAsigTutorAc(@Param("id_documentoasigtutoracademico") Long id_documentoasigtutoracademico, @Param("idPractica") Long idPractica);
}
