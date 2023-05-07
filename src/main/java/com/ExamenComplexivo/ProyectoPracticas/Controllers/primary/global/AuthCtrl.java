package com.ExamenComplexivo.ProyectoPracticas.Controllers.primary.global;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.RolRepositoryDao;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.UsuariosRepositoryDao;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.secundary.IverDocentesFDao;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.secundary.IverEstudianteFDao;
import com.ExamenComplexivo.ProyectoPracticas.models.dtos.request.LoginRequest;
import com.ExamenComplexivo.ProyectoPracticas.models.dtos.request.SignupRequest;
import com.ExamenComplexivo.ProyectoPracticas.models.dtos.response.MessageResponse;
import com.ExamenComplexivo.ProyectoPracticas.models.dtos.response.UserInfoResponse;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Rol;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Usuario;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.UsuarioPrincipal;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verdocentef;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verestudiantef;
import com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.impl.IDocenteFenixService;
import com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.impl.IEstudianteFenixService;
import com.ExamenComplexivo.ProyectoPracticas.security.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthCtrl {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuariosRepositoryDao userRepository;

    @Autowired
    RolRepositoryDao roleRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    IverDocentesFDao verdocentes;
    @Autowired
    private IDocenteFenixService docenteFenix;

    @Autowired
    IverEstudianteFDao verestudiante;
    @Autowired
    private IEstudianteFenixService estudianteFenix;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        if(userRepository.existsByCorreo(loginRequest.getCorreo())){
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getCorreo(), loginRequest.getContrasenia()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            UsuarioPrincipal userDetails = (UsuarioPrincipal) authentication.getPrincipal();
            ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);


            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                    .body(new UserInfoResponse(
                            userDetails.getIdUsuario(),
                            userDetails.getCorreo(),
                            userDetails.getNombres(),
                            userDetails.getApellidos(),
                            roles));
        }else{
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("No registrado!"));

        }

    }
    @PostMapping("/crear")
    public ResponseEntity<?> registerPersona(@RequestBody SignupRequest signUpRequest) {
        Usuario user = new Usuario(signUpRequest.getCedula(),
                signUpRequest.getNombres(),
                signUpRequest.getApellidos(),
                signUpRequest.getCarrera(),
                passwordEncoder.encode(signUpRequest.getContrasenia()),
                signUpRequest.getCorreo(),
                signUpRequest.getPersona_empresa());
        Set<String> strRoles = signUpRequest.getRoles();
        Set<Rol> roles = new HashSet<>();
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
    @PostMapping("/signupdocente")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        //Estamos verificando si esa en nuestra bd..
        if (!userRepository.existsByCedula(signUpRequest.getCedula())) {

            //Estamos verificando si el usuario que va registrarse esta en Fenix..
            if (verdocentes.existsByCedula(signUpRequest.getCedula())) {

                //Estamos comprobando que no se ingrese un correo que ya fue ingresado..
                if(!userRepository.existsByCorreo(signUpRequest.getCorreo())){
                    Usuario user = new Usuario(signUpRequest.getCedula(),
                            signUpRequest.getNombres(),
                            signUpRequest.getApellidos(),
                            signUpRequest.getCarrera(),
                            passwordEncoder.encode(signUpRequest.getContrasenia()),
                            signUpRequest.getCorreo(),
                            signUpRequest.getPersona_empresa());


                    Set<String> strRoles = signUpRequest.getRoles();
                    Set<Rol> roles = new HashSet<>();


                    user.setRoles(roles);
                    userRepository.save(user);

                    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

                }else{
                    return ResponseEntity
                            .badRequest()
                            .body(new MessageResponse("Error: Usted no puede ingresar un correo existente!"));
                }

            }else{
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: El usuario no esta en FENIX!"));
            }

        }else{
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Usuario ya esta en la BD!"));
        }

    }

    @PostMapping("/signupestudiante")
    public ResponseEntity<?> registerUserestudiante(@RequestBody SignupRequest signUpRequest) {
        //Estamos verificando si esa en nuestra bd..
        if (!userRepository.existsByCedula(signUpRequest.getCedula())) {

            //Estamos verificando si el usuario que va registrarse esta en Fenix..
            if (verestudiante.existsByCedula(signUpRequest.getCedula())) {

                //Estamos comprobando que no se ingrese un correo que ya fue ingresado..
                if(!userRepository.existsByCorreo(signUpRequest.getCorreo())){
                    Usuario user = new Usuario(signUpRequest.getCedula(),
                            signUpRequest.getNombres(),
                            signUpRequest.getApellidos(),
                            signUpRequest.getCarrera(),
                            passwordEncoder.encode(signUpRequest.getContrasenia()),
                            signUpRequest.getCorreo(),
                            signUpRequest.getPersona_empresa());

                    Set<String> strRoles = signUpRequest.getRoles();
                    Set<Rol> roles = new HashSet<>();

                    if (strRoles == null || strRoles.isEmpty()) {
                        Rol userRole = roleRepository.findbynombre("ROLE_ESTUDIANTE");
                        roles.add(userRole);
                    }

                    user.setRoles(roles);
                    userRepository.save(user);

                    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

                }else{
                    return ResponseEntity
                            .badRequest()
                            .body(new MessageResponse("Error: Usted no puede ingresar un correo existente!"));
                }

            }else{
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: El usuario no es un estudiante"));
            }

        }else{
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Usuario ya esta en la BD!"));
        }

    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }

    @GetMapping("/docentefenix/{cedula}")
    public verdocentef buscardocente(@PathVariable String cedula){
        return docenteFenix.findById(cedula);
    }

    @GetMapping("/estudiantefenix/{cedula}")
    public verestudiantef buscarestudiante(@PathVariable String cedula){
        return estudianteFenix.findById(cedula);
    }

    @GetMapping("/listardocentes")
    public ResponseEntity<List<verdocentef>> obtenerListali() {
        return new ResponseEntity<>(docenteFenix.findAll(), HttpStatus.OK);
    }


}
