package com.proyecto.integral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
import com.proyecto.integral.model.service.UserService;

@Configuration
public class SpringSecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    public static BCryptPasswordEncoder encriptarPassword(){
        return new BCryptPasswordEncoder(); 
    }

    @Autowired
    public void criptografiaPassword(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(encriptarPassword());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
        .anyRequest().authenticated()
        .and().formLogin().loginPage("/").defaultSuccessUrl("/principal",true).permitAll()
        .and().logout().permitAll();
        return http.build();
    }
    
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
        return (web)->web.ignoring().antMatchers("/css/**","/js/**","/images/**");
    }

    //Los usuarios en memoria ya no son necesarios por eso se comentan
    //Ahora se usan usuarios en base de datos con contraseña encriptada
    /*
    @Bean
    public InMemoryUserDetailsManager configureAuthentication(){
        List<UserDetails> listaUsuarios = new ArrayList<>();
        List<GrantedAuthority> rolesAdministradores = new ArrayList<>();
        List<GrantedAuthority> rolesUsuarios = new ArrayList<>();

        rolesAdministradores.add(new SimpleGrantedAuthority("ADMIN"));
        rolesUsuarios.add(new SimpleGrantedAuthority("USER"));
        
        listaUsuarios.add(new User("Administrador", "{noop}123456", rolesAdministradores));
        listaUsuarios.add(new User("Jorge", "{noop}123456", rolesUsuarios));

        return new InMemoryUserDetailsManager(listaUsuarios); 
    }*/
}
