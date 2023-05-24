package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.List;
@Transactional
public interface ISolicitudPracticasDao extends JpaRepository<Solicitud_Practicas,Long> {

    @Query("SELECT s FROM Solicitud_Practicas s WHERE s.estadoActividad = true")
    List<Solicitud_Practicas> findByEstadoActividadTrue();

    @Query("SELECT s FROM Solicitud_Practicas s JOIN s.responsablePPP respo WHERE s.estadoActividad = true and s.estadoConvocatoria = false and respo.idResponsablePPP = :idresponsableppp")
    List<Solicitud_Practicas> findByEstadoActividadTruePorResponsablePPP(@Param("idresponsableppp") Long idresponsableppp);

    List<Solicitud_Practicas> findByEstadoSolicitud(boolean estado);

    //query buscar solicitudes por el nombre de carrera que ingresa el responsableppp
    @Query("SELECT s FROM Solicitud_Practicas s WHERE s.estadoSolicitud = false and s.nombre_carrera = :carrera")
    List<Solicitud_Practicas> findByEstadoSolicitudPorcarrera(@Param("carrera") String carrera);

    //query buscar solicitudes por el nombre de carrera que ingresa el responsableppp para asignaractividades con estado true
    @Query("SELECT s FROM Solicitud_Practicas s WHERE s.estadoSolicitud = true and s.nombre_carrera = :carrera")
    List<Solicitud_Practicas> findByEstadoSolicitudPorcarreraSolicitudaprobada(@Param("carrera") String carrera);

    @Modifying
    @Query("UPDATE Solicitud_Practicas s SET s.documentoSolicitudPracticas.id_documentoSolicitudPrc = :id_documentoSolicitudPrc WHERE s.idSolicitudPracticas = :idSolicitudPracticas")
    void actualizarDocumentoSolicitudPrc(@Param("id_documentoSolicitudPrc") Long id_documentoSolicitudPrc, @Param("idSolicitudPracticas") Long idSolicitudPracticas);

    //Metodo para buscar el id del documento
    @Query("SELECT doc.id_documentoSolicitudPrc FROM Solicitud_Practicas con JOIN con.documentoSolicitudPracticas doc WHERE con.idSolicitudPracticas = :id")
    Long findDocumentoIdBySolicitudId(@Param("id")Long id);


    ///metodo para listar solicitudes por empresa
    @Query("SELECT s FROM Solicitud_Practicas s JOIN s.tutorEmpresarial tuto JOIN tuto.empresa empre WHERE s.estadoSolicitud = true and empre.idEmpresa = :idempresa")
    List<Solicitud_Practicas> findByEsta(@Param("idempresa") Long idempresa);

    @Query("SELECT s FROM Solicitud_Practicas s JOIN s.tutorEmpresarial tuto JOIN tuto.empresa empre WHERE  empre.idEmpresa = :idempresa")
    List<Solicitud_Practicas> findbyTodas(@Param("idempresa") Long idempresa);

    ///listar tutores por empresa
    @Query("SELECT us FROM Usuario us JOIN us.tutorEmpresarial tuto JOIN tuto.empresa empre WHERE empre.idEmpresa= :idempresa")
    List<Usuario> findAllNombresTutores(@Param("idempresa") Long idempresa);

    @Query("SELECT s FROM Solicitud_Practicas s JOIN s.responsablePPP res JOIN res.solicitudConvocatorias soli JOIN soli.tutorEmpresarial tuto JOIN tuto.empresa empre WHERE soli.checkResponsable = true and empre.idEmpresa = :idempresa")
    List<Solicitud_Practicas> findBySolicitudpracticasCheckResponsable(@Param("idempresa") Long idempresa);

    @Query("SELECT  DISTINCT s FROM Convocatorias c JOIN c.solicitudPracticas s JOIN s.tutorEmpresarial tuto JOIN tuto.empresa empre JOIN c.solicitudConvocatorias soli WHERE soli.checkResponsable = true and empre.idEmpresa = :idempresa")
    List<Solicitud_Practicas> buscarsoliporempresa(@Param("idempresa") Long idempresa);

    @Query("SELECT sp.nombreSolicitud, sp.fechaEnvioSolicitud, sp.fechaAceptacion FROM Usuario u JOIN u.tutorEmpresarial te JOIN te.solicitudPracticas sp WHERE u.idUsuario = :idUsuario")
    List<Object[]> buscarsolportutor(@Param("idUsuario") Long idUsuario);

    @Query("SELECT sp.nombreSolicitud, sp.fechaEnvioSolicitud, sp.fechaAceptacion FROM Usuario u JOIN u.tutorEmpresarial te JOIN te.solicitudPracticas sp WHERE sp.estadoSolicitud = true AND u.idUsuario = :idUsuario")
    List<Object[]> buscarsolportutoraceptadas(@Param("idUsuario") Long idUsuario);


}

