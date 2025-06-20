package com.example.timesheet.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for setting up application-wide logging.
 * Provides a Logger bean that can be injected wherever logging is required.
 */
@Configuration
public class LoggingConfig {

    /**
     * Creates and provides a Logger bean for application logging.
     * 
     * @return a Logger instance named "ApplicationLogger"
     */
    @Bean
    public Logger logger() {
        return LogManager.getLogger("ApplicationLogger");
    }
}
