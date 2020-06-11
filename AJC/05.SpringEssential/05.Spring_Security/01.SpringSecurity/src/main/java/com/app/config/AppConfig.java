package com.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({WebConfig.class,JPAConfig.class, SecurityConfig.class})
public class AppConfig {
}
