package com.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import com.app.config.JPAConfig;

@Configuration
//@ComponentScan("com.app")
@Import(JPAConfig.class)
public class AppConfig {
}
