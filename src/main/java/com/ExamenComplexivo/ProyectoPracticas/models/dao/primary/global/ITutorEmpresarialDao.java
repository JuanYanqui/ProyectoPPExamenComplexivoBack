package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Tutor_Empresarial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ITutorEmpresarialDao extends JpaRepository<Tutor_Empresarial,Long> {

       @Query("SELECT t FROM Tutor_Empresarial t JOIN t.usuario_empresarial u WHERE u.idUsuario = :idUsuario")
    public Tutor_Empresarial findByUsuarioId(@Param("idUsuario") Long idUsuario);
    /*
    @Query("SELECT t.idTutorEmpresarial ,e.nombreEmpresa, CONCAT(u.nombres, ' ', u.apellidos) AS nombre, u.correo, t.numeroContacto " +
            "FROM Tutor_Empresarial t " +
            "JOIN Empresa e ON e.idEmpresa = t.empresa.idEmpresa " +
            "JOIN Usuario u ON u.idUsuario = t.usuario_empresarial.idUsuario " +
            "WHERE t.estado=TRUE " +
            "ORDER BY t.idTutorEmpresarial ASC")
    List<Object[]> obtenerInfoEmpresasYUsuarios();
    */

    @Query("SELECT t.idTutorEmpresarial, e.nombreEmpresa, CONCAT(u.nombres, ' ', u.apellidos) AS nombre, u.correo, t.numeroContacto " +
            "FROM Tutor_Empresarial t " +
            "JOIN t.empresa e " +
            "JOIN t.usuario_empresarial u " +
            "JOIN t.solicitudPracticas sp " +
            "WHERE t.estado = true AND sp.responsablePPP.idResponsablePPP =:idResponsablePPP " +
            "ORDER BY t.idTutorEmpresarial ASC")
    List<Object[]> obtenerInfoEmpresasYUsuarios(@Param("idResponsablePPP") Long idResponsablePPP);


    @Modifying
    @Query("UPDATE Tutor_Empresarial SET estado=FALSE WHERE idTutorEmpresarial= :idTutorEmpresarial")
    void actualizarTutorEmpresarial(@Param("idTutorEmpresarial") Long idTutorEmpresarial);

}
