package com.obapi.apique.configuration;

import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http
               .authorizeHttpRequests((requests) -> requests
                       .requestMatchers("/login").permitAll()
                       .anyRequest().authenticated()
               )
               .formLogin((form) -> form
                       .loginPage("/login").permitAll()
                       .defaultSuccessUrl("/home", true)
               )
               .cors(withDefaults());

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD",
                "GET", "POST", "PUT", "DELETE", "PATCH"));
        // setAllowCredentials(true) is important, otherwise:
        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
        configuration.setAllowCredentials(true);
        // setAllowedHeaders is important! Without it, OPTIONS preflight request
        // will fail with 403 Invalid CORS request
        configuration.setAllowedHeaders(List.of("*"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("Joe")
                        .password("APIQUE@2024")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
//
//    @Value("${tls.enableMatls}")
//    private boolean enableMatls;
//
//    @Value("${tls.keyStore.type:JKS}")
//    private String keyStoreType;
//
//    @Value("${tls.keyStore.location}")
//    private String keyStoreLocation;
//
//    @Value("${tls.keyStore.password}")
//    private String keyStorePassword;
//
//    @Value("${tls.trustStore.location}")
//    private String trustStoreLocation;
//
//    @Value("${tls.trustStore.password}")
//    private String trustStorePassword;
//
//    public boolean isEnableMatls() { return enableMatls; }
//
//    public String getKeyStoreType() {
//        return keyStoreType;
//    }
//
//    public String getKeyStoreLocation() {
//        return keyStoreLocation;
//    }
//
//    public String getKeyStorePassword() {
//        return keyStorePassword;
//    }
//
//    public String getTrustStoreLocation() {
//        return trustStoreLocation;
//    }
//
//    public String getTrustStorePassword() {
//        return trustStorePassword;
//    }

}
