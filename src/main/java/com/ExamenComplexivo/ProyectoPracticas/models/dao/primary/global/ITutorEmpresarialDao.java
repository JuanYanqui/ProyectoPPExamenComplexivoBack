package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Tutor_Empresarial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ITutorEmpresarialDao extends JpaRepository<Tutor_Empresarial,Long> {

    @Query("SELECT t FROM Tutor_Empresarial t JOIN t.usuario_empresarial u WHERE u.idUsuario = :idUsuario")
    public Tutor_Empresarial findByUsuarioId(@Param("idUsuario") Long idUsuario);


}
