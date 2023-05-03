package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Responsable_PPP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IResponsable_PPPDao extends JpaRepository<Responsable_PPP,Long> {

    @Query(value = "SELECT CONCAT(us.nombres, ' ', us.apellidos) FROM Responsable_PPP res JOIN res.usuario_responsable us WHERE res.carrera = ?1")
    List<String> getNombresCompletosDeResponsablesPorCarrera(String carrera);

}
