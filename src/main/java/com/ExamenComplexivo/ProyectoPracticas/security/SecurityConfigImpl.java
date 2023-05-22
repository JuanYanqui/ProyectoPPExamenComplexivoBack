package com.ExamenComplexivo.ProyectoPracticas.security;

import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl.IUsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
//@EnableWebSecurity este taba comeee
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class SecurityConfigImpl { // extends WebSecurityConfigurerAdapter {
	@Autowired
	IUsuarioServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
				.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeRequests().antMatchers("/swagger-ui/index.html", "/api/auth/**", "/api/docentefenix/{cedula}",
						"/api/estudiantefenix/{cedula}","/api/user/**","/api/personaemp/**", "/api/tutorEmp/**","/apitutorEmp/buscar/{id}/**",
						"/api/empresa/**","/swagger-ui/index.html#/**", "/api/solicitudPractica/**", "/api/convenio/**",
						"/api/convocatorias/listar/**","/api/convocatorias/crear/**","/api/solicitudPractica/**", "/api/convenio/**",
						"/api/detalleConvenio/**", "/api/verMaterias/**", "/api/verCarreras/**", "/api/representantePPP/**", "/api/empresa/listar/**",
						"/api/empresa/buscar{id}/**","/api/jasperReport/**", "/api/documentoSolicitudPracticas/**","/api/jasperReport/descargar/**",
						"/api/documentoAnexo1/**","/api/documentoAnexo4/**","/api/documentoAnexo5/**", "/api/documentoAnexo6/**","/api/documentoAnexo7/**",
						"/api/documentoAnexo8/**","/api/requerimientos/**", "/api/documentoAnexo6/**","/api/documentoAnexo7/**","/api/documentoAnexo8/**",
						"/api/requerimientos/**","/api/actividades/**", "/api/convocatorias/**","/api/documentoConvocatoria/**","/api/documentoConvenio/**",
						"/api/solicitudConvocatoria/**", "/api/actividades/**", "/api/convocatorias/**", "/api/solicitudConvocatoria/**", "/api/estudiantepracticante/**",
						"/api/documentoSolicitudConvocatoria/**", "/api/solicitudPractica/**","/api/anexo1/**","/api/anexo2/**","/api/anexo3/**","/api/anexo4/**",
						"/api/anexo5/**","/api/anexo6/**","/api/anexo7/**","/api/anexo8/**", "/api/documentoConvocatoria/download/**", "/api/imagen/crear/**",
						"/api/solicitudPractica/buscar/**","/api/documentoAsigTutorAcademico/**","/api/documentoAsigTutorEmpresarial/**", "/api/practica/**","/api/documentoAnexo3/**","/api/documentoAnexo2/**", "/api/documentoAnexo1/**").permitAll()
				.anyRequest().authenticated();


		http.authenticationProvider(authenticationProvider());

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}