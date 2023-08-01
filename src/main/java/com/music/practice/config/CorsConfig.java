package com.music.practice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:3000/") // Allow requests from this origin
                .allowedMethods("GET") // Allow only specific HTTP methods (e.g., GET, POST, etc.)
                .allowCredentials(true); // Allow sending and receiving cookies

    }
}
