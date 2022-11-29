//package com.coolkids.coolKidsApp.security.config;
//
//import com.coolkids.coolKidsApp.services.userServices.UserServiceImpl;
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@AllArgsConstructor
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//
//    private final UserServiceImpl userServiceImpl;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Bean
//    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(csrf -> csrf.disable())
//                .authorizeRequests(auth -> auth
//                        .anyRequest().authenticated()
//                )
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .httpBasic(Customizer.withDefaults())
//                .build();
////        http.authorizeRequests()
////                .antMatchers("/").authenticated()
////                .anyRequest().permitAll()
////                .and()
////                .formLogin()
////                .usernameParameter("email")
////                .defaultSuccessUrl("/users")
////                .permitAll()
////                .and()
////                .logout().logoutSuccessUrl("/login").permitAll();
//    }
//
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider =
//                new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(bCryptPasswordEncoder);
//        provider.setUserDetailsService(userServiceImpl);
//        return provider;
//    }
//}
