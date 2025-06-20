package com.example.timesheet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configures security settings for the application, including HTTP security and password encoding.
 * This class sets up authentication requirements for specific endpoints and provides a password encoder bean.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Configures HTTP security for the application.
     * Secures the /api/timesheet/** endpoints to require authentication and enables HTTP Basic authentication.
     *
     * @param http the HttpSecurity to modify
     * @throws Exception if an error occurs while configuring security
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            // Require authentication for all /api/timesheet/** endpoints
            .antMatchers("/api/timesheet/**").authenticated()
            .and()
            // Enable HTTP Basic authentication
            .httpBasic();
    }

    /**
     * Provides a password encoder bean using BCrypt hashing algorithm.
     *
     * @return a PasswordEncoder instance
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
