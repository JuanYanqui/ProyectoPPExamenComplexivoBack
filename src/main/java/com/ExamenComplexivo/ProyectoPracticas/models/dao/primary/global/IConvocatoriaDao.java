package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Personas_empresa;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
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

    @Query("SELECT s FROM Convocatorias s JOIN s.solicitudPracticas soli WHERE s.estadoConvocatoria = true and soli.nombre_carrera = :carrera")
    List<Convocatorias> findByConvocatoriaporCarrera(@Param("carrera") String carrera);

    @Query("SELECT c FROM Convocatorias c JOIN c.solicitudPracticas soli WHERE soli.idSolicitudPracticas = :idSolicitudPracticas")
    List<Convocatorias> findByConvocatoriaporSolicitudP(@Param("idSolicitudPracticas") Long idSolicitudPracticas);

    @Query("SELECT DISTINCT c FROM Convocatorias c JOIN c.solicitudPracticas s JOIN s.tutorEmpresarial tuto JOIN tuto.empresa empre JOIN c.solicitudConvocatorias soli WHERE soli.checkResponsable = true and empre.idEmpresa = :idempresa")
    List<Convocatorias> buscarsoliporempresacovocatoria(@Param("idempresa") Long idempresa);

    @Query("SELECT DISTINCT c FROM Convocatorias c JOIN c.solicitudPracticas s JOIN s.tutorEmpresarial tuto JOIN tuto.empresa empre JOIN c.solicitudConvocatorias soli WHERE soli.checkResponsable = true and s.estadoSolicitud = true and empre.idEmpresa = :idempresa")
    List<Convocatorias> buscarsoliporempresacovocatoriaconestadosolicitud(@Param("idempresa") Long idempresa);


    @Query("SELECT DISTINCT s FROM Convocatorias s JOIN s.solicitudPracticas soli JOIN s.solicitudConvocatorias solcon WHERE solcon.checkPractica = true and soli.nombre_carrera = :carrera")
    List<Convocatorias> findByConvocatoriaporCarreraPractica(@Param("carrera") String carrera);

    //lista de convocatorias
    @Query("select c.nombreConvocatoria, sol.nombreSolicitud, sol.fechaEnvioSolicitud, sol.fechaAceptacion from Convocatorias c join c.solicitudPracticas sol")
    List<Object[]> buscarConvocatoriasC();

    
    @Query("SELECT c.nombreConvocatoria, c.fechaPublicacion, c.fechaExpiracion, sp.nombre_carrera, c.estadoConvocatoria, sc.fechaAprobacion " +
            "FROM Convocatorias c " +
            "JOIN c.solicitudConvocatorias sc " +
            "JOIN c.solicitudPracticas sp WHERE sp.responsablePPP.idResponsablePPP= :idResponsablePPP ORDER BY sc.fechaAprobacion DESC")
    List<Object[]> listarConvocatorias(@Param("idResponsablePPP") Long idResponsablePPP);

    @Query("SELECT s FROM Convocatorias s JOIN s.solicitudPracticas soli WHERE soli.nombre_carrera = :carrera")
    List<Convocatorias> BuscarConvocatoriaporCarrera(@Param("carrera") String carrera);
}
