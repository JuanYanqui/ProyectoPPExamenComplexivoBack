package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;


import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.RolRepositoryDao;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.UsuariosRepositoryDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.ResetPasswordRequest;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Rol;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Usuario;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IUsuarioService;
import com.ExamenComplexivo.ProyectoPracticas.security.JwtUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/user")

public class UserController {


    private long resetTokenExpirationMs = 3600000L;
    @Autowired
    private IUsuarioService iUsuarioService;

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private RolRepositoryDao rolrepo;
    @Autowired
    private UsuariosRepositoryDao usuariosDao;

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return ResponseEntity.ok().body(iUsuarioService.getUsusarios());
    }

    @PostMapping("/rol/save")
    public ResponseEntity<Rol> saveRol(@RequestBody Rol rol){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/rol/save").toUriString());
        return ResponseEntity.created(uri).body(iUsuarioService.saveRole(rol));
    }

    //AGREGA Y QUITA ROLES
    @PutMapping("/rol/addtouser")
    public ResponseEntity<?> addRoletoUser(@RequestBody RolToUser usuario){
        Set<Rol> roles = new HashSet<>();
        String nrol;
        Usuario user = usuariosDao.findByCedula(usuario.getCedula());

        for (int i = 0; i < rolrepo.findAll().size(); i++) {
            Rol r=rolrepo.findAll().get(i);
            nrol = r.getRolNombre();
            if (usuario.getRoles().contains(nrol)) {
                System.out.println(r.getRolNombre());
                roles.add(r);
            }
        }
        //AGREGA EL ROL SOLICITANTE POR DEFECTO
        user.setRoles(roles);
        iUsuarioService.addRoleToUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Usuario> show(@PathVariable long id) {
        try {
            Usuario usuario = iUsuarioService.findById(id);
            if (usuario != null) {
                return ResponseEntity.ok(usuario);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        try {
            List<Usuario> usuarios = iUsuarioService.findAllUsuario();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/{cedula}")
    public ResponseEntity<List<Usuario>> getAllUserByCedula(@PathVariable("cedula") String cedula) {
        try {
            List<Usuario> usuarios = iUsuarioService.buscarUsuario(cedula);
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping(value = "/buscar/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable("id") Long id) {
        try {
            Usuario usuario = iUsuarioService.findByIdUsuario(id);
            if (usuario != null) {
                return ResponseEntity.ok(usuario);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/buscarcedula/{cedula}")
    public ResponseEntity<Usuario> findByCedula(@PathVariable("cedula") String cedula) {
        try {
            Usuario usuario = iUsuarioService.findbyCedula(cedula);
            if (usuario != null) {
                return ResponseEntity.ok(usuario);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/correo/{correo}")
    public ResponseEntity<Usuario> buscarPorCorreo(@PathVariable String correo) {
        Usuario usuario = iUsuarioService.buscarPorCorreo(correo);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listarconvo/{idConvocatoria}")
    public ResponseEntity<List<Usuario>> getUsuariosPorConvocatoria(@PathVariable Long idConvocatoria) {
        try {
            List<Usuario> usuarios = iUsuarioService.findUsuariosPorConvocatoria(idConvocatoria);
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/rolnombre/{correo}")
    public String getRolNombreByCorreo(@PathVariable String correo) {
        return iUsuarioService.getRolNombreByCorreo(correo);
    }


    @GetMapping("/rol/{rolId}")
    public ResponseEntity<List<Usuario>> getUsuariosByRolId(@PathVariable("rolId") int rolId) {
        try {
            List<Usuario> usuarios = iUsuarioService.getUsuariosByRolId(rolId);
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/rolacademico")
    public ResponseEntity<List<Usuario>> getUsuariosByRolIdAcademico() {
        try {
            List<Usuario> usuarios = iUsuarioService.getUsuariosByRolIdAcademico();
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/reset-password")
    public ResponseEntity<Object> resetPassword(@RequestBody ResetPasswordRequest request) {
        String cedula = request.getCedula();
        String newPassword = request.getNewPassword();

        if (iUsuarioService.resetPassword(cedula, newPassword)) {
            return ResponseEntity.ok().build(); // 200 OK sin cuerpo de respuesta
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found sin cuerpo de respuesta
        }
    }

    @GetMapping("/listartuto/{idUsuario}")
    public ResponseEntity<List<Object[]>> findUsuariosPorTutorEmpresarial(@PathVariable Long idUsuario) {
        try {
            List<Object[]> usuarios = iUsuarioService.findUsuariosPorTutorEmpresarial(idUsuario);
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @GetMapping("/EstudiantesARespon/{idusuario}")
    public ResponseEntity<List<Object[]>> buscarEstudiantesAxresponsable(@PathVariable Long idusuario) {
        try {
            List<Object[]> usuarios = iUsuarioService.buscarEstudiantesAxresponsable(idusuario);
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/ListaTutoresC")
    public ResponseEntity<List<Object[]>> buscarTutoresC() {
        try {
            List<Object[]> usuarios = iUsuarioService.buscarTutoresC();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/listaestudiante/{idUsuario}")
    public ResponseEntity<List<Object[]>> getUsuariosBytutoracademico(@PathVariable("idUsuario") Long idUsuario) {
        try {
            List<Object[]> usuarios = iUsuarioService.getUsuariosBytutoracademico(idUsuario);
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class RolToUser {

    private Set<String> roles = new HashSet<>();
    private String cedula;

}
//git juan
