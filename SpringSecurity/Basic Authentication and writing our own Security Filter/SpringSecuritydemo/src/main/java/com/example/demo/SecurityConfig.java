package com.example.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        //        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

    // @Bean
    // public UserDetailsService userDetailsService(){
    //     UserDetails user1 = User.withUsername("user1")
    //             .password("{noop}password1")
    //             .roles("USER")
    //             .build();

    //     UserDetails admin = User.withUsername("admin")
    //             .password("{noop}adminpassword1")
    //             .roles("ADMIN")
    //             .build();

    //     return new InMemoryUserDetailsManager(user1, admin);
    // }
}