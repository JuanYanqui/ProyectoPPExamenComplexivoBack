package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Responsable_PPP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IResponsable_PPPDao extends JpaRepository<Responsable_PPP,Long> {

    @Query(value = "SELECT CONCAT(us.nombres, ' ', us.apellidos) as nombre FROM Responsable_PPP res JOIN res.usuario_responsable us WHERE res.carrera = ?1")
    List<String> getNombresCompletosDeResponsablesPorCarrera(String carrera);

    @Query(value = "SELECT res.idresponsableppp FROM responsable_ppp res JOIN usuarios us ON us.idusuario = res.idusuario WHERE res.carrera = :nombreCarrera", nativeQuery = true)
    Integer buscarResponsablePorCarrera(@Param("nombreCarrera") String nombreCarrera);


    @Query("SELECT r FROM Responsable_PPP r JOIN r.usuario_responsable u WHERE u.cedula = :cedula")
    Responsable_PPP findByCedulaUsuario(@Param("cedula") String cedula);
}
