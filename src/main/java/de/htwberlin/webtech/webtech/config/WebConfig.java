package de.htwberlin.webtech.webtech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings( final CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedMethods("*")
                .allowedOrigins(
                        "http://localhost:8080",
                        "https://webtech-frontend-0186.onrender.com/")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}