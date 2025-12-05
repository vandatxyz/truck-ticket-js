package com.anoystick.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(jsr250Enabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/css/**",
                                "/js/**",
                                "/images/**",
                                "/user/info"
                        ).permitAll()
//                        .requestMatchers("/user/vip").hasRole("ADMIN")
//                        .requestMatchers("/user/normal").hasAnyRole("USER","ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")   // URL controller
                        .permitAll()
                        .defaultSuccessUrl("/user/vip", true)
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailServices(){
        UserDetails root = User.withDefaultPasswordEncoder()
                .username("root")
                .password("root")
                .authorities("ROLE_ADMIN")
                .build();

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("datnv")
                .password("123456")
                .authorities("ROLE_USER")
                .build();

        return new InMemoryUserDetailsManager(root, user);
    }


}
