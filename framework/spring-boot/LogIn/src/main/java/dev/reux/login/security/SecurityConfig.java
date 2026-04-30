package dev.reux.login.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration // se maneja como clase de configuracion de Spring
@EnableWebSecurity // habilita la seguridad personalizada para la app
public class SecurityConfig{
    //crea el metodo como un bean gestionado por spring
    @Bean
    //metodo para la encriptacion de la contraseña
    public PasswordEncoder codificaPass(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    //admionistra internamente el componente que verifica las credenciales de usuario usando el userdetailservice y el password encoder
    public AuthenticationManager autenticacion(AuthenticationConfiguration authConfig)
            throws Exception{
        return authConfig.getAuthenticationManager();
    }

    @Bean
          //
                                             //
                                                                //gestor de autenticacion para validar usuarios y contraseñas
    public SecurityFilterChain securityChain(HttpSecurity http, AuthenticationManager authManager)
            throws Exception{
        http.
                csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .securityMatcher("/**")
                .addFilterBefore(
                        new BasicAuthenticationFilter(
                                http.getSharedObject(AuthenticationManager.class)
                        ),
                        UsernamePasswordAuthenticationFilter.class
                );


        return http.build();
    }


}