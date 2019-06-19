package com.cdt.be.infrastructure.security;

import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

  /**
   * Allow all cross-origin requests.
   */
  @Bean
  public CorsFilter corsFilter() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    final CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.setAllowedOrigins(Collections.singletonList("*"));
    config.setAllowedHeaders(List.of("Origin", "Content-Type", "Accept"));
    config.setAllowedMethods(List.of("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
  }
}
