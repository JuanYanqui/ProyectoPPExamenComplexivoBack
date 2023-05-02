package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;


import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.RolRepositoryDao;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.UsuariosRepositoryDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Rol;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Usuario;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IUsuarioService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IUsuarioService iUsuarioService;

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
    public Usuario show(@PathVariable long id) {
        return iUsuarioService.findById(id);
    }


    //Metodos de Esteban ------------------------------------------------

    @GetMapping()
    public List<Usuario> listarUsuarios() {
        return iUsuarioService.findAllUsuario();
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<List<Usuario>> getAllUserByCedula(@PathVariable("cedula") String cedula) {
        return ResponseEntity.ok(iUsuarioService.buscarUsuario(cedula));

    }

    @GetMapping(value = "/buscar/{id}")
    public Usuario findById(@PathVariable("id") Long id) {
        return this.iUsuarioService.findByIdUsuario(id);
    }

    @GetMapping(value = "/buscarcedula/{cedula}")
    public Usuario findByCedula(@PathVariable("cedula") String cedula) {
        return this.iUsuarioService.findbyCedula(cedula);
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
